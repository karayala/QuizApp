package com.example.kartikayala.quizapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kartikayala on 2/20/16.
 */
public class ImageFragment extends Fragment {
    private static TextView textview;
    private static ImageView imageView;
    public String textS;
    public String imageS;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.image_fragment, container, false);
        textview = (TextView) v.findViewById(R.id.imagefrag_desc);
        textview.setText(textS);


        imageView = (ImageView) v.findViewById(R.id.imagefrag_image);
        if(imageS.equals("obama.jpg")){
            imageView.setImageResource(R.drawable.obama);
        }else if(imageS.equals("hillary.jpg")){
            imageView.setImageResource(R.drawable.hillary);
        }else{
            imageView.setImageResource(R.drawable.sanders);
        }
        return v;
    }

    public void set(String text, String image){
        textS = text;
        imageS = image;
    }


}
