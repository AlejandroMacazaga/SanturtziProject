package com.example.santurtzi.A5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.santurtzi.R;

public class A5_Sotera extends AppCompatActivity {

    private Fragment currentFragment;

    private final static A5_Pregunta[] PREGUNTAS = {

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a5_sotera);
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

        return f;
    }
}