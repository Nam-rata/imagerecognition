package com.example.admin.recogneyes;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by admin on 4/4/2017.
 */

public class FirstFragment extends Fragment{

    View myView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.first_layout,container,false); //inflate used for rendering file
        return myView;
    }
}
