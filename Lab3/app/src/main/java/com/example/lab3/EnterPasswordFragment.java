package com.example.lab3;

import android.content.Context;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

public class EnterPasswordFragment extends Fragment {
    EnterPasswordFragmentListener listener;
    TextView password;
    RadioGroup radioGroup;
    Button buttonApply;
    DatabaseHelper dbHelper;

    public interface EnterPasswordFragmentListener {
        void onSendPassword(CharSequence password);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_enter_password, container, false);

        password = v.findViewById(R.id.password);
        radioGroup = v.findViewById(R.id.radioGroup);
        buttonApply = v.findViewById(R.id.button);

        dbHelper = new DatabaseHelper(getActivity());

        radioGroup.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            View radioButton = radioGroup.findViewById(checkedId);
            int index = radioGroup.indexOfChild(radioButton);
            if (password.getText().toString().isEmpty()) {
                listener.onSendPassword("");
                Toast.makeText(getContext(), R.string.empty_password, Toast.LENGTH_SHORT).show();
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

        buttonApply.setOnClickListener(view -> {
            if (password.getText().toString().isEmpty()) {
                listener.onSendPassword("");
                Toast.makeText(getContext(), R.string.empty_password, Toast.LENGTH_SHORT).show();
            } else {
                listener.onSendPassword(password.getText());
                dbHelper.addPassword(password.getText().toString());
                Snackbar.make(view, R.string.data_saved, Snackbar.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof EnterPasswordFragmentListener) {
            listener = (EnterPasswordFragmentListener) context;
        } else {
            throw new RuntimeException(context + "must implement EnterPasswordFragmentListener");
        }
    }
}
