package com.example.kartikayala.quizapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.Random;

public class SecondActivity extends FragmentActivity {
    public int Counter;
    public int QuestionCounter = 0;
    public QuestionList[] mainList = new QuestionList[6];
    public int[] selectionList = new int[6];
    public int[] used = new int[6];
    public int usedIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        addData();
        QuestionCounter++;
        display();
    }

    public void addData(){
        String[] Q0 = {"Bush","Palin","Obama"};
        String[] Q2 = {"China,", "Vietnam","Russia"};
        String[] Q5 = {"The savior has risen", "YOLO", "Feel the Bern"};
        String[] test = new String[3];
        mainList[0] = new QuestionList(null, "What President was present in 2005?", "Bush" ,0, Q0);
        mainList[1] = new QuestionList("sanders.jpg", "Who is this?", "Bernie Sanders", -1, null);
        mainList[2] = new QuestionList(null, "What nation can Sarah Palin see from Alaska?", "Russia", 2, Q2);
        mainList[3] = new QuestionList("obama.jpg", "Who is this guy’s vice president?", "Joe Biden", -1, null);
        mainList[4] = new QuestionList("hillary.jpg", "Who is this?", "Hillary Clinton", -1, null);
        mainList[5] = new QuestionList(null, "What is a common Bernie Sanders slogan?", "Feel the Bern", 2, Q5);
    }

    public void display(){
        Random randomGenerator = new Random();
        // if(usedIndex>0)
        int index;
        boolean repeated = false;

        do{
            index = randomGenerator.nextInt(6);
            boolean found = false;
            for(int i = 0; i< used.length; i++){
                if(index == used[i]){
                    found = true;
                }
            }
            if(found == true){
                repeated = true;
            }else{
                repeated = false;
            }
        }while(repeated == true);
        used[usedIndex] = index;
        usedIndex++;

        if(mainList[index].getAnswerID() != -1){
            displayFrag(1, index);
        }else{
            displayFrag(0, index);
        }
    }

    public void displayFrag(int i, int index){
        FragmentManager FM = getFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        ImageFragment IF = new ImageFragment();
        TextFragment TF = new TextFragment();

        //i=0 means image
        if(QuestionCounter == 1){
            if(i==0){ //image
                FT.add(R.id.QuestionContainer, IF);
                IF.set(mainList[index].getQuestion(), mainList[index].getimage());
                FT.commit();
            }else{
                FT.add(R.id.QuestionContainer, TF);
                TF.set(mainList[index].getQuestion(), mainList[index].getAnswers());
                FT.commit();
            }
        }else{
            if(i == 0){
                IF.set(mainList[index].getQuestion(), mainList[index].getimage());
                FT.replace(R.id.QuestionContainer,IF);
                FT.commit();
            }else{
                FT.replace(R.id.QuestionContainer,TF);
                TF.set(mainList[index].getQuestion(), mainList[index].getAnswers());
                FT.commit();
            }
        }
    }

    public void displayText(){
        FragmentManager FM = getFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        TextFragment TF = new TextFragment();
        FT.add(R.id.QuestionContainer, TF);
        FT.commit();
    }

    public void displayImage(){
        FragmentManager FM = getFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        ImageFragment IF = new ImageFragment();
        FT.add(R.id.QuestionContainer, IF);
        FT.commit();
    }

    public void startOver(View v){
        Intent transaction = new Intent(this, MainActivity.class);
        startActivity(transaction);
    }

    public void submitAnswer(View view){
        if(mainList[used[usedIndex-1]].getAnswerID() != -1){
            boolean[] results = new boolean[3];
            RadioButton r1 = (RadioButton)findViewById(R.id.textfrag_o1);
            RadioButton r2 = (RadioButton)findViewById(R.id.textfrag_o2);
            RadioButton r3 = (RadioButton)findViewById(R.id.textfrag_o3);
            results[0] = r1.isChecked();
            results[1] = r2.isChecked();
            results[2] = r3.isChecked();
            int answerID = mainList[used[usedIndex-1]].getAnswerID();
            if(results[answerID]){
                Log.d("temp", "True");
                Counter++;
            }
        }else{
            // View temp = (View)
            EditText text = (EditText) findViewById(R.id.imagefrag_editText);
            String userAnswer = text.getText().toString().trim().toUpperCase();
            String actualAnswer = mainList[used[usedIndex-1]].getAnswer().trim().toUpperCase();
            Log.d("temp",userAnswer);
            if(userAnswer.equals(actualAnswer)){
                Log.d("temp","You got that right!!!");
                Counter++;
            }
        }
        QuestionCounter++;

        if(QuestionCounter <= 5) {
            display();
        }else{
            Intent transaction = new Intent(this, FinalActivity.class);
            transaction.putExtra("MESSAGE", Integer.toString(Counter));
            Log.d("temp", Integer.toString(Counter));
            startActivity(transaction);
        }

    }
}
