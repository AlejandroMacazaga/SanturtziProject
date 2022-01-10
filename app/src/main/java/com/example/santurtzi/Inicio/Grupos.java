package com.example.santurtzi.Inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.santurtzi.Grupo.Grupo;
import com.example.santurtzi.Grupo.GrupoDao;
import com.example.santurtzi.R;

public class Grupos extends AppCompatActivity {

    private GrupoDao grupoDao;
    private Grupo[] grupos;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupos);

        grupoDao=new GrupoDao(this.getBaseContext(),"Grupo",null,1);
        grupos=grupoDao.verGrupos();
    }
}