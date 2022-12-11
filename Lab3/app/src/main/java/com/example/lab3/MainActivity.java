package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements EnterPasswordFragment.EnterPasswordFragmentListener {
    private ShowPasswordFragment showPasswordFragment;
    Button buttonOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showPasswordFragment = new ShowPasswordFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_show_password, showPasswordFragment)
                .commit();

        buttonOpen = findViewById(R.id.button_open);
        buttonOpen.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DataDisplayActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onSendPassword(CharSequence password) {
        showPasswordFragment.updatePassword(password);
    }
}