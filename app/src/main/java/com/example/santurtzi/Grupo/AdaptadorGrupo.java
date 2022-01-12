package com.example.santurtzi.Grupo;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class AdaptadorGrupo extends ArrayAdapter<Grupo>
{
    public AdaptadorGrupo(@NonNull Context context, int resource, @NonNull Grupo[] objects) {
        super(context, resource, objects);
    }
}
