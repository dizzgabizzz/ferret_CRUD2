package com.example.ferret;

import android.content.Intent;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Criar_Projeto extends AppCompatActivity {

    Button mButton;

    private void ShowNext() {
        Intent mIntent = new Intent(getApplicationContext(), Projeto.class);
        startActivity(mIntent);
        finish();
    }

}
