package com.example.santurtzi;

import android.graphics.Color;
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
import java.util.Iterator;
import java.util.Locale;

public class Cancion1 extends Fragment
{

    private View v;

    private Button btnComprobar;

    private int bien;

    private HashMap<EditText,String> edits;
    private EditText edtH1;
    private EditText edtH2;
    private EditText edtH3;
    private EditText edtH4;
    private EditText edtH5;
    private EditText edtH6;
    private EditText edtH7;
    private EditText edtH8;

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
        edits=new HashMap<EditText,String>();

        btnComprobar=v.findViewById(R.id.btnComprobar);

        edtH1=v.findViewById(R.id.edtH1);
        edits.put(edtH1,"edtH1");

        edtH2=v.findViewById(R.id.edtH2);
        edits.put(edtH2,"edtH2");

        edtH3=v.findViewById(R.id.edtH3);
        edits.put(edtH3,"edtH3");

        edtH4=v.findViewById(R.id.edtH4);
        edits.put(edtH4,"edtH4");

        edtH5=v.findViewById(R.id.edtH5);
        edits.put(edtH5,"edtH5");

        edtH6=v.findViewById(R.id.edtH6);
        edits.put(edtH6,"edtH6");

        edtH7=v.findViewById(R.id.edtH7);
        edits.put(edtH7,"edtH7");

        edtH8=v.findViewById(R.id.edtH8);
        edits.put(edtH8,"edtH8");

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
        GestorCancion gc= new GestorCancion(getView().getContext());

        bien=0;

        Iterator<EditText> it=edits.keySet().iterator();
        while(it.hasNext())
        {
            EditText edt=it.next();
            String key=edits.get(edt);
            String respBien=gc.respuesta(key);

            String respAlum=edt.getText().toString().toLowerCase();
            if(respAlum!=null)
            {
                if(!respAlum.equals(respBien.toLowerCase()))
                {
                    edt.setBackgroundColor(v.getResources().getColor(R.color.rojoError));
                }
                else
                {
                    edt.setBackgroundColor(v.getResources().getColor(R.color.verdeAcert));
                    edt.setEnabled(false);
                    edt.setText(respBien);
                    bien+=1;
                }
            }

        }
        Log.i("pruebilla", String.valueOf(bien));
        gestionarFallos();
    }

    public void gestionarFallos()
    {
        switch (bien)
        {
            case 0:

                break;
            case 8:
                ((G1_1)getActivity()).cambiarFragment();//Llama al metodo de la actividad la cual va a cambiar todoo
                break;
            default:
                break;
        }
        //reproducir audio
    }

}