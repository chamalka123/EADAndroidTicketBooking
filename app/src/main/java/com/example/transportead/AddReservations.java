package com.example.transportead;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddReservations extends AppCompatActivity {
    private static final String BASE_URL = "http://localhost:5253/"; // Use the correct base URL from your launchSettings.json

    EditText ReservationDate, PassengerName, PhoneNumber, Destination, Time;
    Button btnaddReservations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);

        btnaddReservations = findViewById(R.id.userregibtn);
        ReservationDate = findViewById(R.id.ReservationDate);
        PassengerName = findViewById(R.id.PassengerName);
        PhoneNumber = findViewById(R.id.PhoneNumber);
        Destination = findViewById(R.id.Destination);
        Time = findViewById(R.id.Time);

        btnaddReservations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reservationDate = ReservationDate.getText().toString();
                String passengerName = PassengerName.getText().toString();
                String phoneNumber = PhoneNumber.getText().toString();
                String destination = Destination.getText().toString();
                String time = Time.getText().toString();

                if (reservationDate.isEmpty() || passengerName.isEmpty() || phoneNumber.isEmpty() || destination.isEmpty() || time.isEmpty()) {
                    Toast.makeText(AddReservations.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                } else {
                    // Create a Retrofit instance
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    // Create an instance of the API service
                    ReservationsApi reservationsApi = retrofit.create(ReservationsApi.class);

                    // Create a Reservations object with the data you want to insert
                    Reservations reservations = new Reservations();
                    reservations.setReservationDate(reservationDate);
                    reservations.setPassengerName(passengerName);
                    reservations.setPhoneNumber(phoneNumber);
                    reservations.setDestination(destination);
                    reservations.setTime(time);
                    reservations.setCancelled(false);

                    // Send the POST request
                    Call<Reservations> call = reservationsApi.createReservation(reservations);

                    call.enqueue(new Callback<Reservations>() {
                        @Override
                        public void onResponse(Call<Reservations> call, Response<Reservations> response) {
                            if (response.isSuccessful()) {
                                Reservations createdReservation = response.body();
                                // Handle the response, such as displaying reservation data
                                Toast.makeText(AddReservations.this, "Reservation created successfully.", Toast.LENGTH_SHORT).show();
                                // You can navigate to another activity here if needed
                            } else {
                                // Handle errors, such as displaying an error message
                                Toast.makeText(AddReservations.this, "Failed to create reservation. Please try again.", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Reservations> call, Throwable t) {
                            // Handle network failures
                            Toast.makeText(AddReservations.this, "Network request failed. Please check your connection.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
