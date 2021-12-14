package com.example.kids_learning_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    VideoView videoView1;
    MediaPlayer mysong;
    private int length;
    TextView tv;
    DataBaseHelper mydb;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button btn3=(Button)findViewById(R.id.btn1);
        mydb = new DataBaseHelper(this);
        Cursor res = mydb.getalldata();
        Boolean isFirstRun = getSharedPreferences("message", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            //show start activity

            startActivity(new Intent(MainActivity.this, FirstLaunch.class));
            //Toast.makeText(MainActivity.this, "First Run", Toast.LENGTH_LONG).show();
        }


        getSharedPreferences("message", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();







        tv = (TextView) findViewById(R.id.textView7);
        String ss="";
        while (res.moveToNext()){
             ss= res.getString(0);
        }

        tv.setText("Hello "+ss+"!");




        Button btn = (Button) findViewById(R.id.Learn);
        Button btn2 = (Button) findViewById(R.id.play);


        videoView1 = (VideoView) findViewById(R.id.videoView1);
        String path = "android.resource://com.example.kids_learning_app/"+R.raw.playn;
        Uri u = Uri.parse(path);
        videoView1.setVideoURI(u);
        videoView1.start();
        videoView1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),MainActivity_learning.class);
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(getApplication(),FunStart.class);
                startActivity(i2);
            }
        });

        getSupportActionBar().hide();


        mysong = MediaPlayer.create(getApplicationContext(), R.raw.song_s);
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












