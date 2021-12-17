package com.example.santurtzi;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.inspector.PropertyReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class A1_GestorCancion extends Properties
{

    private Context context;
    private Properties properties;

    public A1_GestorCancion(Context context)
    {
        this.context = context;
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
