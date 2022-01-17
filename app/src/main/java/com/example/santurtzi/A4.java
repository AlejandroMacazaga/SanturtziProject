package com.example.santurtzi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class A4 extends AppCompatActivity {

    private Button btnHasi;
    private TextView txt1;
    //private EditText


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a4);

        btnHasi = (Button) findViewById(R.id.btnHasi);
        txt1 = (TextView) findViewById(R.id.txt1);

        btnHasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YoYo.with(Techniques.SlideOutDown).duration(700).playOn(btnHasi);
                YoYo.with(Techniques.SlideOutUp).duration(700).playOn(txt1);

            }
        });
    }
}