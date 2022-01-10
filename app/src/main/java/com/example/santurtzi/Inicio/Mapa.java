package com.example.santurtzi.Inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.santurtzi.A1.A1;
import com.example.santurtzi.A2.A2_1;
import com.example.santurtzi.A5.A5_Sotera;
import com.example.santurtzi.A4;
import com.example.santurtzi.R;

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
        Intent intent=new Intent(Mapa.this,A4.class);
        startActivity(intent);
    }

    public void irG5(View v)
    {
        Intent intent=new Intent(Mapa.this, A5_Sotera.class);
        startActivity(intent);
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