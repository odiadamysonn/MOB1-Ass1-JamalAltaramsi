package com.example.jamal1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_COUNT = "count";

    private int mCount = 0;
    private TextView mShowCount;
    private Button mButtonZero;
    private Button mButtonCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = findViewById(R.id.show_count);
        mButtonZero = findViewById(R.id.button_zero);
        mButtonCount = findViewById(R.id.button_count);

        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt(KEY_COUNT, 0);
        }
        updateUi();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, mCount);
    }

    public void showToast(View view) {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show();
    }

    public void showCount(View view) {
        mCount++;
        updateUi();
    }

    public void showZero(View view) {
        mCount = 0;
        updateUi();
    }

    private void updateUi() {
        mShowCount.setText(String.valueOf(mCount));

        if (mCount % 2 == 0) {
            mButtonCount.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.button_blue));
        } else {
            mButtonCount.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.button_green));
        }

        if (mCount == 0) {
            mButtonZero.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.button_gray));
        } else {
            mButtonZero.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.button_orange));
        }
    }
}