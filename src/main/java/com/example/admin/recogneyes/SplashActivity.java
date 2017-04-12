package com.example.admin.recogneyes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        for(int i=0;i<2000;i++)
        {

        }

        startActivity(new Intent(SplashActivity.this,MainActivity.class));
        finish();
    }
}
