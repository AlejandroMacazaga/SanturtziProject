package com.example.santurtzi.A1;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class A1_GestorCancion extends Properties
{

    private Context context;
    private Properties properties;
    private A1_Cancion frg;

    public A1_GestorCancion(Context context, A1_Cancion frg)
    {
        this.context = context;
        this.frg=frg;
        //creates a new object ‘Properties’
        properties = new Properties();
        getProperties("cancion1.properties");
    }

    public Properties getProperties(String fich)
    {
        try
        {
            //access to the folder ‘assets’
            AssetManager am = context.getAssets();
            //opening the file
            InputStream inputStream = am.open(fich);
            //loading of the properties
            properties.load(inputStream);
        }
        catch (IOException e)
        {
            Log.e("PropertiesReader",e.toString());
        }
        return properties;
    }

    public String respuesta(String key)
    {
        return this.properties.getProperty(key);
    }

}
