package com.example.karan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Create_Event extends AppCompatActivity implements View.OnClickListener {

    Button addevent;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__event);
    addevent=(Button) findViewById(R.id.addeventbutton);
    addevent.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"Clicked",Toast.LENGTH_LONG).show();
    }
}
