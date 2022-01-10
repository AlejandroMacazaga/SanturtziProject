package com.example.santurtzi.A1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.santurtzi.R;

import java.util.HashMap;
import java.util.Iterator;

public class A1_Cancion extends Fragment
{

    private View v;

    private Button btnComprobar;

    private int bien;
    private int nivel;

    private LinearLayout layCancion1;
    private LinearLayout layCancion2;
    private LinearLayout layCancion3;

    private HashMap[] tramos;
    private HashMap<EditText,String> edits1;
    private HashMap<EditText,String> edits2;
    private HashMap<EditText,String> edits3;

    private EditText edtH1;
    private EditText edtH2;
    private EditText edtH3;
    private EditText edtH4;
    private EditText edtH5;
    private EditText edtH6;
    private EditText edtH7;
    private EditText edtH8;
    private EditText edtH9;
    private EditText edtH10;
    private EditText edtH11;
    private EditText edtH12;
    private EditText edtH13;
    private EditText edtH14;
    private EditText edtH15;
    private EditText edtH16;
    private EditText edtH17;
    private EditText edtH18;
    private EditText edtH19;
    private EditText edtH20;

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

        edits1=new HashMap<EditText,String>();
        edits2=new HashMap<EditText,String>();
        edits3=new HashMap<EditText,String>();

        tramos= new HashMap[]{edits1,edits2,edits3};

        nivel=0;
        btnComprobar=v.findViewById(R.id.btnComprobar);

        layCancion1=v.findViewById(R.id.layCancion1);
        layCancion1.setVisibility(View.VISIBLE);

        layCancion2=v.findViewById(R.id.layCancion2);
        layCancion2.setVisibility(View.GONE);

        layCancion3=v.findViewById(R.id.layCancion3);
        layCancion3.setVisibility(View.GONE);

        edtH1=v.findViewById(R.id.edtH1);
        edits1.put(edtH1,"edtH1");
        edtH1.setOnKeyListener(onKeyListener);

        edtH2=v.findViewById(R.id.edtH2);
        edits1.put(edtH2,"edtH2");
        edtH2.setOnKeyListener(onKeyListener);

        edtH3=v.findViewById(R.id.edtH3);
        edits1.put(edtH3,"edtH3");
        edtH3.setOnKeyListener(onKeyListener);

        edtH4=v.findViewById(R.id.edtH4);
        edits1.put(edtH4,"edtH4");
        edtH4.setOnKeyListener(onKeyListener);

        edtH5=v.findViewById(R.id.edtH5);
        edits1.put(edtH5,"edtH5");
        edtH5.setOnKeyListener(onKeyListener);

        edtH6=v.findViewById(R.id.edtH6);
        edits1.put(edtH6,"edtH6");
        edtH6.setOnKeyListener(onKeyListener);

        edtH7=v.findViewById(R.id.edtH7);
        edits1.put(edtH7,"edtH7");
        edtH7.setOnKeyListener(onKeyListener);

        edtH8=v.findViewById(R.id.edtH8);
        edits1.put(edtH8,"edtH8");
        edtH8.setOnKeyListener(onKeyListener);

        edtH9=v.findViewById(R.id.edtH9);
        edits2.put(edtH9,"edtH9");
        edtH9.setOnKeyListener(onKeyListener);

        edtH10=v.findViewById(R.id.edtH10);
        edits2.put(edtH10,"edtH10");
        edtH10.setOnKeyListener(onKeyListener);

        edtH11=v.findViewById(R.id.edtH11);
        edits2.put(edtH11,"edtH11");
        edtH11.setOnKeyListener(onKeyListener);

        edtH12=v.findViewById(R.id.edtH12);
        edits3.put(edtH12,"edtH12");
        edtH12.setOnKeyListener(onKeyListener);

        edtH13=v.findViewById(R.id.edtH13);
        edits3.put(edtH13,"edtH13");
        edtH13.setOnKeyListener(onKeyListener);

