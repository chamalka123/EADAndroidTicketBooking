package com.example.transportead;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
//this class is to handle all business logics

public class Signup extends AppCompatActivity {

    EditText personName,editTextTextEmailAddress3,editTextPhone,editTextTextPassword2,editTextTextPersonName4;
    Button btn_2signin,btnsignup;

    private DBHelper DB;

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        DB = new DBHelper(this);
        btnsignup = findViewById(R.id.btnsignup);
        personName = findViewById(R.id.editTextTextPersonName);
        editTextTextEmailAddress3 = findViewById(R.id.editTextTextEmailAddress3);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2);
        editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                // startActivity(intent);

                String vnum,pw,v_type,f_type,chesis_n;
                vnum = personName.getText().toString();
                pw = editTextTextPassword2.getText().toString();
                v_type = editTextTextEmailAddress3.getText().toString();
                f_type = editTextPhone.getText().toString();
                chesis_n = editTextTextPersonName4.getText().toString();

                if(vnum.equals("")|| pw.equals("")|| v_type.equals("")|| f_type.equals("")|| chesis_n.equals("")){
                    Toast.makeText(Signup.this, "You should fill all fields !!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkUser = DB.checkusername(vnum);
                    if(checkUser == false){
                        postDataToDB(vnum,pw,v_type,f_type,chesis_n);
                        Boolean insertSuccess = DB.insertData(vnum, pw);
                        if(insertSuccess == true){
                            Toast.makeText(Signup.this, "User Registered Successfully !", Toast.LENGTH_SHORT).show();
                            Intent intent1 = new Intent(Signup.this, MainActivity.class);
                            startActivity(intent1);
                        }else {
                            Toast.makeText(Signup.this, "Something went wrong !", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(Signup.this, "User already registered !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    // implementation to post the vehicle owner data to DB
    private void postDataToDB(String vnum, String pw, String v_type, String f_type, String chesis_n ){
        try {
            // url to post the user data
            String url = "http://172.28.1.50:8080/api/User";
            HashMap<String, String> params = new HashMap<String, String>();
            params.put("name", vnum);
            params.put("password", pw);
            params.put("email", v_type);
            params.put("mobileNum", f_type);
            params.put("nic", chesis_n);
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
            requestQueue = Volley.newRequestQueue(Signup.this);
            requestQueue.add(req);
        }catch (Exception e){
        }
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_signup);
//
//        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
//        editTextTextEmailAddress3 = findViewById(R.id.editTextTextEmailAddress3);
//        editTextPhone = findViewById(R.id.editTextPhone);
//        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2);
//        editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);
//
//        btnsignup = findViewById(R.id.btnsignup);
//
//        userob = new User();
//
//        //button dirrection
//
//        btn_2signin = findViewById(R.id.btn_2signin);
//        btn_2signin.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//
//                startActivity(new Intent(Signup.this, User.class));
//
//                ClearControls();
//            }
//        });
//
//
//
//
//    }
//
//    public void Signup(View view) {
//
//        rootNode = FirebaseDatabase.getInstance();
//        db = rootNode.getReference("User");
//
//
//        try {
//            if(TextUtils.isEmpty(editTextTextPersonName.getText().toString().trim())){
//                Toast.makeText(getApplicationContext(),"Enter Your Name",Toast.LENGTH_LONG).show();
//            } else if (TextUtils.isEmpty(editTextTextEmailAddress3.getText().toString().trim())){
//                Toast.makeText(getApplicationContext(),"Enter Your Email",Toast.LENGTH_LONG).show();
//            } else if (TextUtils.isEmpty(editTextPhone.getText().toString().trim())){
//                Toast.makeText(getApplicationContext(),"Enter Your Mobile Number",Toast.LENGTH_LONG).show();
//            } else if (TextUtils.isEmpty(editTextTextPassword2.getText().toString().trim())){
//                Toast.makeText(getApplicationContext(),"Enter a Password",Toast.LENGTH_LONG).show();
//            } else if (TextUtils.isEmpty(editTextTextPersonName4.getText().toString().trim())){
//                Toast.makeText(getApplicationContext(),"Enter a Password",Toast.LENGTH_LONG).show();
//            } else {
//                userob.setName(editTextTextPersonName.getText().toString().trim());
//                userob.setEmail(editTextTextEmailAddress3.getText().toString().trim());
//                userob.setMobileNum(editTextPhone.getText().toString().trim());
//                userob.setPassword(editTextTextPassword2.getText().toString().trim());
//                userob.setNic(editTextTextPersonName4.getText().toString().trim());
//                String Nic = editTextTextPersonName4.getText().toString().trim();
//
//                db.child(Nic).setValue(userob);
//
//                Toast.makeText(getApplicationContext(),"Account Created",Toast.LENGTH_LONG).show();
//
//                startActivity(new Intent(Signup.this, MainActivity.class));
//
//                ClearControls();
//
//            }
//
//
//        } catch (NumberFormatException e) {
//            Toast.makeText(getApplicationContext(), "Number Format Exception", Toast.LENGTH_LONG).show();
//        }
//    }
//
//    public void ClearControls() {
//        editTextTextPersonName.setText("");
//        editTextTextEmailAddress3.setText("");
//        editTextPhone.setText("");
//        editTextTextPassword2.setText("");
//        editTextTextPersonName4.setText("");
//        editTextTextPersonName4.setText("");
//
//
//    }

}