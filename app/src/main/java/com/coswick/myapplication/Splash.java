package com.example.ez;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        new Handler() .postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(Splash_Activity.this, Splash_Activity.class);
                startActivity(intent);
                finish();

            }
        }, 3000);
    }
}
