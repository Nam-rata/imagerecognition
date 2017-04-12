package com.example.admin.recogneyes;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 4/4/2017.
 */

public class ThirdFragment extends Fragment{

    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.third_layout,container,false); //inflate used for rendering file
        return myView;
    }
}
