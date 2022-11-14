package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements EnterPasswordFragment.EnterPasswordFragmentListener {
    private ShowPasswordFragment showPasswordFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showPasswordFragment = new ShowPasswordFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_show_password, showPasswordFragment)
                .commit();
    }

    @Override
    public void onSendPassword(CharSequence password) {
        showPasswordFragment.updatePassword(password);
    }
}