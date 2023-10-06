package com.example.alabaykinsgames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WhatMyRole extends AppCompatActivity {
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> roles = new ArrayList<>();
    ArrayList<Integer> imgs = new ArrayList<>();
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_my_role);

        ImageView myRoleImage=(ImageView) findViewById(R.id.imageViewMyRole);
        TextView roleName=(TextView) findViewById(R.id.textView4);
        names=(ArrayList<String>)getIntent().getStringArrayListExtra("Names");
        roles=(ArrayList<String>)getIntent().getStringArrayListExtra("Roles");
        imgs=(ArrayList<Integer>)getIntent().getIntegerArrayListExtra("Imgs");
        count=getIntent().getIntExtra("count",0);
        myRoleImage.setImageResource(imgs.get(count));
        roleName.setText(roles.get(count));


    }

    public void onClkNP(View view) {
        count++;
        Intent intentNP1=new Intent(WhatMyRole.this,NextPerson.class);
        intentNP1.putExtra("Names", names);
        intentNP1.putExtra("Roles", roles);
        intentNP1.putExtra("Imgs", imgs);
        intentNP1.putExtra("count", count);
        startActivity(intentNP1);
    }
}