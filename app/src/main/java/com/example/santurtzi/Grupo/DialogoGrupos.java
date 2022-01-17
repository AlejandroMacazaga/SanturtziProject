package com.example.santurtzi.Grupo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.santurtzi.R;

public class DialogoGrupos extends DialogFragment
{

    private OnDialogoConfirmacionListener listener;

    private EditText txtNomGrupo;
    private EditText txtInteGrupo;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View d= inflater.inflate(R.layout.dialogo_grupos, null);
        builder.setView(d);
        builder.setMessage("")
                .setTitle("Crear un nuevo grupo")
                .setPositiveButton("ACEPTAR",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Grupo g= recogerGrupo();
                                listener.onPossitiveButtonClick(g);
                            }
                        })
                .setNegativeButton("CANCELAR",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listener.onNegativeButtonClick();
                            }
                        });

        txtNomGrupo=d.findViewById(R.id.txtNomGrupo);
        txtInteGrupo=d.findViewById(R.id.txtInteGrupo);
        return builder.create();
    }

    private Grupo recogerGrupo()
    {
        String s=txtInteGrupo.getText().toString();
        int inte=Integer.parseInt(s);
        String nom=txtNomGrupo.getText().toString();
        Grupo g= new Grupo(txtNomGrupo.getText().toString(),inte,0);
        return g;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            listener = (OnDialogoConfirmacionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    " no Implemento OnDialogoConfirmacionListener");
        }
    }

    public interface OnDialogoConfirmacionListener{
        void onPossitiveButtonClick(Grupo g); //Eventos Botón Positivos
        void onNegativeButtonClick(); //Eventos Botón Negativo
    }
}
