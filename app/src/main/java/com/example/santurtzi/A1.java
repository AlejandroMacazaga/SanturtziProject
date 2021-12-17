package com.example.santurtzi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class A1 extends AppCompatActivity
{

    private int nivel;

    private ConstraintLayout clPrincipal;

    private GifImageView gifRespuestas;

    private GifDrawable[] gifsAciertos;
    private GifDrawable gifAlgun;
    private GifDrawable gifMal;

    private int[] fondos;

    private FragmentContainerView frgCancion;
    private int[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g11);

        nivel=0;
        cargarRecursos();

        clPrincipal=findViewById(R.id.clPrincipal);
        clPrincipal.setBackgroundResource(fondos[nivel]);

        gifRespuestas=findViewById(R.id.gifRespuestas);

        frgCancion = findViewById(R.id.frgCancion);
    }

    private void cargarRecursos()
    {
        gifsAciertos= new GifDrawable[3];
        try
        {
            GifDrawable gif=new GifDrawable(getResources(), R.drawable.gif_todas_correct1);
            gifsAciertos[0]=gif;

            gif=new GifDrawable(getResources(), R.drawable.gif_todas_correct2);
            gifsAciertos[1]=gif;

            gif=new GifDrawable(getResources(), R.drawable.gif_todas_correct3);
            gifsAciertos[2]=gif;

            gifAlgun= new GifDrawable(getResources(),R.drawable.gif_algunfallo);
            gifMal= new GifDrawable(getResources(),R.drawable.gif_todosfallos);
        }
        catch(IOException e)
        {
            Log.e("Error","Error con los gifs");
        }

        fondos= new int[]{R.mipmap.g1fondo1_foreground,R.mipmap.g1fondo2_foreground,R.mipmap.g1fondo3_foreground};

        fragments= new int[]{R.layout.fragment_cancion1,R.layout.fragment_cancion2};////////////////////////////////////////////////////////////////////////////
    }

    //0 algun fallo
    //1 todas bien
    //-1 todas mal
    public void cambiarFragment(int aciertos)
    {
        switch (aciertos)
        {
            case -1:
                gifRespuestas.setImageDrawable(gifMal);
                break;
            case 0:
                gifRespuestas.setImageDrawable(gifAlgun);
                break;
            case 1:
                gifRespuestas.setImageDrawable(gifsAciertos[nivel]);
                nivel++;
                if(nivel<3)
                {
                    clPrincipal.setBackgroundResource(fondos[nivel]);
                    //cambiar de fragment
                }
                else
                {
                    //fin de la actividad ºº
                }
                break;
        }
    }

}