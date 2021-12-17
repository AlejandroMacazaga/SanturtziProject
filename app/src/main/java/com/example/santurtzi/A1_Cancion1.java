package com.example.santurtzi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Iterator;

public class A1_Cancion1 extends Fragment implements A1_Cancion
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

    private View.OnKeyListener onKeyListener;

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
        v = getView();
        onKeyListener= new A1_OnKeyListener(this);
        edits=new HashMap<EditText,String>();

        btnComprobar=v.findViewById(R.id.btnComprobar);

        edtH1=v.findViewById(R.id.edtH1);
        edits.put(edtH1,"edtH1");
        edtH1.setOnKeyListener(onKeyListener);

        edtH2=v.findViewById(R.id.edtH2);
        edits.put(edtH2,"edtH2");
        edtH2.setOnKeyListener(onKeyListener);

        edtH3=v.findViewById(R.id.edtH3);
        edits.put(edtH3,"edtH3");
        edtH3.setOnKeyListener(onKeyListener);

        edtH4=v.findViewById(R.id.edtH4);
        edits.put(edtH4,"edtH4");
        edtH4.setOnKeyListener(onKeyListener);

        edtH5=v.findViewById(R.id.edtH5);
        edits.put(edtH5,"edtH5");
        edtH5.setOnKeyListener(onKeyListener);

        edtH6=v.findViewById(R.id.edtH6);
        edits.put(edtH6,"edtH6");
        edtH6.setOnKeyListener(onKeyListener);

        edtH7=v.findViewById(R.id.edtH7);
        edits.put(edtH7,"edtH7");
        edtH7.setOnKeyListener(onKeyListener);

        edtH8=v.findViewById(R.id.edtH8);
        edits.put(edtH8,"edtH8");
        edtH8.setOnKeyListener(onKeyListener);

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

    @Override
    public void comprobarRespuestas()
    {
        A1_GestorCancion gc= new A1_GestorCancion(getView().getContext(),this);

        bien=0;

        Iterator<EditText> it=edits.keySet().iterator();
        while(it.hasNext())
        {
            EditText edt=it.next();
            String key=edits.get(edt);
            String respBien=gc.respuesta(key);

            String respAlum=edt.getText().toString().toLowerCase();
            if(respAlum!=null) {
                if (respAlum.length() > 0) {
                    if (!respAlum.equals(respBien.toLowerCase())) {
                        edt.setBackground(v.getResources().getDrawable(R.drawable.rounded_edittext_mal));
                        //edt.setBackgroundColor(v.getResources().getColor(R.color.rojoError));
                    } else {
                        edt.setBackground(v.getResources().getDrawable(R.drawable.rounded_edittext_bien));
                        //edt.setBackgroundColor(v.getResources().getColor(R.color.verdeAcert));
                        edt.setEnabled(false);
                        edt.setText(respBien);
                        bien += 1;
                    }
                }
            }

        }
        Log.i("pruebilla", String.valueOf(bien));
        gestionarFallos();
    }

    @Override
    public void gestionarFallos()
    {
        switch (bien)
        {
            case 0:
                ((A1)getActivity()).cambiarFragment(-1);
                A1_Cancion.hideKeyboardFrom(v.getContext(),v);
                break;
            case 8:
                ((A1)getActivity()).cambiarFragment(1);//Llama al metodo de la actividad la cual va a cambiar el fondo y el gif
                A1_Cancion.hideKeyboardFrom(v.getContext(),v);
                break;
            default:
                A1_Cancion.hideKeyboardFrom(v.getContext(),v);
                ((A1)getActivity()).cambiarFragment(0);
                break;
        }
        //reproducir audio
    }

}