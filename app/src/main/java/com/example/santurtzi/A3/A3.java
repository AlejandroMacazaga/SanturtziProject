package com.example.santurtzi.A3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.santurtzi.R;

public class A3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);
    }

    public void abrirPintar(View v)
    {
        Intent intent=new Intent(A3.this,Pinta.class);
        startActivity(intent);
    }
}