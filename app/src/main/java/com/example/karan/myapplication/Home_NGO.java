package com.example.karan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Home_NGO extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__ngo);
        ImageButton createevent,edit_details,view_activist;
        createevent=(ImageButton) findViewById(R.id.createevent);
        edit_details=(ImageButton) findViewById(R.id.editdetails);
        view_activist=(ImageButton) findViewById(R.id.viewactivists);

        createevent.setOnClickListener(this);
        edit_details.setOnClickListener(this);
        view_activist.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        switch (v.getId())
        {
            case R.id.createevent:
            {

                Intent i=new Intent(this,Create_Event.class);
                startActivity(i);


            }
            break;
            case R.id.editdetails:
            {

            }
            break;
            case R.id.viewactivists:
            {

            }
            break;
            default:







        }

    }
}
