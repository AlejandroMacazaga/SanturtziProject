package com.example.santurtzi.Inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.santurtzi.A1.A1;
import com.example.santurtzi.A2.A2_1;
import com.example.santurtzi.A3.A3;
import com.example.santurtzi.A5.A5_Sotera;
import com.example.santurtzi.A6.A6;
import com.example.santurtzi.Grupo.Grupo;
import com.example.santurtzi.R;

public class Mapa extends AppCompatActivity
{

    private Grupo g;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        this.g= (Grupo) getIntent().getSerializableExtra("grupo");
    }

    public void irG1(View v)
    {
        Intent intent=new Intent(Mapa.this, A1.class);
        intent.putExtra("grupo",this.g);
        startActivity(intent);
    }

    public void irG2(View v)
    {
        Intent intent=new Intent(Mapa.this, A2_1.class);
        intent.putExtra("grupo",this.g);
        startActivity(intent);
    }

    public void irG3(View v)
    {
        Intent intent=new Intent(Mapa.this, A3.class);
        intent.putExtra("grupo",this.g);
        startActivity(intent);
    }

    public void irG4(View v)
    {
        Intent intent=new Intent(Mapa.this, TestMapa.class);
        intent.putExtra("grupo",this.g);
        startActivity(intent);
    }

    public void irG5(View v)
    {
        Intent intent=new Intent(Mapa.this, A5_Sotera.class);
        intent.putExtra("grupo",this.g);
        startActivity(intent);
    }

    public void irG6(View v)
    {
        Intent intent=new Intent(Mapa.this, A6.class);
        intent.putExtra("grupo",this.g);
        startActivity(intent);
    }

    public void irG7(View v)
    {
//        Intent intent=new Intent(FakeMapa.this,G1_1.class);
//        intent.putExtra("grupo",this.g);
//        startActivity(intent);
    }


}