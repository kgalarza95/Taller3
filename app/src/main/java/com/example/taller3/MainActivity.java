package com.example.taller3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void abrirfrmNuevoUsuario(View v){
        Intent objInten = new Intent(v.getContext(), frmNuevoUsuario.class);
        startActivityForResult(objInten, 0);
    }
}