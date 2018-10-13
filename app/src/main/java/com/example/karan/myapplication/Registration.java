package com.example.karan.myapplication;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity implements View.OnClickListener {
    EditText useremailet,passwordet,confirmpasswordet;
    Button register;
    DatabaseReference registrationreference;
    Spinner rolespinner;
    CoordinatorLayout coordinatorLayout;
    View v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        useremailet=(EditText)findViewById(R.id.useremail);
        passwordet=(EditText) findViewById(R.id.password);
        confirmpasswordet=(EditText) findViewById(R.id.confirmpassword);
        register=(Button) findViewById(R.id.Register);
        String emailid=getIntent().getStringExtra("email");
        Toast.makeText(getApplicationContext(),""+emailid,Toast.LENGTH_LONG).show();
        useremailet.setText(emailid);
        register.setOnClickListener(this);
        rolespinner=(Spinner) findViewById(R.id.rolespinner);
        String[] roles=new String[]{"--ROLE--","Activist","NGO"};
        ArrayAdapter<String> rolearray= new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,roles);
        rolespinner.setAdapter(rolearray);
        v=findViewById(android.R.id.content);




    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.Register:
            {


                String un=useremailet.getText().toString();
                String pas=passwordet.getText().toString();
                String conpa=confirmpasswordet.getText().toString();
                String role="";
                 if(rolespinner.getSelectedItem().toString()=="--ROLE--") {
                     role=rolespinner.getSelectedItem().toString();
                     Toast.makeText(this,""+role,Toast.LENGTH_LONG).show();
                     Snackbar.make(v,"Please Select Role",10000).show();
                }
                else {
                     role= rolespinner.getSelectedItem().toString();
                     Toast.makeText(this,"Sab sahi hai",Toast.LENGTH_LONG).show();
                     validateregdata(un,pas,conpa);
                     createuser(un, pas, role);
                     }

                 }


            break;


        }


    }

    private void createuser(String un,String pas,String role) {


        newuser obj=new newuser(un,pas,role);
        registrationreference= FirebaseDatabase.getInstance().getReference("users");
        registrationreference.setValue(obj);
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(un,pas).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

              Snackbar.make(v,"Registration Successful, Check Your Mail",10000).show();
              FirebaseAuth.getInstance().getCurrentUser().sendEmailVerification();

            }
        });













    }


    private Boolean validateregdata(String un,String pas,String conpa) {



    if(un.isEmpty())
    {
        useremailet.setError("This field id required");
        useremailet.requestFocus();
    }else
    {
        if(!Patterns.EMAIL_ADDRESS.matcher(un).matches())
        {
            useremailet.setError("Invalid Email ID");
            useremailet.requestFocus();

        }

    }
    if(pas.isEmpty())
    {
        passwordet.setError("This field id required");
        passwordet.requestFocus();
    }
    else
        if(pas.length()<8)
        {
          passwordet.setError("Minimum Length Should be 8");
        }
if(conpa.isEmpty())
{
    confirmpasswordet.setError("This field id required");
    confirmpasswordet.requestFocus();
}
else
    if(!conpa.equals(pas))
    {
        confirmpasswordet.setError("Passwords Dont Match");
        confirmpasswordet.requestFocus();
    }
              return true;
    }

}
