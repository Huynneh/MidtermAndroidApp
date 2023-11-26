package com.example.studentmanage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class EditProfileActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private EditText edtName, edtAge, edtPhone, edtStatus;
    private ImageView imgCamera, imgAvatar;
    private AppCompatButton btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        edtPhone = findViewById(R.id.edtPhone);
        edtStatus = findViewById(R.id.edtStatus);
        imgCamera = findViewById(R.id.imgCamera);
        imgAvatar = findViewById(R.id.imgAvatar);
        btnSave = findViewById(R.id.btnSave);

        Intent intent = getIntent();
        if (intent != null) {
            edtName.setText(intent.getStringExtra("name"));
            edtAge.setText(intent.getStringExtra("age"));
            edtPhone.setText(intent.getStringExtra("phone"));
            edtStatus.setText(intent.getStringExtra("status"));
        }

        btnSave.setOnClickListener(view -> {
            sendResultBack();
        });

        imgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCameraIntent();
            }
        });
    }

    public void sendResultBack() {
        Intent intent = new Intent();
        intent.putExtra("edtname", edtName.getText().toString());
        intent.putExtra("edtage", edtAge.getText().toString());
        intent.putExtra("edtphone", edtPhone.getText().toString());
        intent.putExtra("edtstatus", edtStatus.getText().toString());
        Bitmap imageBitmap = ((BitmapDrawable) imgAvatar.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        intent.putExtra("avt", byteArray);
        setResult(RESULT_OK, intent);
        finish();
    }

    private void startCameraIntent() {
        Log.d("Camera", "Starting Camera Intent");
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } else {
            Log.e("Camera", "No camera app available");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                imgAvatar.setImageBitmap(imageBitmap);
            }
        }
    }
}