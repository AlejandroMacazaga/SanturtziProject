package com.example.santurtzi.Grupo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.santurtzi.Inicio.MainActivity;

import java.util.ArrayList;

public class DialogoSeleccionGrupo extends DialogFragment
{

    private Grupo g;
    private MainActivity parent;

    public DialogoSeleccionGrupo(MainActivity parent)
    {
        this.parent=parent;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Elige tu grupo");
        GrupoDao gd= new GrupoDao(getContext(),"Grupo",null,1);
        ArrayList<Grupo> grupos=gd.verGrupos();
        AdaptadorGrupo ag= new AdaptadorGrupo(getContext(),grupos);

        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(parent, "Tienes que elegir un grupo para empezar a jugar", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setAdapter(ag, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Grupo grupo= ag.getItem(which);
                AlertDialog.Builder builderInner = new AlertDialog.Builder(getActivity());
                builderInner.setMessage(grupo.toString());
                builderInner.setTitle("Sereis el grupo: ");
                builderInner.setPositiveButton("Hasi!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                        g=grupo;
                        dismiss();
                    }
                });
                builderInner.show();
            }
        });

        return builder.create();
    }

    @Override
    public void dismiss()
    {
        Log.i("Meh","meeeehhh");
        parent.abrirMapa(this.g);
        super.dismiss();
    }

    public Grupo getG() {
        return g;
    }
}
