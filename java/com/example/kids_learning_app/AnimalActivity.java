package com.example.kids_learning_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class AnimalActivity extends AppCompatActivity {
    MediaPlayer mp = new MediaPlayer();
    ToggleButton toggleButton;







    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        getSupportActionBar().hide();

        String name = getIntent().getStringExtra("name").toLowerCase();
        ImageView iv = findViewById(R.id.imageView3);
        int iid= getResources().getIdentifier(name,"drawable",getPackageName());
        iv.setImageResource(iid);

        int mid = getResources().getIdentifier(name,"raw",getPackageName());
        mp = MediaPlayer.create(getApplicationContext(),mid);




    }

    //toggle button to turn on and off the media player when required

    public void onToggleClicked(View view) {
        // Is the toggle on?

        boolean on = ((ToggleButton) view).isChecked();


        if (on) {
            // Enable vibrate
            view.setBackgroundResource(R.drawable.ic_action_name2);
            mp.start();
        } else {
            // Disable vibrate
            view.setBackgroundResource(R.drawable.ic_action_name);
            mp.pause();
        }
    }

    //To stop the media player when back button is pressed
    @Override
    public void onBackPressed() {
        if (mp.isPlaying()) {
            mp.stop();
        }
        mp.release();
        super.onBackPressed();
    }

}