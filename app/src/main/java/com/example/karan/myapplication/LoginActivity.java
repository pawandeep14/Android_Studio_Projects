package com.example.karan.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
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
    Button signinbutton,registerbutton;
    DatabaseReference loginreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameet=(EditText) findViewById(R.id.useremail);
        passwordet=(EditText) findViewById(R.id.password);
        signinbutton= (Button) findViewById(R.id.email_sign_in_button);
        signinbutton.setOnClickListener(this);
        registerbutton=(Button) findViewById(R.id.email_register_button);
        registerbutton.setOnClickListener(this);
        uname=usernameet.getText().toString().trim();
        pass=passwordet.getText().toString().trim();





    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.email_sign_in_button:
            {
                validate();

                loginreference = FirebaseDatabase.getInstance().getReference("users").child(uname);
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
            break;
            case R.id.email_register_button:
            {
                Toast.makeText(this, "Register karega "+usernameet.getText(), Toast.LENGTH_SHORT).show();
                Intent registerintent=new Intent(this,Registration.class);
                registerintent.putExtra("email",usernameet.getText().toString());
                this.startActivity(registerintent);
            }

        }






    }

    private boolean validate() {
        uname=usernameet.getText().toString().trim();
        pass=passwordet.getText().toString().trim();

        if(uname.isEmpty() || pass.isEmpty())

        {
            Toast.makeText(getApplicationContext(),"Please Enter All The Details",Toast.LENGTH_LONG).show();
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(uname).matches())
        {
            Toast.makeText(getApplicationContext(),"Please Enter A Valid Email ID",Toast.LENGTH_LONG).show();
        }


             return  true;
    }

}
