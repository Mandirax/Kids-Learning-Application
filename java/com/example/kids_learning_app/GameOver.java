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

public class GameOver extends AppCompatActivity {
    VideoView videoView1;
    private int length;
    MediaPlayer mysong;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);


        Button btn = (Button) findViewById(R.id.restart);
        Button btn2 = (Button) findViewById(R.id.exit);
        Intent intent = getIntent();
        int intValue = intent.getIntExtra("message", 0);
        tv = (TextView) findViewById(R.id.textViews);
        tv.setText(Integer.toString(intValue));



        videoView1 = (VideoView) findViewById(R.id.videoView4);
        String path = "android.resource://com.example.kids_learning_app/"+R.raw.over;
        Uri u = Uri.parse(path);
        videoView1.setVideoURI(u);
        videoView1.start();
        videoView1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                //mp.setLooping(true);
            }
        });





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),GameActivity.class);
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(getApplication(),MainActivity.class);
                startActivity(i2);
            }
        });

        getSupportActionBar().hide();


        mysong = MediaPlayer.create(getApplicationContext(), R.raw.sover);
        mysong.start();

    }
    @Override
    protected void onResume() {
        videoView1.resume();
        super.onResume();
        mysong.seekTo(length);
        mysong.start();
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
        mysong.pause();
        mysong.seekTo(length);
    }

}

