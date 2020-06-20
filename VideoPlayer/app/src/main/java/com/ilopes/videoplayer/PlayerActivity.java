package com.ilopes.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        videoView = findViewById(R.id.videoView);
        //fullscrenn
        View decorView = getWindow().getDecorView();
        int uiOp =  View.SYSTEM_UI_FLAG_FULLSCREEN;

        decorView.setSystemUiVisibility(uiOp);
        //esconder a action bar
        getSupportActionBar().hide();
        //executar video
        videoView.setMediaController( new MediaController(this));
        videoView.setVideoPath("android.resource://"+ getPackageName()+"/"+R.raw.video);
        videoView.start();
    }
}
