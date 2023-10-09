package com.example.transportead;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    Button btnbmn,btnque, btnTT, btnmnage, reports;
    TextView feedbackTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnbmn = findViewById(R.id.btnqr);

        btnbmn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(Home.this, UserProfile.class));
            }
        });

        btnque = findViewById(R.id.btnque);

        btnque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(Home.this, UserProfile.class));
            }
        });



        btnTT = findViewById(R.id.btnacc);
        btnTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, UserProfile.class));
            }
        });

        btnmnage = findViewById(R.id.btnmnage);
        btnmnage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, UserProfile.class));
            }
        });

        reports = findViewById(R.id.btnbmn4);
        reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, UserProfile.class));
            }
        });
    }
}