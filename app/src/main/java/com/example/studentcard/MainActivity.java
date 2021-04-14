package com.example.studentcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.Manifest.permission.CAMERA;

public class MainActivity extends AppCompatActivity {
    private CircleImageView image;
    private static final int SELECT_PICTURE=1;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=findViewById(R.id.student_image);

        image.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
            }
        });

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode==SELECT_PICTURE) {
                imageUri = data.getData();
                if (null !=imageUri) {
                    image=findViewById(R.id.student_image);
                    // update the preview image in the layout
                    image.setImageURI(imageUri);
                }
        }
    }

}