package com.example.kartikayala.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
/**
 * Created by kartikayala
 * Class: MainActivity (Activity)
 * Goal : Provides the logic for the Main activity. This is the front page of the entire application.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //(Method)**************startQuiz**************//
    //Goal: Provides functionality for when the user starts the quiz.
    //      Moves the user to activity 2 if the user presses the "Start Quiz" button.
    public void startQuiz(View v){
        Intent transaction = new Intent(this, SecondActivity.class);
        startActivity(transaction);
    }
}
