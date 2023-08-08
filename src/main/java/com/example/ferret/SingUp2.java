package com.example.ferret;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import java.util.Locale;

public class SingUp2 extends AppCompatActivity {

    public static final String TAG = "Sing Up Activity";

    private EditText mEditTextFullName , mEditTextEmail, mEditTextUserName, mEditTextPassword, mEditTextPassword2;

    private AppCompatButton mButtonSingUp;

    private AppCompatTextView mTextViewAlreadyLogin;

    private ProgressBar mProgressBar;

    private String mStringName, mStringEmail, mStringPassword, mStringFullName;

    private boolean isRequired(){

        if(TextUtils.isEmpty(mEditTextFullName.getText()) ||
        TextUtils.isEmpty(mEditTextEmail.getText()) ||
        TextUtils.isEmpty(mEditTextUserName.getText()) ||
        TextUtils.isEmpty(mEditTextPassword.getText()) ||
        TextUtils.isEmpty(mEditTextPassword2.getText())
        ){
            return true;
        } else {
            return false;
        }
    }
    private boolean isSamePassword(){
        String mPass1 = mEditTextPassword.getText().toString().trim();
        String mPass2 = mEditTextPassword2.getText().toString().trim();
        return mPass1.equals(mPass2);

    }

    private void performActivityLogin(){
        Intent mIntent = new Intent(getApplicationContext(), Login.class);
        startActivity(mIntent);
        finish();
    }

    private void postData(){
        if(isRequired()){
            String mTextMessage = getString(R.string.text_error_all_fields_required);
            Toast.makeText(getApplicationContext(), mTextMessage, Toast.LENGTH_SHORT).show();
            return;
        }
        if(!isSamePassword()){
            String mTextMessage = getString(R.string.text_password_are_not_same);
            Toast.makeText(getApplicationContext(), mTextMessage, Toast.LENGTH_SHORT).show();
            return;
        }

        mStringName = String.valueOf(mEditTextUserName.getText());
        mStringEmail = String.valueOf(mEditTextEmail.getText()).toLowerCase(Locale.ROOT);
        mStringPassword = String.valueOf(mEditTextPassword.getText()).toString().trim();
        mStringFullName = String.valueOf(mEditTextFullName.getText()).trim();

        mProgressBar.setVisibility(View.VISIBLE);

        User mUser = new User( mStringFullName , mStringName, mStringPassword, mStringEmail, 0, "post", "otp" , System.currentTimeMillis());

        int vResult = UserDao.insertUser(mUser, getApplicationContext());

        String mTextMessage;

        mProgressBar.setVisibility(View.GONE);

        if(vResult <= 0){
            mTextMessage = getString(R.string.text_insert_error);
        }else {

            mTextMessage = getString(R.string.text_insert_success);
        }

        Intent mIntent = new Intent(getApplicationContext() , Login.class);
        startActivity(mIntent);
        finish();

    }

    public class ClickMyButtonSingUp implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            postData();;
        }
    }

    public class ClickMyViewAlreadyLogin implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            performActivityLogin();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        mEditTextEmail = findViewById(R.id.editText_email);

        mEditTextUserName = findViewById(R.id.editText_User);
        mEditTextPassword = findViewById(R.id.editText_password);
        mEditTextPassword2 = findViewById(R.id.editText_password2);


        mTextViewAlreadyLogin = findViewById(R.id.btn_volta_login);
        mTextViewAlreadyLogin.setOnClickListener(new ClickMyViewAlreadyLogin());

        mButtonSingUp = findViewById(R.id.button_sing_up);
        mButtonSingUp.setOnClickListener(new ClickMyButtonSingUp());

    }
}
