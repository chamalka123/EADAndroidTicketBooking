package com.example.transportead;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import java.util.List;

public class ReservationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations_view); // Replace with your layout XML file

        // Initialize Retrofit and the API interface
        Retrofit retrofit = NetworkService.getClient();
        ReservationsApi reservationApi = retrofit.create(ReservationsApi.class); // Assuming you have a ReservationApi interface

        // Make an API request to get reservation data
        Call<List<Reservations>> call = reservationApi.getReservations(); // Assuming you have a getReservations() method in your ReservationApi
        call.enqueue(new Callback<List<Reservations>>() {
            @Override
            public void onResponse(Call<List<Reservations>> call, Response<List<Reservations>> response) {
                if (response.isSuccessful()) {
                    List<Reservations> reservations = response.body();
                    // Process and display the reservation data (e.g., update UI elements)
                } else {
                    Log.e("ReservationActivity", "Failed to retrieve reservation data");
                }
            }

            @Override
            public void onFailure(Call<List<Reservations>> call, Throwable t) {
                Log.e("ReservationActivity", "API call failed", t);
            }
        });
    }
}

