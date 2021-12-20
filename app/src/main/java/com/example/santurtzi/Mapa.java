package com.example.santurtzi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Mapa extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);




    }

    public void irG1(View v)
    {
        Intent intent=new Intent(Mapa.this, A1.class);
        startActivity(intent);
    }

    public void irG2(View v)
    {
        Intent intent=new Intent(Mapa.this, A2_1.class);
        startActivity(intent);
    }

    public void irG3(View v)
    {
//        Intent intent=new Intent(FakeMapa.this,G1_1.class);
//        startActivity(intent);
    }

    public void irG4(View v)
    {
//        Intent intent=new Intent(FakeMapa.this,G1_1.class);
//        startActivity(intent);
    }

    public void irG5(View v)
    {
//        Intent intent=new Intent(FakeMapa.this,A5_Sotera.class);
//        startActivity(intent);
    }

    public void irG6(View v)
    {
//        Intent intent=new Intent(FakeMapa.this,G1_1.class);
//        startActivity(intent);
    }

    public void irG7(View v)
    {
//        Intent intent=new Intent(FakeMapa.this,G1_1.class);
//        startActivity(intent);
    }


}