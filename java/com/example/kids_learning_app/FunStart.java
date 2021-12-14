package com.example.kids_learning_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class FunStart extends AppCompatActivity {
    Button b1;
    VideoView videoView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_start);
       //getSupportActionBar().hide();

        b1 = (Button) findViewById(R.id.ColorGame);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),start_cgame.class);
                startActivity(i);
            }
        });

        videoView1 = (VideoView) findViewById(R.id.videoView1);
        String path = "android.resource://com.example.kids_learning_app/"+R.raw.gamess;
        Uri u = Uri.parse(path);
        videoView1.setVideoURI(u);
        videoView1.start();
        videoView1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });



    }

    @Override
    protected void onResume() {
        videoView1.resume();
        super.onResume();

    }
    @Override
    protected void onRestart() {
        videoView1.start();
        super.onRestart();

    }

    @Override
    protected void onPause() {
        videoView1.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        videoView1.stopPlayback();
        super.onDestroy();
    }

    @Override
    protected void onStop(){
        super.onStop();

    }
}