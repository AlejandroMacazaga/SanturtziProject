package com.example.santurtzi.A6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.santurtzi.R;

public class A6 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a6);
    }

    public void abrirFuerte(View v)
    {
        Intent intent=new Intent(A6.this,A6Juego.class);
        startActivity(intent);

    }

}