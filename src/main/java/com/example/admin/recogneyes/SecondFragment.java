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

public class SecondFragment extends Fragment{

    View myView;

Button b1,b2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myView=inflater.inflate(R.layout.second_layout,container,false); //inflate used for rendering file

        /*
        1. Alert Dialog Box (There will be two options)
        2. Gallery Intent
                 */

        b1=(Button) myView.findViewById(R.id.cbutton);
        b2=(Button)myView.findViewById(R.id.ubutton);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),CameraActivity.class);
    startActivity(intent);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),UploadActivity.class);
                startActivity(intent);

            }
        });



        return myView;
    }
}
