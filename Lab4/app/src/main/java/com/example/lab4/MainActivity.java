package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Intent intentAudio;
    private Intent intentVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAudio = findViewById(R.id.button_audio);
        buttonAudio.setOnClickListener(view -> {
            if (intentAudio == null)
                intentAudio = new Intent(this, AudioActivity.class);
            startActivity(intentAudio);
        });

        Button buttonVideo = findViewById(R.id.button_video);
        buttonVideo.setOnClickListener(view -> {
            if (intentVideo == null)
                intentVideo = new Intent(this, VideoActivity.class);
            startActivity(intentVideo);
        });
    }
}