package com.example.kids_learning_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import org.w3c.dom.Text;

public class FirstLaunch extends AppCompatActivity {
    Button buts;
    EditText tt;

    DataBaseHelper mydb;
    EditText edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_launch);

        buts = (Button) findViewById(R.id.buttonx);
        tt = (EditText) findViewById(R.id.edtext);
        mydb = new DataBaseHelper(this);

        buts.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        boolean isInserted = mydb.insertdata(tt.getText().toString());
                        if (isInserted = true) {
                           // Toast.makeText(FirstLaunch.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            String message = tt.getText().toString();
                            i.putExtra("My_KEY", message);

                            startActivity(i);
                        } else {
                            Toast.makeText(FirstLaunch.this, "Data not Inserted", Toast.LENGTH_LONG).show();


                        }



                    }
                }
        );


    }

}