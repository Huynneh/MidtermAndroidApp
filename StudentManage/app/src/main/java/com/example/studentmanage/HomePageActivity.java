package com.example.studentmanage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

public class HomePageActivity extends AppCompatActivity {
//    FirebaseAuth auth;
//    FirebaseUser user;
    private BottomNavigationView bottomNavigationView;
    private ImageView imgAddNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        replaceFragment(new HomepageFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                replaceFragment(new HomepageFragment());
                return true;
            }
            if (item.getItemId() == R.id.profile) {
                replaceFragment(new SettingFragment());
                return true;
            }
            return true;
        });

//        auth = FirebaseAuth.getInstance();
//        user = auth.getCurrentUser();
//        if(user == null) {
//            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//            startActivity(intent);
//            finish();
//        }
//        else {
//
//        }

        imgAddNew = findViewById(R.id.imgAddNew);
        imgAddNew.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddNewUserActivity.class);
            startActivity(intent);
//            finish();
        });

    }
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }
}