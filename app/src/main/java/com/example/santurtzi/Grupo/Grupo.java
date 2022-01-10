package com.example.santurtzi.Grupo;

public class Grupo
{

    private String nomGrupo;
    private int integrantes;
    private int puntos;

    public Grupo(String nomGrupo, int integrantes, int puntos)
    {
        this.nomGrupo=nomGrupo;
        this.integrantes=integrantes;
        this.puntos=puntos;
    }

    public String getNomGrupo()
    {
        return nomGrupo;
    }

    public void setNomGrupo(String nomGrupo)
    {
        this.nomGrupo = nomGrupo;
    }

    public int getIntegrantes()
    {
        return integrantes;
    }

    public void setIntegrantes(int integrantes)
    {
        this.integrantes = integrantes;
    }

    public int getPuntos()
    {
        return puntos;
    }

    public void setPuntos(int puntos)
    {
        this.puntos = puntos;
    }

}
