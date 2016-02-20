package com.example.kartikayala.quizapp;

/**
 * Created by kartikayala on 2/20/16.
 */
public class QuestionList {

    public String image = null;
    public String question;
    public String answer;
    public String[] answers;
    public String text;
    public int answerID;

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
