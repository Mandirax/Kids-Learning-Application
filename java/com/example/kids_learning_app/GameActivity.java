package com.example.kids_learning_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
ImageView iv_button,iv_arrow;
TextView tv_points;
ProgressBar progressBar;
Handler handler;
Runnable runnable;
Integer score;


Random r;

private final static int STATE_BLUE = 1;
private final static int STATE_RED = 2;
private final static int STATE_YELLOW = 3;
private final static int STATE_GREEN = 4;

int buttonState = STATE_BLUE;
int arrowState = STATE_BLUE;

int currentTime = 4000;
int startTime = 4000;

int currentPoints = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().hide();

        iv_button = findViewById(R.id.iv_button);
        iv_arrow = findViewById(R.id.iv_arrow);
        tv_points = findViewById(R.id.tv_points);
        progressBar = findViewById(R.id.progressBar);

        r = new Random();


        //set the initial progressbar time to 4 seconds
        progressBar.setMax(startTime);
        progressBar.setProgress(startTime);

       //display the starting points
        tv_points.setText("Points: "+currentPoints);
//generate random arrow color at the start of the game
        r = new Random();
        arrowState = r.nextInt(4) +1;

        setArrowImage(arrowState);
        iv_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //rotate the button with the colors
                        setButtonImage(setButtonPosition(buttonState));

                    }
                }
        );
        //main game loop
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                currentTime = currentTime - 100;
                progressBar.setProgress(currentTime);
                //show progress
                if(currentTime > 0){
                    handler.postDelayed(runnable,100);

                }
                else{
                    //check if the colors of the arrow and the button are the same
                    if(buttonState == arrowState){
                        //increase points and show them
                        currentPoints = currentPoints +1;
                        tv_points.setText("Points: "+currentPoints);

                        //make the speed higher after every turn / if
                        startTime = startTime - 100;
                        if(startTime < 1000){
                            startTime = 2000;
                        }
                        progressBar.setMax(startTime);
                        currentTime = startTime;
                        progressBar.setProgress(currentTime);

                        arrowState = r.nextInt(4) + 1;
                        setArrowImage(arrowState);
                        handler.postDelayed(runnable,100);
                    }
                    else{
//                        new AlertDialog.Builder(GameActivity.this)
//                                .setTitle("Game Over!!\n")
//                                .setMessage("Total Score : "+currentPoints+"\n\nWant to start again?")
//                                .setCancelable(false)
//                                .setNegativeButton(Html.fromHtml("<font color='#00000'>Restart</font>"),new DialogInterface.OnClickListener(){
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        Intent i2=new Intent(getApplication(),GameActivity.class);
//                                        startActivity(i2);
//
//
//                                    }
//
//                                })
//                                .setPositiveButton(Html.fromHtml("<font color='#00000'>Exit</font>"), new DialogInterface.OnClickListener() {
//
//
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        Intent i2=new Intent(getApplication(),FunStart.class);
//                                        startActivity(i2);
//
//                                    }
//
//
//                                    }).show();

                        Intent i=new Intent(getApplication(),GameOver.class);
                        i.putExtra("message", currentPoints);
                        startActivity(i);


                        //Toast.makeText(GameActivity.this,"Game Over",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        };

        handler.postDelayed(runnable,100);

    }

    //display the arrow color according to the generated number
    private void setArrowImage(int state){
        switch(state){
            case STATE_BLUE:
                iv_arrow.setImageResource(R.drawable.c5);
                arrowState = STATE_BLUE;
                break;
            case STATE_RED:
                iv_arrow.setImageResource(R.drawable.c8);
                arrowState = STATE_RED;
                break;
            case STATE_YELLOW:
                iv_arrow.setImageResource(R.drawable.c7);
                arrowState = STATE_YELLOW;
                break;
            case STATE_GREEN:
                iv_arrow.setImageResource(R.drawable.c6);
                arrowState = STATE_GREEN;
                break;
        }
    }
    //rotate animation of the button when clicked
    private void setRotation(final ImageView image,final int drawable){
        //rotate 90 degrees
        RotateAnimation rotateAnimation = new RotateAnimation(0,90, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(100);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            image.setImageResource(drawable);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image.startAnimation(rotateAnimation);
    }
    //set buttons color position
    private int setButtonPosition(int position){
        position = position +1;
        if(position == 5){
            position = 1;
        }
        return position;
    }

    //display the buttons color position
    private void setButtonImage(int state){

        switch(state){
            case STATE_BLUE:
                setRotation(iv_button,R.drawable.c2);

                buttonState = STATE_BLUE;
                break;
            case STATE_RED:
                setRotation(iv_button,R.drawable.c3);

                buttonState = STATE_RED;
                break;
            case STATE_YELLOW:
                setRotation(iv_button,R.drawable.c4);

                buttonState = STATE_YELLOW;
                break;
            case STATE_GREEN:
                setRotation(iv_button,R.drawable.c1);

                buttonState = STATE_GREEN;
                break;
        }

    }


}