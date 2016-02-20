package com.example.kartikayala.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        String scoreCount;
        scoreCount = getIntent().getStringExtra("MESSAGE");
        Log.d("temp", scoreCount);
        TextView textView = (TextView) findViewById(R.id.final_total);
        textView.setText(scoreCount + "/5");
    }

    public void startOver(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
