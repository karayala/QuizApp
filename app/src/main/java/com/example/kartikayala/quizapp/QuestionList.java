package com.example.kartikayala.quizapp;

/**
 * Created by kartikayala
 * Class: QuestionList(Class)
 * Goal : Provides the logic for the store of data for the different quiz questions.
 */
public class QuestionList {

    //**************Initial variables**************//
    //Stores the required data variables.
    public String image = null;
    public String question;
    public String answer;
    public String[] answers;
    public String text;
    public int answerID;

    ////**************Constructor**************//
    //Goal: Provides the user the resouces to pass in required variables.
    //      Constructs the class by storing the passed in variables to the constructed class variables
    public QuestionList(String image0, String question0, String answer0, int ID0, String[] answers0) {
        image = image0;
        question = question0;
        answer = answer0;
        answerID = ID0;
        if (ID0 != -1) {
            answers = new String[answers0.length];
            for (int i = 0; i < answers0.length; i++)
                answers[i] = answers0[i];
        }
    }

    //**************Public Getters**************//
    public String getimage(){
        return this.image;
    }
    public String getQuestion(){
        return this.question;
    }
    public int getAnswerID(){
        return this.answerID;
    }
    public String getAnswer(){
        return this.answer;
    }
    public String[] getAnswers(){
        return this.answers;
    }
    public String getText(){
        return this.text;
    }


}
