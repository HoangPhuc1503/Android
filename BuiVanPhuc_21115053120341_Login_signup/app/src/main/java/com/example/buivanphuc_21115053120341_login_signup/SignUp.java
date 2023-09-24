package com.example.buivanphuc_21115053120341_login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp extends AppCompatActivity {
     Button bt_Signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bt_Signup = findViewById(R.id.bt_Signup);
        bt_Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintentSignup = new Intent(SignUp.this, login.class);
                startActivity(myintentSignup);
            }
        });

    }
}