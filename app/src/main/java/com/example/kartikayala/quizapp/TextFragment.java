package com.example.kartikayala.quizapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kartikayala on 2/20/16.
 */
public class TextFragment extends Fragment {
    private static TextView textview;
    public String textS;
    public String O1S;
    public String O2S;
    public String O3S;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text_fragment, container, false);
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

    public void set(String text, String[]Options){
        textS = text;
        O1S = Options[0];
        O2S = Options[1];
        O3S = Options[2];
    }


}
