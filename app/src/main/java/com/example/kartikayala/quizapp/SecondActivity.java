package com.example.kartikayala.quizapp;

/**
 * Created by kartikayala
 * Class: SecondActivity(Activity)
 * Goal : Provides the logic for the questions (SecondActivity). This is where the questions were displayed and set up.
 */
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
    //**************Initial variables**************//
    public int Counter; //Counts the total number of questions that were right.
    public int QuestionCounter = 0; //Counts total number of questions passed.
    public QuestionList[] mainList = new QuestionList[6]; //mainList is the array of questions
    public int[] used = new int[6]; //used lists a list of question indexes already used.
    public int usedIndex = 0;  //lists the index of the next item within used[] that can be used. This is used to track the most recently used index.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //[1] Adds Data and initializes quiz questions/array
        addData();
        QuestionCounter++; //Doing this requires qestion counter to be incremented, as the first question is about to be displayed.
        display(); //Displays first quiz question.
    }

    //(Method)**************addData**************//
    //Goal: Adds initial quiz data to the QuestionList class and initializes the over-arching array.
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

    //(Method)**************display**************//
    //Goal: Displays the content to the Second Activity
    //Uses a random generator to select a random question to display.
    public void display(){
        //[1]Generate a random question
        Random randomGenerator = new Random();
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

        //[2]Checks if the question is of the image fragment or text fragment. uses the displayFrag to display it accordingly.
        //identifier 1 = Text; identifier 0 = Image
        if(mainList[index].getAnswerID() != -1){
            displayFrag(1, index);
        }else{
            displayFrag(0, index);
        }
    }

    //(Method)**************displayFrag**************//
    //Input:
    //      1. i represents the identifier. 1 is for Text fragment; 0 is for image fragment
    //      2. index represents the index of the mainList Question array to display
    //Goal: To display the fragment based on if it is an image or a text. In the process, get the information passed to the fragment.
    public void displayFrag(int i, int index){
        //[1]Sets up the fragment properties
        FragmentManager FM = getFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        ImageFragment IF = new ImageFragment();
        TextFragment TF = new TextFragment();

        //i=0 means image
        //[2] Check 1 checks if it's the first question or not. If it's the first question, it simply adds the fragment
        //      If it's not the first question, it simply replaces an existing fragment
        if(QuestionCounter == 1){
            //[3] Check 2 checks if it needs to display/replace an image or a text fragment.
                    //[A] Pass required data to that fragment to set up the data
                    //[B] display the according fragment.
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

    //(Methods)**************displayText/Image**************//
    //Goal: displays the text/image
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

    ////(Method)**************startOver**************//
    //Goal: Provides functionality to start over button
    public void startOver(View v){
        Intent transaction = new Intent(this, MainActivity.class);
        startActivity(transaction);
    }

    //(Method)**************submitAnswer**************//
    //Goal: Provides functionality to submit an answer
    //      Calculates the score
    public void submitAnswer(View view){
        //[1] Check if it's submitting from an image or a text
        if(mainList[used[usedIndex-1]].getAnswerID() != -1){
            //[2]Text:
            //        Finds out what answers were selected and parses into array.
            boolean[] results = new boolean[3];
            RadioButton r1 = (RadioButton)findViewById(R.id.textfrag_o1);
            RadioButton r2 = (RadioButton)findViewById(R.id.textfrag_o2);
            RadioButton r3 = (RadioButton)findViewById(R.id.textfrag_o3);
            results[0] = r1.isChecked();
            results[1] = r2.isChecked();
            results[2] = r3.isChecked();
            //Checks answer
            int answerID = mainList[used[usedIndex-1]].getAnswerID();
            if(results[answerID]){
                Log.d("temp", "True");
                Counter++;
            }
        }else{
            //[3]Image:
            //      Obtains the input
            EditText text = (EditText) findViewById(R.id.imagefrag_editText);
            String userAnswer = text.getText().toString().trim().toUpperCase();
            String actualAnswer = mainList[used[usedIndex-1]].getAnswer().trim().toUpperCase();
            Log.d("temp",userAnswer);
            //Compares it to the actual answer
            if(userAnswer.equals(actualAnswer)){
                Log.d("temp","You got that right!!!");
                Counter++;
            }
        }
        QuestionCounter++;

        //[4]If the question counter reaches over 5, it exits into the final fragment.
        if(QuestionCounter <= 5) {
            display();
        }else{
            //Sends a message to the final activity that includes the final score
            //Passes onto the final activity.
            Intent transaction = new Intent(this, FinalActivity.class);
            transaction.putExtra("MESSAGE", Integer.toString(Counter));
            Log.d("temp", Integer.toString(Counter));
            startActivity(transaction);
        }

    }
}
