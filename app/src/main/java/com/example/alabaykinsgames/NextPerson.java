package com.example.alabaykinsgames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class NextPerson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_person);

        TextView text=(TextView) findViewById(R.id.textViewNextPersonName);
        ArrayList<String> names=(ArrayList<String>)getIntent().getStringArrayListExtra("Names");
        ArrayList<String> roles=(ArrayList<String>)getIntent().getStringArrayListExtra("Roles");
        ArrayList<Integer> imgs=(ArrayList<Integer>)getIntent().getIntegerArrayListExtra("Imgs");

        int count=getIntent().getIntExtra("count",0);

        Intent intentWmyP= new Intent(NextPerson.this, WhatMyRole.class);
        Intent intentFirstDay= new Intent(NextPerson.this, FirstDay.class);
        if (count>=roles.size()){
            text.setText("Передайте телефон ведущему");
        }
        else{
            text.setText("Передайте телефон игроку с именем " + names.get(count));
        }



        Button btnWmyP=(Button) findViewById(R.id.buttonWmyP);
        btnWmyP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count>=roles.size()){
                    intentFirstDay.putExtra("Names", names);
                    intentFirstDay.putExtra("Roles", roles);
                    intentFirstDay.putExtra("Imgs", imgs);
                    intentFirstDay.putExtra("count", count);
                    startActivity(intentFirstDay);
                }
                else {
                    intentWmyP.putExtra("Names", names);
                    intentWmyP.putExtra("Roles", roles);
                    intentWmyP.putExtra("Imgs", imgs);
                    intentWmyP.putExtra("count", count);
                    startActivity(intentWmyP);
                }
            }
        });

    }

}