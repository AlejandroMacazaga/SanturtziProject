package com.example.santurtzi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class G2_1 extends AppCompatActivity {

    private Button btn;
    private ImageView imageView,imgSardina1,imgSardina2,imgSardina3;
    private Boolean visible;
    private TextView txt,txtSardina1,txtSardina2,txtSardina3;
    private int contador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g21);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.error);

        imageView = (ImageView)findViewById(R.id.imgPescador);
        btn = (Button)findViewById(R.id.btn);
        txt = (TextView)findViewById(R.id.txt);
        txtSardina1 = (TextView)findViewById(R.id.txtSardina1);
        txtSardina2 = (TextView)findViewById(R.id.txtSardina2);
        txtSardina3 = (TextView)findViewById(R.id.txtSardina3);
        imgSardina1 = (ImageView)findViewById(R.id.imgSardina1);
        imgSardina2 = (ImageView)findViewById(R.id.imgSardina2);
        imgSardina3 = (ImageView)findViewById(R.id.imgSardina3);

        YoYo.with(Techniques.SlideOutRight).duration(1).playOn(imageView);
        visible = false;
        contador = 0;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador = contador+1;
                if(!visible){
                    YoYo.with(Techniques.SlideInRight).duration(700).playOn(imageView);
                    visible = true;
                }
                if (contador==1){
                    txt.setText(R.string.act2_2);
                }
                if (contador==2){
                    txt.setText(R.string.act2_3);
                }
                if (contador==3){
                    txtSardina1.setText(R.string.act2_3_1);
                    txtSardina2.setText(R.string.act2_3_2);
                    txtSardina3.setText(R.string.act2_3_3);

                    imgSardina1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });
                    imgSardina2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });
                    txtSardina3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            mp.start();
                        }
                    });
                }





            }
        });


    }
}