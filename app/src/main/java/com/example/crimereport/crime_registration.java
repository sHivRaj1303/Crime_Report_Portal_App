package com.example.crimereport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class crime_registration extends AppCompatActivity {

    Button upload, submit;
    ImageView image;
   private final int IMG_REQUEST_ID =1;
   private Uri u;
   FirebaseStorage storage;
   StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_registration);

        upload= findViewById(R.id.upload);
        submit= findViewById(R.id.btnsubmitcrime);
        image= findViewById(R.id.pimg);

        storage=FirebaseStorage.getInstance();
        storageReference=storage.getReference();

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i,"select picture"),IMG_REQUEST_ID);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (u!=null){
                    StorageReference reference= storageReference.child("picture/"+ UUID.randomUUID().toString());
                    reference.putFile(u).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(crime_registration.this, "saved", Toast.LENGTH_SHORT).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(crime_registration.this, "ERROR", Toast.LENGTH_SHORT).show();
                        }
                    });
                }



            }
        });





    }
}