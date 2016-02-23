package com.example.kartikayala.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
/**
 * Created by kartikayala
 * Class: FinalActivity (Activity)
 * Goal : Provides the logic for the final activity activity.
 */
public class FinalActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        //Gets the message from the second fragment that includes the total score
        String scoreCount;
        scoreCount = getIntent().getStringExtra("MESSAGE");
        Log.d("temp", scoreCount);
        //Displays the total score to the user.
        TextView textView = (TextView) findViewById(R.id.final_total);
        textView.setText(scoreCount + "/5");
    }

    //(Method)**************startOver**************//
    //Goal: Provides functionality for when user presses the start over button.
    //      In that case, the program simply goes to the first activity.
    public void startOver(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
