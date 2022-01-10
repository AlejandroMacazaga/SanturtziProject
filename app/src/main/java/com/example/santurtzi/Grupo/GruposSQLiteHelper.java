package com.example.santurtzi.Grupo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GruposSQLiteHelper extends SQLiteOpenHelper
{
    private String sqlCreate="create table grupo( nomGrupo varchar2 Primary Key, integrantes integer, puntos integer )";

    public GruposSQLiteHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(this.sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("drop table if exists grupo");
        db.execSQL(this.sqlCreate);
    }
}
