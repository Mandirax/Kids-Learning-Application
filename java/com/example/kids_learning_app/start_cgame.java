package com.example.kids_learning_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class start_cgame extends AppCompatActivity {
    VideoView videoView3;
    MediaPlayer mysong;
    private int length;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_cgame);
        getSupportActionBar().hide();
        Button bb = (Button) findViewById(R.id.bb);


        videoView3 = (VideoView) findViewById(R.id.videoView3);
        String path = "android.resource://com.example.kids_learning_app/"+R.raw.starts;
        Uri u = Uri.parse(path);
        videoView3.setVideoURI(u);
        videoView3.start();
        videoView3.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });


        mysong = MediaPlayer.create(getApplicationContext(), R.raw.intro);
        mysong.start();
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),GameActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onResume() {
        videoView3.resume();
        super.onResume();
        mysong.seekTo(length);
        mysong.start();
    }
    @Override
    protected void onRestart() {
        videoView3.start();
        super.onRestart();

    }
//
    @Override
    protected void onPause() {
        videoView3.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        videoView3.stopPlayback();
        super.onDestroy();
    }

    @Override
    protected void onStop(){
        super.onStop();
        mysong.pause();
        mysong.seekTo(length);
    }


}