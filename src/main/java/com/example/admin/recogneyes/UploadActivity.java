package com.example.admin.recogneyes;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;

public class UploadActivity extends AppCompatActivity implements View.OnClickListener {
    
    private static final int RESULT_LOAD_IMAGE=1;
    public static final int GET_FROM_GALLERY=3;
    private StorageReference mStorageRef;
    private StorageReference photoRef;
    UploadTask uploadTask;
    private Uri selectedImage;


    ImageView imageToUpload,downloadedImage;
    Button bUploadImage,bDownloadImage;
    EditText uploadImageName,downloadImageName;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mStorageRef = FirebaseStorage.getInstance().getReference();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        imageToUpload=(ImageView)findViewById(R.id.imageToUpload);
        //downloadedImage=(ImageView)findViewById(R.id.downloadedImage);

        bUploadImage=(Button)findViewById(R.id.bUploadImage);
       // bDownloadImage=(Button)findViewById(R.id.bDownloadImage);

        uploadImageName=(EditText)findViewById(R.id.etUploadName);
       // downloadImageName=(EditText)findViewById(R.id.etDownloadName);

        imageToUpload.setOnClickListener(this);
        bUploadImage.setOnClickListener(this);
       // bDownloadImage.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.imageToUpload:
                break;
            case R.id.bUploadImage:

                startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALLERY);



               break;
           // case R.id.bDownloadImage:
             //   break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {

                case GET_FROM_GALLERY:
                    if (resultCode == Activity.RESULT_OK) {
                        //data gives you the image uri. Try to convert that to bitmap
                        selectedImage = data.getData();
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                        Uri photo = selectedImage;

                        photoRef = mStorageRef.child("images/"+uploadImageName.getText()+".jpg");
                        uploadTask = photoRef.putFile(photo);

                        // Register observers to listen for when the download is done or if it fails
                        uploadTask.addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception exception) {
                                // Handle unsuccessful uploads
                                Toast.makeText(UploadActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                                Uri downloadUrl = taskSnapshot.getDownloadUrl();
                                Toast.makeText(UploadActivity.this, "Successfully Uploaded!", Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                    } else if (resultCode == Activity.RESULT_CANCELED) {

                    }
                    break;
            }
        } catch (Exception e) {

        }

    }

    }



