package com.example.santurtzi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class G1_1 extends AppCompatActivity
{

    private int nivel;

    private ConstraintLayout clPrincipal;

    private GifImageView gifRespuestas;

    private GifDrawable[] gifsAciertos;
    private GifDrawable gifAlgun;
    private GifDrawable gifMal;

    private int[] fondos;

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

    }

    public void cambiarFragment()
    {
        Log.i("pruebax","Funciona");
        try
        {
            GifDrawable gif=new GifDrawable(getResources(),R.drawable.gif_algunfallo);
            gifRespuestas.setImageDrawable(gif);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}