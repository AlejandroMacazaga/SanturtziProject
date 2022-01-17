package com.example.santurtzi.Inicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.santurtzi.Grupo.AdaptadorGrupo;
import com.example.santurtzi.Grupo.DialogoGrupos;
import com.example.santurtzi.Grupo.Grupo;
import com.example.santurtzi.Grupo.GrupoDao;
import com.example.santurtzi.R;

public class Grupos extends AppCompatActivity implements DialogoGrupos.OnDialogoConfirmacionListener {

    private GrupoDao grupoDao;
    private Grupo[] grupos;
    private ListView lstGrupos;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupos);

        grupoDao=new GrupoDao(this.getBaseContext(),"Grupo",null,1);
        grupos=grupoDao.verGrupos();
//        Grupo[] x= new Grupo[]{
//                new Grupo("djksfhsdjfh",2,5),
//                new Grupo("dsgd",23,0)
//        };
        AdaptadorGrupo ag= new AdaptadorGrupo(this, this.grupos);
        lstGrupos=findViewById(R.id.lvGrupos);
        lstGrupos.setAdapter(ag);
    }

    public void crearGrupo(View v)
    {
        FragmentManager fragmentManager= getSupportFragmentManager();
        DialogoGrupos dg= new DialogoGrupos();
        dg.show(fragmentManager, "Dialogo para añadir grupos");

    }

    @Override
    public void onPossitiveButtonClick(Grupo g) {
        grupoDao.aniadirGrupo(g);
        Toast.makeText(this.getBaseContext(),"Grupo "+g.getNomGrupo()+" añadido", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNegativeButtonClick() {
        Toast.makeText(this.getBaseContext(),"No has añadido ningun grupo", Toast.LENGTH_SHORT).show();
    }
}