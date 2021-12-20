package com.example.santurtzi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity{

    private VideoView videoview;
    private Uri uri;
    private int stopPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        videoview = (VideoView) findViewById(R.id.videoFondo);
        uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.fondo);
        videoview.setVideoURI(uri);
        videoview.start();

        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });



    }

    public void irMapa(View v)
    {
        Intent intent = new Intent(MainActivity.this, Mapa.class);
        startActivity(intent);
    }
    @Override
    public void onPause() {
        super.onPause();
        stopPosition = videoview.getCurrentPosition(); //stopPosition is an int
        videoview.pause();
    }
    @Override
    public void onResume() {
        super.onResume();
        videoview.seekTo(stopPosition);
        videoview.start(); //Or use resume() if it doesn't work. I'm not sure
    }



}