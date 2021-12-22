package com.example.santurtzi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class A2_1 extends AppCompatActivity {

    private Button btn;
    private ImageButton btnSardina1,btnSardina2,btnSardina3;
    private ImageView imgPescador,imgBocadillo,imgSardinas;
    private Boolean visible;
    private TextView txt,txtSardina1,txtSardina2,txtSardina3,txtContadorSardinas;
    private int contador,sardinas;
    private LinearLayout layoutSardinas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g21);
        final MediaPlayer sonidoError = MediaPlayer.create(this, R.raw.error);
        final MediaPlayer sonidoAcierto = MediaPlayer.create(this, R.raw.acierto);

        imgPescador = (ImageView)findViewById(R.id.imgPescador);
        imgBocadillo = (ImageView)findViewById(R.id.imgBocadillo);
        imgSardinas = (ImageView)findViewById(R.id.imgSardinas);
        btn = (Button)findViewById(R.id.btn);
        txt = (TextView)findViewById(R.id.txt);
        txtContadorSardinas = (TextView)findViewById(R.id.txtContadorSardinas);
        btnSardina1 = (ImageButton)findViewById(R.id.btnSardina1);
        btnSardina2 = (ImageButton)findViewById(R.id.btnSardina2);
        btnSardina3 = (ImageButton)findViewById(R.id.btnSardina3);
        txtSardina1 = (TextView)findViewById(R.id.txtSardina1);
        txtSardina2 = (TextView)findViewById(R.id.txtSardina2);
        txtSardina3 = (TextView)findViewById(R.id.txtSardina3);

        layoutSardinas = (LinearLayout)findViewById(R.id.layoutSardinas);

        YoYo.with(Techniques.SlideOutRight).duration(1).playOn(imgPescador);
        YoYo.with(Techniques.SlideOutRight).duration(1).playOn(imgBocadillo);
        visible = false;
        contador = 0;
        sardinas = 0;



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!visible){
                    YoYo.with(Techniques.SlideInRight).duration(700).playOn(imgPescador);
                    YoYo.with(Techniques.SlideInRight).duration(700).playOn(imgBocadillo);
                    visible = true;
                    contador = contador+1;
                }
                else if (contador==1){
                    txt.setText(R.string.act2_1);
                    contador = contador+1;
                }
                else if (contador==2){
                    txt.setText(R.string.act2_2);
                    contador = contador+1;
                }

                else if (contador==3){
                    txt.setText(R.string.act2_3);
                    txtSardina1.setText(R.string.act2_3_1);
                    txtSardina2.setText(R.string.act2_3_2);
                    txtSardina3.setText(R.string.act2_3_3);

                    btnSardina1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            sonidoError.start();
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });
                    btnSardina2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            sonidoError.start();
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });
                    btnSardina3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            contador = contador+1;
                            sardinas = sardinas+1;
                            txtContadorSardinas.setText(sardinas+" X ");
                            sonidoAcierto.start();
                            btn.performClick();
                        }
                    });
                }
                else if (contador==4){
                    txt.setText(R.string.act2_4);

                    txtSardina1.setText(R.string.act2_4_1);
                    txtSardina2.setText(R.string.act2_4_2);
                    txtSardina3.setText(R.string.act2_4_3);

                    btnSardina1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            contador = contador+1;
                            sardinas = sardinas+1;
                            txtContadorSardinas.setText(sardinas+" X ");
                            sonidoAcierto.start();
                            btn.performClick();
                        }
                    });
                    btnSardina2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            sonidoError.start();
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });
                    btnSardina3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            sonidoError.start();
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);

                        }
                    });
                }
                else if (contador==5){
                    txt.setText(R.string.act2_5);

                    txtSardina1.setText(R.string.act2_5_1);
                    txtSardina2.setText(R.string.act2_5_2);
                    txtSardina3.setText(R.string.act2_5_3);

                    btnSardina1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            sonidoError.start();
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });
                    btnSardina2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            contador = contador+1;
                            sardinas = sardinas+1;
                            txtContadorSardinas.setText(sardinas+" X ");
                            sonidoAcierto.start();
                            btn.performClick();
                        }
                    });
                    btnSardina3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            sonidoError.start();
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);

                        }
                    });
                }
                else if (contador==6){
                    txt.setText(R.string.act2_6);

                    txtSardina1.setText(R.string.act2_6_1);
                    txtSardina2.setText(R.string.act2_6_2);
                    txtSardina3.setText(R.string.act2_6_3);

                    btnSardina1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            contador = contador+1;
                            sardinas = sardinas+1;
                            txtContadorSardinas.setText(sardinas+" X ");
                            sonidoAcierto.start();
                            btn.performClick();
                        }
                    });
                    btnSardina2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            sonidoError.start();
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });
                    btnSardina3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            sonidoError.start();
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });
                }
                else if (contador==7){
                    txt.setText(R.string.act2_7);

                    txtSardina1.setText(R.string.act2_7_1);
                    txtSardina2.setText(R.string.act2_7_2);
                    txtSardina3.setText(R.string.act2_7_3);

                    btnSardina1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            sonidoError.start();
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });
                    btnSardina2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            sonidoError.start();
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });
                    btnSardina3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            contador = contador+1;
                            sardinas = sardinas+1;
                            txtContadorSardinas.setText(sardinas+" X ");
                            sonidoAcierto.start();
                            btn.performClick();
                            YoYo.with(Techniques.SlideOutDown).duration(700).playOn(layoutSardinas);
                        }
                    });
                }
                else if (contador==8){
                    txt.setText(R.string.act2_8);
                    contador = contador+1;
                }
                else if (contador==9){
                    YoYo.with(Techniques.SlideOutRight).duration(700).playOn(imgPescador);
                    YoYo.with(Techniques.SlideOutRight).duration(700).playOn(imgBocadillo);
                    YoYo.with(Techniques.SlideOutRight).duration(600).playOn(txt);

                    //win screen (un gif o algo)
                    contador = contador+1;
                }
                else if (contador==10){
                    finish();
                }



            }
        });



    }
}