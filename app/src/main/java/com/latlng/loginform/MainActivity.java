package com.latlng.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView move1;
    private TextView move2;
    EditText emailAdd;
    EditText Password;
    Button logIn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        move1 = findViewById(R.id.tv3);
        move1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,forgetActivity.class);
                startActivity(intent);
            }
        });
        move2 = findViewById(R.id.tv4);
        move2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,registerActivity.class);
                startActivity(intent);
            }
        });


        emailAdd = findViewById(R.id.et1);
        Password = findViewById(R.id.et2);
        logIn = findViewById(R.id.button1);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailAdd.getText().toString();
                String pass = Password.getText().toString();

                //Function for password validation

                validateInfo(email,pass);
            }

        });





    }

    private void validateInfo(String email, String pass) {
        if(email.length()==0) {
            emailAdd.requestFocus();
            emailAdd.setError("Email can't be empty");
        }
        else if(!email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
                emailAdd.requestFocus();
                emailAdd.setError("Enter valid mail");

        }
        else if(pass.length()==0) {
            Password.requestFocus();
            Password.setError("Password can't be empty");
        }
        else if(pass.length()<8) {
            Password.requestFocus();
            Password.setError("Password must consist 8 characters");
        }

    }
}