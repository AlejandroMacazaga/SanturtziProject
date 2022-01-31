package com.example.santurtzi.Grupo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.santurtzi.R;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorGrupo extends ArrayAdapter<Grupo>
{
    private ArrayList<Grupo> grupos;
    private int h;

    public AdaptadorGrupo(@NonNull Context context, @NonNull ArrayList<Grupo> objects) {
        super(context, R.layout.listitem_grupo, objects);
        this.grupos=objects;
        h=1;
    }

//    public AdaptadorGrupo(@NonNull Context context, @NonNull Grupo[] objects) {
//        super(context, R.layout.listitem_grupo, objects);
//        this.grupos=objects;
//    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_grupo, null);

        TextView lblInteger=item.findViewById(R.id.lblIntegr);
        lblInteger.setText(String.valueOf(grupos.get(position).getIntegrantes()));

        TextView lblNom=item.findViewById(R.id.lblNom);
        lblNom.setText(grupos.get(position).getNomGrupo());

        TextView lblPuntos= item.findViewById(R.id.lblPuntos);
        lblPuntos.setText("Puntos: "+grupos.get(position).getPuntos());

        return (item);
    }

    public void refrescarLista(ArrayList<Grupo> grupos)
    {
        this.grupos.clear();
        this.grupos.addAll(grupos);
        this.notifyDataSetChanged();
    }

    public void editar()
    {
        this.h=2;
    }

    public void borrar()
    {
        this.h=3;
    }

    public void ver()
    {
        this.h=1;
    }

    public int getH()
    {
        return h;
    }

}
