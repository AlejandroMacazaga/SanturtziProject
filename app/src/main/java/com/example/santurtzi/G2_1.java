package com.example.santurtzi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class G2_1 extends AppCompatActivity {

    private Button btn;
    private ImageView imageView;
    private Boolean visible;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g21);

        imageView = (ImageView)findViewById(R.id.imgPescador);
        btn = (Button)findViewById(R.id.btn);
        txt = (TextView)findViewById(R.id.txt);

        YoYo.with(Techniques.SlideOutRight).duration(1).playOn(imageView);
        visible = false;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!visible){
                    YoYo.with(Techniques.SlideInRight).duration(700).playOn(imageView);
                    visible = true;
                }
                txt.setText(R.string.act2_2);


            }
        });
    }
}