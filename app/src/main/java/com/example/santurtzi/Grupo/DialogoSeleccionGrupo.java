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

import java.util.ArrayList;

public class DialogoSeleccionGrupo extends DialogFragment
{

    private Grupo g;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        GrupoDao gd= new GrupoDao(getContext(),"Grupo",null,1);
        ArrayList<Grupo> grupos=gd.verGrupos();
        AdaptadorGrupo ag= new AdaptadorGrupo(getContext(),grupos);

        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setAdapter(ag, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Grupo grupo= ag.getItem(which);
                AlertDialog.Builder builderInner = new AlertDialog.Builder(getActivity());
                builderInner.setMessage(g.getNomGrupo());
                builderInner.setTitle("Sereis el grupo: ");
                builderInner.setPositiveButton("Hasi!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                        g=grupo;
                        dialog.dismiss();
                    }
                });
                builderInner.show();
            }
        });

        return builder.create();
    }

    public Grupo getG() {
        return g;
    }
}
