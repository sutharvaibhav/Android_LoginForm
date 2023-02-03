package com.latlng.loginform;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class GoogleInfo extends AppCompatActivity {

    TextView mail, name,aa,bb,cc,dd;
    GoogleSignInClient gsc;
    GoogleSignInOptions gso;
    Button sout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_info);

        mail = findViewById(R.id.mailTv);
        name = findViewById(R.id.nameTv);
        sout = findViewById(R.id.signOut);
        aa=findViewById(R.id.Tv11);
        bb=findViewById(R.id.Tv12);
        cc=findViewById(R.id.Tv13);
        dd=findViewById(R.id.Tv14);



        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String pmail = acct.getEmail();
            String pname = acct.getDisplayName();
            String a = acct.getFamilyName();
            String b = acct.getGivenName();
            String c = acct.getId();
            String d= acct.getIdToken();
            String e = acct.getServerAuthCode();
            name.setText(pname);
            mail.setText(pmail);
            aa.setText(a);
            bb.setText(b);
            cc.setText(c);
            dd.setText(d);
        }

        sout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });


    }

    void signOut() {
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                finish();
                startActivity(new Intent(GoogleInfo.this, MainActivity.class));
            }
        });

    }
}