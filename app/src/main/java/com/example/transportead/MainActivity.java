package com.example.transportead;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//this class is to handle all business logics

public class MainActivity extends AppCompatActivity {

    TextView signinbtn, forgot;
    Button userLoginButton;
    EditText nic,password;
    private DBHelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userLoginButton = findViewById(R.id.LoginBtn);
        nic = findViewById(R.id.editTextTextEmailAddress2);
        password = findViewById(R.id.editTextTextPassword);
        DB = new DBHelper(this);
        userLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id,pw;
                id = nic.getText().toString();
                pw = password.getText().toString();

                if(nic.equals("")|| pw.equals("")){
                    Toast.makeText(MainActivity.this, "Required fields !!", Toast.LENGTH_SHORT).show();
                }

                else{
                    Boolean validStatus = DB.checkusernamepassword(id, pw);
                    if (validStatus == true)
                    {
                        Toast.makeText(MainActivity.this, "User login Successfully !", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(MainActivity.this, Home.class);
                        startActivity(intent1);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Something went wrong !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        forgot = findViewById(R.id.logss);

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Home.class);
                startActivity(intent);
            }
        });

        signinbtn = findViewById(R.id.signup);

        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Signup.class);
                startActivity(intent);
            }
        });
    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        userob = new User();
//
//        button = findViewById(R.id.button);
//        editTextTextEmailAddress2 = findViewById(R.id.editTextTextEmailAddress2);
//        editTextTextPassword = findViewById(R.id.editTextTextPassword);
//        button.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Signup.class)));
//
//
//    }
//
//
//    public void Signin(View view) {
//
//
//
//
//
//        String enteredUsername = editTextTextEmailAddress2.getText().toString().trim();
//        String enteredPassword = editTextTextPassword.getText().toString().trim();
//
//        db = FirebaseDatabase.getInstance().getReference().child("User");
//
//        Query checkUser = db.orderByChild("nic").equalTo(enteredUsername);
//
//        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
//
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                if(dataSnapshot.exists()){
//
//
//
//                    String passwordFromDB = dataSnapshot.child(enteredUsername).child("password").getValue(String.class);
//
//                    if(passwordFromDB.equals(enteredPassword)){
//
//                        String emailFromDB = dataSnapshot.child(enteredUsername).child("email").getValue(String.class);
//                        String mobileNumFromDB = dataSnapshot.child(enteredUsername).child("mobileNum").getValue(String.class);
//                        String nameFromDB = dataSnapshot.child(enteredUsername).child("name").getValue(String.class);
//                        String nicFromDB = dataSnapshot.child(enteredUsername).child("nic").getValue(String.class);
//
//
//                        Intent intent = new Intent(getApplicationContext(),User.class);
//                        Intent intent1 = new Intent(getApplicationContext(),User.class);
//
//
//                        intent.putExtra("name",nameFromDB);
//                        intent.putExtra("email",emailFromDB);
//                        intent.putExtra("nic",nicFromDB);
//                        intent.putExtra("mobileNum",mobileNumFromDB);
//                        intent.putExtra("password",passwordFromDB);
//
//
//                        intent1.putExtra("nic",nicFromDB);
//
//
//                        saveToDevice(nameFromDB, emailFromDB, nicFromDB, mobileNumFromDB, passwordFromDB);
//
//                        Toast.makeText(getApplicationContext()," Successfully Logged in",Toast.LENGTH_LONG).show();
//                        startActivity(intent);
//
//                        ClearControls();
//                    }else {
//
//                        Toast.makeText(getApplicationContext(),"Password Error",Toast.LENGTH_LONG).show();
//                        ClearControls();
//                    }
//                }else {
//
//                    Toast.makeText(getApplicationContext(),"Username Error",Toast.LENGTH_LONG).show();
//                    ClearControls();
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull  DatabaseError error) {
//
//            }
//        });
//
//        editTextTextEmailAddress2.setText("");
//        editTextTextPassword.setText("");
//
//    }
//    private void saveToDevice(String name, String email, String nic, String mobile, String password) {
//        SharedPreferences sharedPref = getSharedPreferences("myPref", MODE_PRIVATE);
//        sharedPref.edit().putString("name", name).apply();
//        sharedPref.edit().putString("email", email).apply();
//        sharedPref.edit().putString("nic", nic).apply();
//        sharedPref.edit().putString("mobileNum", mobile).apply();
//        sharedPref.edit().putString("password", password).apply();
//    }
//
//    public void ClearControls() {
//        editTextTextEmailAddress2.setText("");
//        editTextTextPassword.setText("");
//
//    }


}