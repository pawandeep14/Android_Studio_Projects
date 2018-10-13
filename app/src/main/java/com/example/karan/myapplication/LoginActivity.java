package com.example.karan.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText usernameet,passwordet;
    String uname,pass;
    Button signinbutton;
    DatabaseReference loginreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameet=(EditText) findViewById(R.id.username);
        passwordet=(EditText) findViewById(R.id.password);
        signinbutton= (Button) findViewById(R.id.email_sign_in_button);
        signinbutton.setOnClickListener(this);
        uname=usernameet.getText().toString().trim();
        pass=passwordet.getText().toString().trim();

        Spinner dropdown = findViewById(R.id.email_domains);
        String[] items = new String[]{"@gmail.com","@yahoo.com","@rediffmail.com"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);




    }

    @Override
    public void onClick(View v) {

        validate();

        loginreference = FirebaseDatabase.getInstance().getReference("userlogin").child(uname);
        loginreference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(!dataSnapshot.exists())
                {
                     Toast.makeText(getApplicationContext(),"Username/Password Incorrect",Toast.LENGTH_LONG).show();

                }
                else
                {
                    Map<String, Object> userdetails = (HashMap<String,Object>) dataSnapshot.getValue();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }

    private boolean validate() {
        uname=usernameet.getText().toString().trim();
        pass=passwordet.getText().toString().trim();

        if(uname.isEmpty() || pass.isEmpty())

        {

            Toast.makeText(getApplicationContext(),"Please Enter All The Details",Toast.LENGTH_LONG).show();
        }
             return  true;

    }

}
