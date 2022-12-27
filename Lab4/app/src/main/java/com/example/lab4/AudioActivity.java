package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class AudioActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    Button buttonPlay;
    Button buttonPause;
    Button buttonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        buttonPlay = findViewById(R.id.button_audio_play);
        buttonPlay.setOnClickListener(view -> {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, R.raw.song);
                mediaPlayer.setOnCompletionListener(mp -> stopPlayer());
            }
            mediaPlayer.start();
        });

        buttonPause = findViewById(R.id.button_audio_pause);
        buttonPause.setOnClickListener(view -> {
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
        });

        buttonStop = findViewById(R.id.button_audio_stop);
        buttonStop.setOnClickListener(view -> stopPlayer());
    }

    private void stopPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            Toast.makeText(this, "Playback stopped", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}