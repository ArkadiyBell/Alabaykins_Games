package com.example.alabaykinsgames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClkSpy(View view) {

    }

    public void onClkMafia(View view) {
        Intent intent=new Intent(MainActivity.this, PlayersMafia.class);
        startActivity(intent);
    }

    public void onClk500(View view) {
    }
}