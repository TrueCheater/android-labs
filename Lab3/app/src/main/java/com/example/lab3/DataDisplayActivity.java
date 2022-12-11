package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class DataDisplayActivity extends AppCompatActivity {
    TextView textView;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);

        textView = findViewById(R.id.textViewData);

        dbHelper = new DatabaseHelper(this);

        textView.setText(dbHelper.getData());
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}