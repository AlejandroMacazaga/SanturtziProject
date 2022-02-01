package com.example.santurtzi.A1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.santurtzi.Grupo.Grupo;
import com.example.santurtzi.Grupo.GrupoDao;
import com.example.santurtzi.Inicio.Grupos;
import com.example.santurtzi.Inicio.Mapa;
import com.example.santurtzi.R;

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
    
    private TextView txtAviso;
    private Button btnSalir;

    private String[] palabras1;

    private Grupo g;
    private int puntos;
    private boolean terminado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);

        nivel=0;
        cargarRecursos();

        clPrincipal=findViewById(R.id.clPrincipal);
        clPrincipal.setBackgroundResource(fondos[nivel]);

        gifRespuestas=findViewById(R.id.gifRespuestas);

        frgCancion = findViewById(R.id.frgCancion);
        txtAviso =findViewById(R.id.txtAviso);
        btnSalir=findViewById(R.id.btnSalir);

        g= (Grupo) getIntent().getSerializableExtra("grupo");
        terminado=false;
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

        fondos= new int[]{R.mipmap.a1fondo1_foreground,R.mipmap.a1fondo2_foreground,R.mipmap.a1fondo3_foreground};

        palabras1= new String[]{"orilla","salla","pantorrilla","vengo","corriendo","corsé","gritando","quien"};
    }

    //0 algun fallo
    //1 todas bien
    //-1 todas mal
    public void cambiarFragment(int aciertos)
    {
        MediaPlayer music;
        switch (aciertos)
        {
            case -1:
                gifRespuestas.setImageDrawable(gifMal);
                music=MediaPlayer.create(A1.this,R.raw.a1_ningun_acierto);
                music.start();
                puntos-=20;
                break;
            case 0:
                gifRespuestas.setImageDrawable(gifAlgun);
                music=MediaPlayer.create(A1.this,R.raw.a1_algun_fallo);
                music.start();
                puntos-=10;
                break;
            case 1:
                gifRespuestas.setImageDrawable(gifsAciertos[nivel]);
                nivel++;
                if(nivel<3)
                {
                    clPrincipal.setBackgroundResource(fondos[nivel]);
                    music=MediaPlayer.create(A1.this,R.raw.a1_correcto1);
                    music.start();
                    //cambiar de fragment
                    puntos+=40;
                }
                else
                {
                    music=MediaPlayer.create(A1.this,R.raw.a1_correcto2);
                    music.start();
                    frgCancion.setVisibility(View.INVISIBLE);
                    txtAviso.setVisibility(View.INVISIBLE);
                    //Y si lo animo en plan que se haga mas grande progresivamente
                    gifRespuestas.getLayoutParams().width=1100;
                    gifRespuestas.getLayoutParams().height=1000;
                    btnSalir.setVisibility(View.VISIBLE);
                    //fin de la actividad ºº
                }
                break;
        }
    }

    public void salir(View v)
    {
        if(!terminado)
        {
            GrupoDao gd=new GrupoDao(this.getBaseContext(),"Grupo",null,1);
            puntos+=50;
            gd.subirPuntos(this.g,puntos);
            terminado=true;
        }
        Intent intent = new Intent(A1.this, Mapa.class);
        startActivity(intent);
    }

    private void generarAyuda()/////////////////////////////////////////////////////////////////////////////////////////////////////////
    {
        switch (nivel)
        {

        }
    }

    public Grupo getG() {
        return g;
    }

    public void setG(Grupo g) {
        this.g = g;
    }
}