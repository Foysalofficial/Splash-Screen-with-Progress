package com.foysaldev.splashscreenwithprogress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        progressBar = findViewById(R.id.ProgressBarId);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                mysplash();
                Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        thread.start();
    }

    private void mysplash() {

        for (progress = 20; progress <= 100; progress = progress + 20) {
            try {
                progressBar.setProgress(progress);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}