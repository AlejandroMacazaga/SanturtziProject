package com.example.santurtzi.A5;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.santurtzi.R;

public class A5_Sotera extends AppCompatActivity {

    private int numPregunta;
    private Fragment currentFragment;

    private final static A5_Pregunta[] PREGUNTAS = {
        new A5_Pregunta("Esta es la pregunta 1", 2, new String[]{"Respuesta 1", "Respuesta 2", "Respuesta 3", "Respuesta 4"}),
            new A5_Pregunta("Esta es la pregunta 2", 1, new String[]{"Respuesta 1", "Respuesta 2", "Respuesta 3", "Respuesta 4"}),
            new A5_Pregunta("Esta es la pregunta 3", 3, new String[]{"Respuesta 1", "Respuesta 2", "Respuesta 3", "Respuesta 4"}),
            new A5_Pregunta("Esta es la pregunta 4", 2, new String[]{"Respuesta 1", "Respuesta 2", "Respuesta 3", "Respuesta 4"}),
            new A5_Pregunta("Esta es la pregunta 5", 4, new String[]{"Respuesta 1", "Respuesta 2", "Respuesta 3", "Respuesta 4"}),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a5_sotera);
        numPregunta = 0;
        currentFragment = new A5_FragmentFirstScreen();
        loadFragment(currentFragment);
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerView, fragment, null);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public static A5_FragmentPregunta newInstance(A5_Pregunta p) {
        A5_FragmentPregunta f = new A5_FragmentPregunta();
        Bundle args = new Bundle();
        args.putString("pregunta", p.getPregunta());
        args.putStringArray("opciones", p.getOpciones());
        args.putInt("respuesta", p.getRespuesta_correcta());
        f.setArguments(args);
        return f;
    }

    public void loadNextQuestion() {
        A5_FragmentPregunta f = newInstance(PREGUNTAS[numPregunta]);
        numPregunta++;
        Log.e("This is the " + numPregunta,"This is the " + numPregunta );
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerView, f, null);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}