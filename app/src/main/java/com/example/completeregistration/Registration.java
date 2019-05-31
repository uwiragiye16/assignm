package com.example.completeregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    DatabaeHelper db;
    private EditText RegNumber;
    private EditText Email;
    private EditText FullName;
    private   EditText Password;
//    private Button Login;
    private   Button Registrater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final DatabaeHelper db = new DatabaeHelper(this);
        setContentView(R.layout.activity_main);
//        db = new DatabaeHelper(this);
        Email =(EditText)findViewById(R.id.mail);
        FullName = (EditText)findViewById(R.id.names);
        RegNumber  = (EditText)findViewById(R.id.reg);
        Password = (EditText)findViewById(R.id.pass);
//        Login = (Button)findViewById(R.id.btnLog);
        Registrater =(Button)findViewById(R.id.regbtn);


//        Registration.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Registration.this, com.example.completeregistration.Registration.class);
//                Toast.makeText(getApplicationContext(), "Welcome to registration page!", Toast.LENGTH_LONG).show();
//                startActivity(intent);
//            }
//        });

        Registrater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                boolean isInserted =db.insertdata(username.getText().toString(), password.getText().toString());
                String user =RegNumber.getText().toString();
                String pass = Password.getText().toString();
                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)){
                    Toast.makeText(getApplicationContext(), "Please fill all field!",Toast.LENGTH_LONG).show();
                }
                else{
                    boolean CheckRegNumber = db.CheckRegNumber(RegNumber.getText().toString());
                    if (CheckRegNumber==true){
                        Boolean isInserted = db.insert(RegNumber.getText().toString(), Email.getText().toString(), FullName.getText().toString(), Password.getText().toString());
                        if (isInserted ==true){
                            Toast.makeText(getApplicationContext(), "You are registed", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(),"you have already registed!",Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
    }
}
