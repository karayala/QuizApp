package com.example.kartikayala.quizapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kartikayala
 * Class: TextFragment(Fragment)
 * Goal : Provides the logic for the Text Fragment.
 */
public class TextFragment extends Fragment {
    //**************Initial variables**************//
    private static TextView textview;
    public String textS;
    public String O1S;
    public String O2S;
    public String O3S;

    //**************onCreate**************//
    //Goal: Set the text on description and the options
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text_fragment, container, false);
        //sets the description and the options
        //uses the set(text/option) method to do so
        textview = (TextView) view.findViewById(R.id.textFrag_text);
        textview.setText(textS);
        textview = (TextView) view.findViewById(R.id.textfrag_o1);
        textview.setText(O1S);
        textview = (TextView) view.findViewById(R.id.textfrag_o2);
        textview.setText(O2S);
        textview = (TextView) view.findViewById(R.id.textfrag_o3);
        textview.setText(O3S);
        return view;
    }

    //(Method)**************set**************//
    //Goal: sets the description and options of the quiz prompt.
    //      This was meant to be set as a setter such that this can be set within the second activity.
    public void set(String text, String[]Options){
        textS = text;
        O1S = Options[0];
        O2S = Options[1];
        O3S = Options[2];
    }


}
