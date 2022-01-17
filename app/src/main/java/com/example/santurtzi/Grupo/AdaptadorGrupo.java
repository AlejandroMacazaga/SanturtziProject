package com.example.santurtzi.Grupo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.santurtzi.R;

public class AdaptadorGrupo extends ArrayAdapter<Grupo>
{
    private Grupo[] grupos;

    public AdaptadorGrupo(@NonNull Context context, @NonNull Grupo[] objects) {
        super(context, R.layout.listitem_grupo, objects);
        this.grupos=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_grupo, null);

        TextView lblInteger=item.findViewById(R.id.lblIntegr);
        lblInteger.setText(String.valueOf(grupos[position].getIntegrantes()));

        TextView lblNom=item.findViewById(R.id.lblNom);
        lblNom.setText(grupos[position].getNomGrupo());

        TextView lblPuntos= item.findViewById(R.id.lblPuntos);
        lblPuntos.setText(R.string.puntos+grupos[position].getPuntos());

        return (item);
        ///////////////////////////////////////////////////////////////////////////////////////////////////
    }

}
