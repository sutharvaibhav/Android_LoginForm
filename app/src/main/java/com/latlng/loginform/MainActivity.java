package com.latlng.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {
    private TextView move1;
    private TextView move2;
    EditText emailAdd;
    EditText Password;
    Button logIn, google;
    GoogleSignInClient gsc;
    GoogleSignInOptions gso;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        google = findViewById(R.id.googlBt);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });



        move1 = findViewById(R.id.tv3);
        move1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ForgetActivity.class);
                startActivity(intent);
            }
        });
        move2 = findViewById(R.id.tv4);
        move2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


        emailAdd = findViewById(R.id.et1);
        Password = findViewById(R.id.et2);
        logIn = findViewById(R.id.logIn);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailAdd.getText().toString();
                String pass = Password.getText().toString();

                //Function for password validation

                validateInfo(email, pass);
            }

        });


    }

    void signIn(){
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == 1000) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(),"Something went wrong!",Toast.LENGTH_SHORT).show();
            }
        }
    }

    void navigateToSecondActivity(){
        finish();
        Intent intent = new Intent(MainActivity.this,GoogleInfo.class);
        startActivity(intent);
    }



    private void validateInfo(String email, String pass) {
        if (email.length() == 0) {
            emailAdd.requestFocus();
            emailAdd.setError("Email can't be empty");
        } else if (!email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            emailAdd.requestFocus();
            emailAdd.setError("Enter valid mail");

        } else if (pass.length() == 0) {
            Password.requestFocus();
            Password.setError("Password can't be empty");
        } else if (pass.length() < 8) {
            Password.requestFocus();
            Password.setError("Password must consist 8 characters");
        }
    }

}