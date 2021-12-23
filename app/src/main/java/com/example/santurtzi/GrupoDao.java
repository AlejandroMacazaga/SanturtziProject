package com.example.santurtzi;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class GrupoDao
{

    private SQLiteDatabase db;

    public GrupoDao(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version)
    {
        db= new GruposSQLiteHelper(contexto, nombre,factory,version).getWritableDatabase();
    }

    public ArrayList<Grupo> verGrupos()
    {

        ArrayList<Grupo> grupos= new ArrayList<Grupo>();

        Cursor c=db.rawQuery("select nomGrupo, puntos, integrantes from grupo", null);
        if(c.moveToFirst())
        {
            do
            {
                String nomGrupo=c.getString(0);
                int integrantes=c.getInt(1);
                int puntos=c.getInt(2);
                Grupo grupo=new Grupo(nomGrupo,integrantes,puntos);
                grupos.add(grupo);
            }while(c.moveToNext());
        }

        return grupos;

    }

    public Grupo verGrupo(Grupo g)
    {
        Grupo grupo= null;
        Cursor c=db.rawQuery("select nomGrupo, puntos, integrantges from grupo where nomGrupo="+g.getNomGrupo(),null);
        c.moveToFirst();
        String nomGrupo=c.getString(0);
        int integrantes=c.getInt(1);
        int puntos=c.getInt(2);//////////////////////////////////////////////////////////////////
        return grupo;
    }

    public void aniadirGrupo(Grupo grupo)
    {
        db.execSQL("insert into Grupo (nomGrupo,integrantes,puntos) values("+grupo.getNomGrupo()+", "+grupo.getIntegrantes()+", "+grupo.getPuntos()+")");
    }

    public void eliminarGrupo(Grupo grupo)
    {
        db.execSQL("delete grupo where nomGrupo="+grupo.getNomGrupo());
    }

    public void cambiarNombre(Grupo grupo)
    {
        db.execSQL("update grupo set nomGrupo="+grupo.getNomGrupo()+")");
    }

}
