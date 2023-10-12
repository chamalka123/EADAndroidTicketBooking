package com.example.transportead;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class SummaryActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // Retrieve data from the intent
        Intent intent = getIntent();
        String reservationDate = intent.getStringExtra("ReservationDate");
        String passengerName = intent.getStringExtra("PassengerName");
        String phoneNumber = intent.getStringExtra("PhoneNumber");
        String destination = intent.getStringExtra("Destination");
        String time = intent.getStringExtra("Time");

        // Display the data in TextViews or other UI components in the layout
        TextView txtReservationDate = findViewById(R.id.txtReservationDate);
        TextView txtPassengerName = findViewById(R.id.txtPassengerName);
        TextView txtPhoneNumber = findViewById(R.id.txtPhoneNumber);
        TextView txtDestination = findViewById(R.id.txtDestination);
        TextView txtTime = findViewById(R.id.txtTime);

        txtReservationDate.setText(reservationDate);
        txtPassengerName.setText(passengerName);
        txtPhoneNumber.setText(phoneNumber);
        txtDestination.setText(destination);
        txtTime.setText(time);

        Button confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save data to the database (you can use your existing code for this)
                postDataToDB(reservationDate, passengerName, phoneNumber, destination, time);
                // Optionally, you can also add code to navigate to a different activity or perform other actions
            }
        });
    }

    private void postDataToDB(String vnum, String pw, String v_type, String f_type, String chesis_n) {
        try {
            // url to post the user data
            String url = "http://172.28.1.50:8080/api/User";
            HashMap<String, String> params = new HashMap<String, String>();
            params.put("ReservationDate", vnum);
            params.put("Time", pw);
            params.put("PassengerName", v_type);
            params.put("PhoneNumber", f_type);
            params.put("Destination", chesis_n);
            JsonObjectRequest req = new JsonObjectRequest(url, new JSONObject(params),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                VolleyLog.v("Response:%n %s", response.toString(4));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.e("Error: ", error.getMessage());
                }
            });
            requestQueue = Volley.newRequestQueue(SummaryActivity.this);
            requestQueue.add(req);
        } catch (Exception e) {
        }
    }
}
