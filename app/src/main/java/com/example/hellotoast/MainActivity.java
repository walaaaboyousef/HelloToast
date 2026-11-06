
package com.example.hellotoast;

import android.os.Bundle;
import android.view.View;
import android.graphics.Color;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hellotoast.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int count = 0;

    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top,
                    systemBars.right, systemBars.bottom);
            return insets;
        });

        mainBinding.buttonZero.setBackgroundColor(Color.GRAY);
    }

    public void show_toast(View view) {
        Toast.makeText(this, "Hello Toast", Toast.LENGTH_SHORT).show();
    }

    public void increase_count(View view) {
        count++;

        mainBinding.textDisplayCount.setText(String.valueOf(count));

        if (count % 2 == 1) {
            mainBinding.buttonCount.setBackgroundColor(Color.GREEN);
        } else {
            mainBinding.buttonCount.setBackgroundColor(Color.BLUE);
        }

        mainBinding.buttonZero.setBackgroundColor(Color.rgb(255, 165, 0));
    }

    public void show_zero(View view) {
        count = 0;

        mainBinding.textDisplayCount.setText(String.valueOf(count));

        mainBinding.buttonZero.setBackgroundColor(Color.GRAY);
    }
}
