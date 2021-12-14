package com.example.kids_learning_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

public class StartActivity extends AppCompatActivity {
    private static int Time = 2500;

    VideoView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_start);
        v=(VideoView)  findViewById(R.id.videoView2);
        String path = "android.resource://com.example.kids_learning_app/"+R.raw.plays;
        Uri u = Uri.parse(path);
        v.setVideoURI(u);
        v.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(StartActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, Time);






    }
}