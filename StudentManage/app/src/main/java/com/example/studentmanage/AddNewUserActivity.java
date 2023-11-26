package com.example.studentmanage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class AddNewUserActivity extends AppCompatActivity {
    private ImageView imgBack;
    private EditText edtAddName, edtAddAge, edtAddPhone;
    private RadioGroup radioPos, radioStatus;
    private RadioButton rbtnManager, rbtnStudent, rbtnNormal, rbtnLocked;
    private AppCompatButton btnAddNew;
//    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        imgBack = findViewById(R.id.imgBack);

        edtAddName = findViewById(R.id.edtAddName);
        edtAddAge = findViewById(R.id.edtAddAge);
        edtAddPhone = findViewById(R.id.edtAddPhone);

        radioPos = findViewById(R.id.radioPos);
        radioStatus = findViewById(R.id.radioStatus);

        rbtnManager = findViewById(R.id.rbtnManager);
        rbtnStudent = findViewById(R.id.rbtnStudent);
        rbtnNormal = findViewById(R.id.rbtnNormal);
        rbtnLocked = findViewById(R.id.rbtnLocked);

        btnAddNew = findViewById(R.id.btnAddNew);

        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = edtAddName.getText().toString();
                final String age = edtAddAge.getText().toString();
                final String phone = edtAddPhone.getText().toString();

                int selectedPosId = radioPos.getCheckedRadioButtonId();
                int selectedStatusId = radioStatus.getCheckedRadioButtonId();

                if (name.isEmpty() || age.isEmpty() || phone.isEmpty() || selectedPosId == -1 || selectedStatusId == -1) {
                    Toast.makeText(AddNewUserActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    RadioButton selectedPosRadioButton = findViewById(selectedPosId);
                    RadioButton selectedStatusRadioButton = findViewById(selectedStatusId);

                    final String position = selectedPosRadioButton.getText().toString();
                    final String status = selectedStatusRadioButton.getText().toString();

                    // Tiếp tục xử lý khi thông tin đủ
                    // ...
                }
            }
        });


    }
}