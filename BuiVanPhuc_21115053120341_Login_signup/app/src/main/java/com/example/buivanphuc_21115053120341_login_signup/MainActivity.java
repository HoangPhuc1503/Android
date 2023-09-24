package com.example.buivanphuc_21115053120341_login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bt_Login;
    Button bt_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_Login = findViewById(R.id.bt_Login);
        bt_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // khai báo Intent
                Intent myintentLogin = new Intent(MainActivity.this, login.class);
                // khởi động
                startActivity(myintentLogin);
            }
        });
        bt_signup = findViewById(R.id.bt_signup);
        bt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // khai báo Intent
                Intent myintentSignup = new Intent(MainActivity.this, SignUp.class);
                // khởi động
                startActivity(myintentSignup);
            }
        });
    }
}