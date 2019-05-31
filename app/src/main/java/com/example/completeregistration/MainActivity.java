package com.example.completeregistration;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaeHelper db;
    private EditText RegNumber;
    private EditText Email;
    private EditText FullName;
    private   EditText Password;
    private  Button Login;
    private   Button Registration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaeHelper(this);
        Email = (EditText) findViewById(R.id.mail);
        FullName = (EditText) findViewById(R.id.names);
        RegNumber = (EditText) findViewById(R.id.reg);
        Password = (EditText) findViewById(R.id.pass);
        Login = (Button) findViewById(R.id.btnLog);
        Registration = (Button) findViewById(R.id.btnReg1);


        Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Welcome to registration page!", Toast.LENGTH_LONG).show();

            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = RegNumber.getText().toString();
                String pass = Password.getText().toString();
                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)) {
                    Toast.makeText(getApplicationContext(), "Please fill all field!", Toast.LENGTH_LONG).show();
                }
                else if (RegNumber.equals("215021644") && Password.equal(pelagie)) {
                    Toast.makeText(getApplicationContext(), "login successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, music.class);
                    startActivity(intent);
                }
//            else {
//              boolean CheckRegNumber = db.CheckRegNumber(RegNumber.getText().toString());
//              if (CheckRegNumber==true){
//                  Boolean insert = db.insert(RegNumber.getText().toString(), Email.getText().toString(), FullName.getText().toString(), Password.getText().toString());
//                  if (insert ==true){
//                      Toast.makeText(getApplicationContext(), "You are registed", Toast.LENGTH_SHORT).show();

                else {
                    Toast.makeText(getApplicationContext(), "you have already registed!", Toast.LENGTH_LONG).show();

                }

            }


        });
    }}


