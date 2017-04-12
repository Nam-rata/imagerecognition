package com.example.admin.recogneyes;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class CameraActivity extends AppCompatActivity {
    private File imageFile;

    private Button a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        a=(Button)findViewById(R.id.takePicture);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                process(v);
            }
        });
    }

    public void process(View view)
    {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        imageFile=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"test.jpg");
        Uri tempuri=Uri.fromFile(imageFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,tempuri);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==0)
        {
            switch (resultCode)
            {
                case Activity.RESULT_OK:
                    if(imageFile.exists())
                    {
                        Toast.makeText(this, "The file was saved at "+imageFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(this, "There was an error saving the file ", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case Activity.RESULT_CANCELED:
                    break;
                default:
                    break;
            }
        }
    }
}
