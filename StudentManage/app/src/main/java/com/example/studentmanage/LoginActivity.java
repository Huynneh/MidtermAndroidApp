package com.example.studentmanage;

import androidx.annotation.NonNull;
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
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private EditText edtUsername, edtPassword;
    private TextView tvInvalid;
    private AppCompatButton btnLogin;

//    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    public void onStart() {
        super.onStart();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//            Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
//            startActivity(intent);
//            finish();
//        }
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

//        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                startActivity(intent);
                finish();

//                String username, password;
//                username = String.valueOf(edtUsername.getText().toString());
//                password = String.valueOf(edtPassword.getText().toString());
//
//                if(TextUtils.isEmpty(username)) {
//                    tvInvalid.setText("Username is empty. Please enter");
//                    return;
//                }
//                if(TextUtils.isEmpty(password)) {
//                    tvInvalid.setText("Password is empty. Please enter");
//                    return;
//                }

//                mAuth.signInWithEmailAndPassword(username, password)
//                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
//                                    Intent intent = new Intent(getApplicationContext(), AdminHomePageActivity.class);
//                                    startActivity(intent);
//                                    finish();
//                                } else {
//                                    Toast.makeText(LoginActivity.this, "Authentication failed.",
//                                            Toast.LENGTH_SHORT).show();
//
//                                }
//                            }
//                        });

            }


        });
    }

    /**
     * A simple {@link Fragment} subclass.
     * Use the {@link HomepageFragment#newInstance} factory method to
     * create an instance of this fragment.
     */
    public static class HomepageFragment extends Fragment {
        private AppCompatButton btnSort;

        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

        // TODO: Rename and change types of parameters
        private String mParam1;
        private String mParam2;

        public HomepageFragment() {
            // Required empty public constructor
        }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomepageFragment.
         */
        // TODO: Rename and change types and number of parameters
        public static HomepageFragment newInstance(String param1, String param2) {
            HomepageFragment fragment = new HomepageFragment();
            Bundle args = new Bundle();
            args.putString(ARG_PARAM1, param1);
            args.putString(ARG_PARAM2, param2);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mParam1 = getArguments().getString(ARG_PARAM1);
                mParam2 = getArguments().getString(ARG_PARAM2);
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_homepage, container, false);

            btnSort = view.findViewById(R.id.btnSort);

            btnSort.setOnClickListener(v -> showPopupMenu(v));

            return view;
        }

        private void showPopupMenu(View view) {
            PopupMenu popupMenu = new PopupMenu(requireContext(), view);
            popupMenu.inflate(R.menu.sort_menu);
            popupMenu.setOnMenuItemClickListener(item -> {
                int itemId = item.getItemId();
                if (itemId == R.id.menuSortByName) {
                    // Xử lý sự kiện khi người dùng chọn sắp xếp theo tên
                    return true;
                } else if (itemId == R.id.menuSortByAge) {
                    // Xử lý sự kiện khi người dùng chọn sắp xếp theo điểm số
                    return true;
                } else {
                    return false;
                }
            });

            popupMenu.show();
        }
    }
}