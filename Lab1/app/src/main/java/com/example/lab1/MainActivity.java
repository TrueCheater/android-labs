package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    TextView textView;
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.textViewEntered);
        password = findViewById(R.id.password);

        radioGroup.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            View radioButton = radioGroup.findViewById(checkedId);
            int index = radioGroup.indexOfChild(radioButton);
            if (password.getText().toString().isEmpty()) {
                textView.setText("");
                Toast.makeText(this, "Empty password", Toast.LENGTH_SHORT).show();
            } else {
                switch (index) {
                    case 0:
                        password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        break;
                    case 1:
                        password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        break;
                }
            }
        });

        Button buttonApply = findViewById(R.id.button);
        buttonApply.setOnClickListener(view -> {
            password = findViewById(R.id.password);
            if (password.getText().toString().isEmpty()) {
                textView.setText("");
                Toast.makeText(this, "Empty password", Toast.LENGTH_SHORT).show();
            } else {
                textView.setText("Entered password: " + password.getText());
            }
        });
    }
}