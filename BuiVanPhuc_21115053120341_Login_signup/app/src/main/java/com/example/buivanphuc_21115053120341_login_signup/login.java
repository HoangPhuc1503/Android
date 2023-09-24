package com.example.buivanphuc_21115053120341_login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {
    Button bt_Create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bt_Create = findViewById(R.id.bt_Create);
        bt_Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintentCreate = new Intent(login.this,SignUp.class);
                startActivity(myintentCreate);
            }
        });
    }
}