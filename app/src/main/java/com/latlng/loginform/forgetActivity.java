package com.latlng.loginform;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class forgetActivity extends AppCompatActivity
{
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    Button otp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.forgetpass_activity);
        editText1 = findViewById(R.id.et1);
        editText2 = findViewById(R.id.et2);
        editText3 = findViewById(R.id.et3);
        editText4 = findViewById(R.id.et4);
        otp = findViewById(R.id.btn);


        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String eText1 = editText1.getText().toString();
                String eText2 = editText2.getText().toString();
                String eText3 = editText3.getText().toString();
                String eText4 = editText4.getText().toString();

                if (eText1.length() == 0) {
                    editText1.requestFocus();
                    editText1.setError("Can't be empty!");
                }
                else if (eText2.length() == 0) {
                    editText2.requestFocus();
                    editText2.setError("Can't be empty!");
                }
                else if (eText3.length() == 0) {
                    editText3.requestFocus();
                    editText3.setError("Can't be empty!");
                }
                else if (!eText3.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
                    editText3.requestFocus();
                    editText3.setError("Enter valid mail!");
                }
                else if (eText4.length() == 0) {
                    editText4.requestFocus();
                    editText4.setError("Can't be empty!");
                }

                else if (eText4.length() != 10) {
                    editText4.requestFocus();
                    editText4.setError("Enter valid number!");
                }

            }

        });
    }
}