        edtH14=v.findViewById(R.id.edtH14);
        edits3.put(edtH14,"edtH14");
        edtH14.setOnKeyListener(onKeyListener);

        edtH15=v.findViewById(R.id.edtH15);
        edits3.put(edtH15,"edtH15");
        edtH15.setOnKeyListener(onKeyListener);

        edtH16=v.findViewById(R.id.edtH16);
        edits3.put(edtH16,"edtH16");
        edtH16.setOnKeyListener(onKeyListener);

        edtH17=v.findViewById(R.id.edtH17);
        edits3.put(edtH17,"edtH17");
        edtH17.setOnKeyListener(onKeyListener);

        edtH18=v.findViewById(R.id.edtH18);
        edits3.put(edtH18,"edtH18");
        edtH18.setOnKeyListener(onKeyListener);

        edtH19=v.findViewById(R.id.edtH19);
        edits3.put(edtH19,"edtH19");
        edtH19.setOnKeyListener(onKeyListener);

        edtH20=v.findViewById(R.id.edtH20);
        edits3.put(edtH20,"edtH20");
        edtH20.setOnKeyListener(onKeyListener);

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
        A1_GestorCancion gc= new A1_GestorCancion(getView().getContext(),this);

        bien=0;

        Iterator<EditText> it=tramos[nivel].keySet().iterator();
        while(it.hasNext())
        {
            EditText edt=it.next();
            String key=(String) tramos[nivel].get(edt);
            String respBien=gc.respuesta(key);

            String respAlum=edt.getText().toString().toLowerCase();
            if(respAlum!=null) {
                if (respAlum.length() > 0) {
                    if (!respAlum.equals(respBien.toLowerCase())) {
                        edt.setBackground(v.getResources().getDrawable(R.drawable.rounded_edittext_mal));
                    } else {
                        edt.setBackground(v.getResources().getDrawable(R.drawable.rounded_edittext_bien));
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

    public void gestionarFallos()
    {
        A1_Cancion.hideKeyboardFrom(v.getContext(),v);
        switch(nivel)
        {
            case(0):
                switch (bien)
                {
                    case 0:
                        ((A1)getActivity()).cambiarFragment(-1);
                        break;
                    case 8:
                        ((A1)getActivity()).cambiarFragment(1);//Llama al metodo de la actividad la cual va a cambiar el fondo y el gif
                        nivel++;
                        layCancion1.setVisibility(View.GONE);
                        layCancion2.setVisibility(View.VISIBLE);
                        layCancion3.setVisibility(View.GONE);
                        break;
                    default:
                        ((A1)getActivity()).cambiarFragment(0);
                        break;
                }
                break;
            case(1):
                switch (bien)
                {
                    case 0:
                        ((A1)getActivity()).cambiarFragment(-1);
                        break;
                    case 3:
                        ((A1)getActivity()).cambiarFragment(1);//Llama al metodo de la actividad la cual va a cambiar el fondo y el gif
                        nivel++;
                        layCancion1.setVisibility(View.GONE);
                        layCancion2.setVisibility(View.GONE);
                        layCancion3.setVisibility(View.VISIBLE);
                        break;
                    default:
                        ((A1)getActivity()).cambiarFragment(0);
                        break;
                }
                break;
            case(2):
                switch (bien)
                {
                    case 0:
                        ((A1)getActivity()).cambiarFragment(-1);
                        break;
                    case 9:
                        ((A1)getActivity()).cambiarFragment(1);//Llama al metodo de la actividad la cual va a cambiar el fondo y el gif
                        nivel++;
                        layCancion1.setVisibility(View.GONE);
                        layCancion2.setVisibility(View.GONE);
                        layCancion3.setVisibility(View.INVISIBLE);
                        break;
                    default:
                        ((A1)getActivity()).cambiarFragment(0);
                        break;
                }
                break;
            default:
                //salir de la aplicacion con zorionak
                break;
        }
    }

    static void hideKeyboardFrom(Context context, View view)
    {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}