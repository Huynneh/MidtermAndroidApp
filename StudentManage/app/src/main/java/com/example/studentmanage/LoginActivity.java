package com.example.studentmanage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentmanage.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private EditText edtUsername, edtPassword;
    private TextView tvInvalid;
    private AppCompatButton btnLogin;

    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        tvInvalid = findViewById(R.id.tvInvalid);

        btnLogin.setOnClickListener(view -> {
            Intent intent = new Intent(this, HomePageActivity.class);;
            startActivity(intent);
            finish();
        });

        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username, password;
                username = String.valueOf(edtUsername.getText().toString()).trim();
                password = String.valueOf(edtPassword.getText().toString()).trim();


                if(TextUtils.isEmpty(username)) {
                    tvInvalid.setText("Username is empty. Please enter");
                    return;
                }
                if(TextUtils.isEmpty(password)) {
                    tvInvalid.setText("Password is empty. Please enter");
                    return;
                }

                mAuth.signInWithEmailAndPassword(username, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(LoginActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Manager");
                Query checkManagerDatabase = reference.orderByChild("username").equalTo(username);

//                checkManagerDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.exists()) {
//                            edtUsername.setError(null);
//                            String passFromBD = snapshot.child(username).child("password").getValue(String.class);
//
//                            if (passFromBD.equals(password)) {
//                                Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
//                                startActivity(intent);
//                                finish();
//                            }
//                            else {
//                                Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_LONG).show();
//                                password.requestFocus();
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
            }
        });
    }
}