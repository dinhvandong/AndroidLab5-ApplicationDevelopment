package com.app_mobile.lifecyclefragmentdemo;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements InputFragment.OnInputListener {
    DisplayFragment displayFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycle", "onCreate called");
        // Load InputFragment by default
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new InputFragment())
                .commit();

    }

    @Override
    public void sendInput(String input) {
        displayFragment = new DisplayFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, displayFragment)
                .addToBackStack(null)
                .commit();


        // Delay to ensure the fragment view is ready
        new Handler().postDelayed(() -> {
            displayFragment.updateText("Data from Fragment: " + input);
        }, 100);



    }
}