package com.example.santurtzi.A6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.santurtzi.R;

import java.util.ArrayList;

public class A6Juego extends AppCompatActivity
{

    private GridLayout gdBotones;
    private ImageButton[][] botones;
    private ArrayList<A6Punto[]> posiciones;
    private int[] imgs;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a6_juego);

        cargarPosiciones();

        ImageButton[] fuertes=new ImageButton[25];
        gdBotones=findViewById(R.id.gdBotones);
        int j=0;
        for (int i=0;i<gdBotones.getChildCount();i++)
        {
            try
            {
                ImageButton v= (ImageButton) gdBotones.getChildAt(i);
                fuertes[j]=v;
                j++;
            }
            catch (ClassCastException e)
            {

            }
        }
        cargarBotones(fuertes);
        cargarImagenes();
        configurarFuerte();

    }

    private void cargarImagenes()
    {
        imgs= new int[4];
        imgs[0]=R.mipmap.p1_foreground;
        imgs[1]=R.mipmap.p2_foreground;
        imgs[2]=R.mipmap.p3_foreground;
        imgs[3]=R.mipmap.p4_foreground;
    }

    private void cargarBotones(ImageButton[] fuertes)
    {
        botones=new ImageButton[5][5];
        int i=0;
        int j=0;
        for (int k=0;k<fuertes.length;k++)
        {
            botones[i][j]=fuertes[k];
            j++;
            if(j>=5)
            {
                j=0;
                i++;
            }
        }
    }

    private void cargarPosiciones()
    {
        posiciones=new ArrayList<A6Punto[]>();

        A6Punto[] p1= new A6Punto[]{new A6Punto(0,0),new A6Punto(0,1), new A6Punto(1,0),new A6Punto(1,1)};
        A6Punto[] p2= new A6Punto[]{new A6Punto(1,3),new A6Punto(1,4), new A6Punto(2,3),new A6Punto(2,4)};
        A6Punto[] p3= new A6Punto[]{new A6Punto(3,1),new A6Punto(3,2), new A6Punto(4,1),new A6Punto(4,2)};

        posiciones.add(p1);
        posiciones.add(p2);
        posiciones.add(p3);

    }

    private void configurarFuerte()
    {
        int x= (int) (0+Math.random()*(posiciones.size()));
        A6Punto[] posicion=posiciones.get(x);
        for (int i=0;i<posicion.length;i++)
        {
            ImageButton bt=botones[posicion[i].getR()][posicion[i].getC()];
            int a=i;
            bt.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {

                    bt.setImageResource(imgs[a]);
                    bt.getLayoutParams().width=200;
                    bt.getLayoutParams().height=200;
                    bt.setBackgroundColor(getResources().getColor(R.color.b));
                    ((ViewGroup.MarginLayoutParams) bt.getLayoutParams()).leftMargin=0;
                    ((ViewGroup.MarginLayoutParams) bt.getLayoutParams()).rightMargin=0;
                    ((ViewGroup.MarginLayoutParams) bt.getLayoutParams()).topMargin=0;
                    ((ViewGroup.MarginLayoutParams) bt.getLayoutParams()).bottomMargin=0;
                    switch (a)
                    {
                        case 0:
                            ((ViewGroup.MarginLayoutParams) bt.getLayoutParams()).bottomMargin=-50;
                            ((ViewGroup.MarginLayoutParams) bt.getLayoutParams()).rightMargin=-25;
                            break;
                        case 1:
                            ((ViewGroup.MarginLayoutParams) bt.getLayoutParams()).bottomMargin=-50;
                            ((ViewGroup.MarginLayoutParams) bt.getLayoutParams()).leftMargin=-25;
                            break;
                        case 2:
                            ((ViewGroup.MarginLayoutParams) bt.getLayoutParams()).topMargin=-50;
                            ((ViewGroup.MarginLayoutParams) bt.getLayoutParams()).rightMargin=-25;
                            break;
                        case 3:
                            ((ViewGroup.MarginLayoutParams) bt.getLayoutParams()).topMargin=-50;
                            ((ViewGroup.MarginLayoutParams) bt.getLayoutParams()).leftMargin=-25;
                            break;
                    }

                }
            });
        }
    }
}