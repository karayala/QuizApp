package com.example.kartikayala.quizapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kartikayala
 * Class: ImageFragment (Fragment)
 * Goal : Provides the logic for the Image Fragment.
 */
public class ImageFragment extends Fragment {
    //**************Initial variables**************//
    private static TextView textview;
    private static ImageView imageView;
    public String textS;
    public String imageS;

    //**************onCreate**************//
    //Goal: Set the textview and imageview resources
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.image_fragment, container, false);
        //sets the textview with the setText() method.
        textview = (TextView) v.findViewById(R.id.imagefrag_desc);
        textview.setText(textS);
        //Sets the image view with the given resource.
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

    //(Method)**************Initial variables**************
    //Goal: set the text and image from passed in resources. This is meant to be constructed as a setter such that the properties can be set within Activity 2 (QuizView)
    public void set(String text, String image){
        textS = text;
        imageS = image;
    }


}
