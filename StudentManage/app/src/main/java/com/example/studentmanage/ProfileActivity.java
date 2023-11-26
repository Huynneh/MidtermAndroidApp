package com.example.studentmanage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_ENTER_NAME = 1;
    private ImageView imgAvatar, imgEdit;
    private TextView tvName, tvAge, tvPhone, tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);
        tvPhone = findViewById(R.id.tvPhone);
        tvStatus = findViewById(R.id.tvStatus);
        imgAvatar = findViewById(R.id.imgAvatar);

        imgEdit = findViewById(R.id.imgEdit);
        imgEdit.setOnClickListener(view -> {
//            Intent intent = new Intent(this, EditProfileActivity.class);
//            startActivity(intent);
            openEnterNameActivity();
        });
    }

    public void openActivity(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        intent.putExtra("name", tvName.getText().toString());
        intent.putExtra("age", tvAge.getText().toString());
        intent.putExtra("phone", tvPhone.getText().toString());
        intent.putExtra("status", tvStatus.getText().toString());

        startActivityForResult(intent, requestCode(clazz));
    }

    public void openEnterNameActivity() {
        openActivity(EditProfileActivity.class);
    }

    private int requestCode(Class<?> clazz) {
        return (clazz == EditProfileActivity.class) ? REQUEST_CODE_ENTER_NAME : 0;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ENTER_NAME && resultCode == RESULT_OK) {
            String name = data.getStringExtra("name");

            tvName.setText(data.getStringExtra("edtname"));
            tvAge.setText(data.getStringExtra("edtage"));
            tvPhone.setText(data.getStringExtra("edtphone"));
            tvStatus.setText(data.getStringExtra("edtstatus"));

            byte[] byteArray = data.getByteArrayExtra("avt");
            Bitmap imageBitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            imgAvatar.setImageBitmap(imageBitmap);
        }
    }
}