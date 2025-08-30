package com.app_mobile.lifecyclefragmentdemo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InputFragment extends Fragment {
    EditText editText;
    Button btnSend;


    public interface OnInputListener {
        void sendInput(String input);
    }


    OnInputListener inputListener;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            inputListener = (OnInputListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnInputListener");
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        editText = view.findViewById(R.id.editText);
        btnSend = view.findViewById(R.id.btnSend);


        btnSend.setOnClickListener(v -> {
            String text = editText.getText().toString();
            inputListener.sendInput(text);
        });


        return view;
    }
}

