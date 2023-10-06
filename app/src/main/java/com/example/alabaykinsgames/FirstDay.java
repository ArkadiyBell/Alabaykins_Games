package com.example.alabaykinsgames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class FirstDay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_day);

        ArrayList<String> names=(ArrayList<String>)getIntent().getStringArrayListExtra("Names");
        ArrayList<String> roles=(ArrayList<String>)getIntent().getStringArrayListExtra("Roles");
        ArrayList<Integer> imgs=(ArrayList<Integer>)getIntent().getIntegerArrayListExtra("Imgs");


        Intent intentFirstNight = new Intent(FirstDay.this, Night.class);
        Button btnFirstNight=(Button) findViewById(R.id.buttonFirstNight);
        btnFirstNight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentFirstNight.putExtra("Names", names);
                intentFirstNight.putExtra("Roles", roles);
                intentFirstNight.putExtra("Imgs", imgs);
                startActivity(intentFirstNight);

            }
        });
    }
}