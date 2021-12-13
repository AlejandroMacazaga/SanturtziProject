package com.example.santurtzi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class G2_1 extends AppCompatActivity {

    private Button btn;
    private ImageView imageView;
    private Boolean visible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g21);

        imageView = (ImageView)findViewById(R.id.imageView);
        btn = (Button)findViewById(R.id.btn);

        YoYo.with(Techniques.SlideOutRight).duration(1).playOn(imageView);
        visible = false;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(visible){
                    YoYo.with(Techniques.SlideOutRight).duration(700).playOn(imageView);
                    visible = false;
                }else{
                    YoYo.with(Techniques.SlideInRight).duration(700).playOn(imageView);
                    visible = true;
                }


            }
        });
    }
}