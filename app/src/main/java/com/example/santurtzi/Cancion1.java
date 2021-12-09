package com.example.santurtzi;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.HashMap;

public class Cancion1 extends Fragment
{

    private View v;

    private Button btnComprobar;

    private HashMap<EditText,String> edits;
    private EditText edtH1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cancion1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        v= getView();
        btnComprobar=v.findViewById(R.id.btnComprobar);
        edtH1=v.findViewById(R.id.edtH1);

        gestionarEventos();
    }

    private void gestionarEventos()
    {
        btnComprobar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                comprobarRespuestas();
            }
        });
    }

    public void comprobarRespuestas()
    {
        Log.i("pruebas","Comprobando Respuestas");
        GestorCancion gc= new GestorCancion(getView().getContext());
        Log.i("pruebas","recogiendo correcto "+gc.respuesta("h1"));
    }

}