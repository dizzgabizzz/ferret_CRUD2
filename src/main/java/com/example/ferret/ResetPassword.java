package com.example.ferret;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class ResetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senha);
    }
}

//
//
//    private void showSignUp() {
//        Intent mIntent = new Intent(getApplicationContext() , SignUpActivity1.class);
//        startActivity(mIntent);
//        finish();
//
//    }
//
//    public class ClickMyNewUser implements View.OnClickListener{
//        @Override
//        public void onClick(View v) {
//            showSignUp();
//        }
//    }
