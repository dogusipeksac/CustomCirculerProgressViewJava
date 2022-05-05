package com.example.customcirculerprogressbarjava;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private CircularProgressView progressView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressView=findViewById(R.id.progressView);
        progressView.setProgress(75.0f);
        progressView.setProgressWidth(20.0f);
        progressView.setProgressBackgroundColor(Color.GRAY);
        progressView.setProgressColor(Color.BLUE);
        progressView.setRounded(true);
    }
}