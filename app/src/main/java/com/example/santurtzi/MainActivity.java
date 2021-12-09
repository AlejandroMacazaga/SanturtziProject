package com.example.santurtzi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        VideoView videoview = (VideoView) findViewById(R.id.videoFondo);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.fondo);
        videoview.setVideoURI(uri);
        videoview.start();
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {//no se como pero esto hace q el video sea un bucle
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }

    public void irMapa(View v)
    {
        Intent intent = new Intent(MainActivity.this,FakeMapa.class);
        startActivity(intent);
    }

}