package com.example.lab3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ShowPasswordFragment extends Fragment {
    TextView enteredPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_show_password, container, false);

        enteredPassword = v.findViewById(R.id.textViewEntered);

        return v;
    }

    public void updatePassword(CharSequence password) {
        enteredPassword.setText(password);
    }
}
