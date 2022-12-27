package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    VideoView videoView;
    MediaController mediaController;
    Button buttonPlay;
    Button buttonPause;
    Button buttonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        buttonPlay = findViewById(R.id.button_video_play);
        buttonPause = findViewById(R.id.button_video_pause);
        buttonStop = findViewById(R.id.button_video_stop);

        videoView = findViewById(R.id.video_view);
        String path = "android.resource://com.example.lab4/" + R.raw.cats;
        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);

        mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoView);

        buttonPlay.setOnClickListener(view -> videoView.start());

        buttonPause.setOnClickListener(view -> videoView.pause());

        buttonStop.setOnClickListener(view -> {
            videoView.stopPlayback();
            videoView.resume();
            Toast.makeText(this, "Playback stopped", Toast.LENGTH_SHORT).show();
        });
    }

}