package com.example.santurtzi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;

public class G1_1 extends AppCompatActivity
{

    private ConstraintLayout clPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g11);

        clPrincipal=findViewById(R.id.clPrincipal);
        clPrincipal.setBackgroundResource(R.mipmap.g1fondo1_foreground);

    }

    public void cambiarFragment()
    {
        Log.i("pruebax","Funciona");
    }

}