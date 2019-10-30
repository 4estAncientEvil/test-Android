package com.example.android.test_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
private int mode;
private static int count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        ViewPager pager=findViewById(R.id.pager);
        pager.setAdapter(new MyAdapter(getSupportFragmentManager()));
    }

    public void createNewActivity(View view){
        count++;
        Intent intent = new Intent(this, MainActivity.class);
//        Bundle b = new Bundle();
//        b.putInt("LayoutIndex", mode);
//        intent.putExtras(b);
        startActivity(intent);

    }

    public void createNewNotification(View view){

    }

    public static int getCount() {
        return count;
    }
}
