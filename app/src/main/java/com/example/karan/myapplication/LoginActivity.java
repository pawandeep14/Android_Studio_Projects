package com.example.karan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView email,password;
    Button signinbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
   email=(TextView) findViewById(R.id.email);
   password=(TextView) findViewById(R.id.password);
   signinbutton= (Button) findViewById(R.id.email_sign_in_button);
   signinbutton.setOnClickListener(this);






    }

    @Override
    public void onClick(View v) {

       // Toast.makeText(getApplicationContext(),"Shabaash",Toast.LENGTH_LONG).show();










































    }
}
