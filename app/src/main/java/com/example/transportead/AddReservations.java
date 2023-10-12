package com.example.transportead;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

public class AddReservations extends AppCompatActivity {

    EditText ReservationDate, PassengerName, PhoneNumber, Destination, Time;
    Button btnaddReservations;

    private DBHelper DB;

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);
        DB = new DBHelper(this);
        btnaddReservations = findViewById(R.id.userregibtn);
        ReservationDate = findViewById(R.id.ReservationDate);
        PassengerName = findViewById(R.id.PassengerName);
        PhoneNumber = findViewById(R.id.PhoneNumber);
        Destination = findViewById(R.id.Destination);
        Time = findViewById(R.id.Time);

        btnaddReservations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String vnum, pw, v_type, f_type, chesis_n;
                vnum = ReservationDate.getText().toString();
                pw = Time.getText().toString();
                v_type = PassengerName.getText().toString();
                f_type = PhoneNumber.getText().toString();
                chesis_n = Destination.getText().toString();

                if (vnum.equals("") || pw.equals("") || v_type.equals("") || f_type.equals("") || chesis_n.equals("")) {
                    Toast.makeText(AddReservations.this, "You should fill all fields !!", Toast.LENGTH_SHORT).show();
                }
                     else {
                        // Create an intent to open the summary page
                        Intent intent = new Intent(AddReservations.this, SummaryActivity.class);
                        intent.putExtra("ReservationDate", vnum);
                        intent.putExtra("Time", pw);
                        intent.putExtra("PassengerName", v_type);
                        intent.putExtra("PhoneNumber", f_type);
                        intent.putExtra("Destination", chesis_n);
                        startActivity(intent);

                }
            }
        });
    }

//    // implementation to post the vehicle owner data to DB
//    private void postDataToDB(String vnum, String pw, String v_type, String f_type, String chesis_n) {
//        try {
//            // url to post the user data
//            String url = "http://172.28.1.50:8080/api/User";
//            HashMap<String, String> params = new HashMap<String, String>();
//            params.put("ReservationDate", vnum);
//            params.put("Time", pw);
//            params.put("PassengerName", v_type);
//            params.put("PhoneNumber", f_type);
//            params.put("Destination", chesis_n);
//            JsonObjectRequest req = new JsonObjectRequest(url, new JSONObject(params),
//                    new Response.Listener<JSONObject>() {
//                        @Override
//                        public void onResponse(JSONObject response) {
//                            try {
//                                VolleyLog.v("Response:%n %s", response.toString(4));
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    VolleyLog.e("Error: ", error.getMessage());
//                }
//            });
//            requestQueue = Volley.newRequestQueue(AddReservations.this);
//            requestQueue.add(req);
//        } catch (Exception e) {
//        }
//    }
}
