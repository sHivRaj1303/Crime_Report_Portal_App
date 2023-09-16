package com.example.crimereport;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.InputStream;
import java.util.Random;

public class sign_in_with3 extends AppCompatActivity {
    Spinner crimetype;
    String[] ctype={"Cyber crime", "Kidnapping", " Robbery", "Murder","Drug Smuggler"," Burglary","Other"};
    EditText  crimedate, crimelocation,crimedes;
    Uri filepath;
    Bitmap bitmap;
    ImageView img1;
    Button btnsubmit, btnupload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_with3);

        crimetype=(Spinner)findViewById(R.id.type);
        crimedate=(EditText)findViewById(R.id.date);
        crimelocation=(EditText)findViewById(R.id.location);
         crimedes=(EditText)findViewById(R.id.des);
         img1=(ImageView) findViewById(R.id.pimg2);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(sign_in_with3.this,android.R.layout.simple_spinner_item,ctype);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        crimetype.setAdapter(adapter);
        crimetype.setSelection(0, false);
        View v = crimetype.getSelectedView();
        if (v != null) {
            ((TextView) v).setText("Select an item");
        }


        crimetype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(sign_in_with3.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        crimedate=(EditText)findViewById(R.id.date);
//        // Get current date
//        crimedate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Get the current date
//                Calendar currentDate = Calendar.getInstance();
//                int year = currentDate.get(Calendar.YEAR);
//                int month = currentDate.get(Calendar.MONTH);
//                int dayOfMonth = currentDate.get(Calendar.DAY_OF_MONTH);
//
//                // Create a DatePickerDialog to show the calendar dialog
//                DatePickerDialog datePickerDialog = new DatePickerDialog(sign_in_with3.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                        // Set the selected date in the EditText
//                        String selectedDate = day + "/" + (month + 1) + "/" + year;
//                        crimedate.setText(selectedDate);
//                    }
//                }, year, month, dayOfMonth);
//
//                // Show the calendar dialog
//                datePickerDialog.show();
//            }
//        });

        img1=(ImageView) findViewById(R.id.pimg2);
        btnupload=(Button)findViewById(R.id.btnselectimg);
        btnsubmit=(Button)findViewById(R.id.btnsubmit2);

        btnupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dexter.withActivity(sign_in_with3.this)
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response)
                            {
                                Intent intent=new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent,"Select Image File"),1);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                token.continuePermissionRequest();
                            }
                        }).check();
            }
        });

       btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                uploadtofirebase();
                Intent intent1 = new Intent(sign_in_with3.this, retrive_data_2.class);
                startActivity(intent1);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if(requestCode==1  && resultCode==RESULT_OK)
        {
            filepath=data.getData();
            try{
                InputStream inputStream=getContentResolver().openInputStream(filepath);
                bitmap= BitmapFactory.decodeStream(inputStream);
                img1.setImageBitmap(bitmap);
            }catch (Exception ex)
            {

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    private void uploadtofirebase()
    {
        final ProgressDialog dialog=new ProgressDialog(this);
        dialog.setTitle("File Uploader");
        dialog.show();



        FirebaseStorage storage=FirebaseStorage.getInstance();
        final StorageReference uploader=storage.getReference("Image1"+new Random().nextInt(50));

        uploader.putFile(filepath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
                    {
                        uploader.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri){

                                dialog.dismiss();
                                FirebaseDatabase db=FirebaseDatabase.getInstance();
                                DatabaseReference root=db.getReference("users");

                                model obj=new model(crimetype.getSelectedItem().toString(),crimedate.getText().toString(),crimelocation.getText().toString(),crimedes.getText().toString(),uri.toString());
                                root.child(crimetype.getSelectedItem().toString()).setValue(obj);

                                crimetype.setSelection(0);
                                crimedate.setText(" ");
                                crimelocation.setText(" ");
                                crimedes.setText(" ");

//                                img1.setImageResource(R.drawable.firbg1);
                                Toast.makeText(getApplicationContext(),"Uploaded",Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot)
                    {
                        float percent=(100*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                        dialog.setMessage("Uploaded :"+(int)percent+" %");
                    }
                });

    }


}




