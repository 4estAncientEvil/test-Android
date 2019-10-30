package com.example.android.test_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DynamicActivity extends AppCompatActivity {
    private int mode;

    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);/*

        Bundle b = getIntent().getExtras();
        int layoutIndex = b.getInt("LayoutIndex");*/
        // and here populate the activity differently based on layoutIndex value
    }

    public void createNewActivity(View view){
        Intent intent = new Intent(this, DynamicActivity.class);
        /*Bundle b = new Bundle();
        b.putInt("LayoutIndex", mode);
        intent.putExtras(b);*/
        startActivity(intent);
    }
}
