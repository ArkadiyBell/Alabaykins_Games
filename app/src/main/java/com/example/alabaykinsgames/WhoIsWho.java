package com.example.alabaykinsgames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WhoIsWho extends AppCompatActivity {
    ArrayList<String> playerNames = new ArrayList<>();
    Random rand = new Random();
    String[] allRoles;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who_is_who);


        playerNames = (ArrayList<String>) getIntent().getStringArrayListExtra("PlayerNames1");
        int countOfMafias=(Integer)getIntent().getIntExtra("countOfMafias", 0);
        int countOfDons=(Integer)getIntent().getIntExtra("countOfDons", 0);
        int countOfKillers=(Integer)getIntent().getIntExtra("countOfKillers", 0);
        int countOfGoodBoys=(Integer)getIntent().getIntExtra("countOfGoodBoys", 0);
        int countOfKomissars=(Integer)getIntent().getIntExtra("countOfKomissars", 0);
        int countOfDoctors=(Integer)getIntent().getIntExtra("countOfDoctors", 0);
        int countOfPutanas=(Integer)getIntent().getIntExtra("countOfPutanas", 0);





        allRoles = new String[playerNames.size()];
        int c=0;
        while(countOfMafias>0){
            allRoles[c]="Мафия";
            countOfMafias--;
            c++;
        }
        while(countOfDons>0){
            allRoles[c]="Дон мафии";
            countOfDons--;
            c++;
        }
        while(countOfKillers>0){
            allRoles[c]="Маньяк";
            countOfKillers--;
            c++;
        }
        while(countOfGoodBoys>0){
            allRoles[c]="Мирный";
            countOfGoodBoys--;
            c++;
        }
        while(countOfKomissars>0){
            allRoles[c]="Комиссар";
            countOfKomissars--;
            c++;
        }
        while(countOfDoctors>0){
            allRoles[c]="Врач";
            countOfDoctors--;
            c++;
        }
        while(countOfPutanas>0){
            allRoles[c]="Путана";
            countOfPutanas--;
            c++;
        }
        for (int i=0;i<c;i++){
        }


        Person[] newPerson=new Person[c];
        newPerson=makePerson();

        ArrayList<String> names= new ArrayList<>();
        ArrayList<String> roles= new ArrayList<>();
        ArrayList<Integer> imgs= new ArrayList<>();
        for(int i=0; i< newPerson.length; i++){
            names.add(newPerson[i].names);
            roles.add(newPerson[i].roles.name);
            imgs.add(newPerson[i].roles.img);
        }


        Intent intentNP= new Intent(WhoIsWho.this, NextPerson.class);
        intentNP.putExtra("Names", names);
        intentNP.putExtra("Roles", roles);
        intentNP.putExtra("Imgs", imgs);
        intentNP.putExtra("count", 0);
        startActivity(intentNP);






    }
    Person[] makePerson(){
        Person[] arr=new Person[playerNames.size()];
        Role[] arr1= new Role[playerNames.size()];

        for(int v=0; v<arr.length; v++){
            Role role= new Role();
            switch (allRoles[v]){
                case "Мафия":
                    role.img=R.drawable.mafiaimg;
                    role.name=allRoles[v];
                    break;
                case "Дон мафии":
                    role.img=R.drawable.donimg;
                    role.name=allRoles[v];
                    break;
                case "Маньяк":
                    role.img=R.drawable.killerimg;
                    role.name=allRoles[v];
                    break;
                case "Мирный":
                    role.img=R.drawable.goodboy;
                    role.name=allRoles[v];
                    break;
                case "Комиссар":
                    role.img=R.drawable.komissarimg;
                    role.name=allRoles[v];
                    break;
                case "Врач":
                    role.img=R.drawable.doctorimg;
                    role.name=allRoles[v];
                    break;
                case "Путана":
                    role.img=R.drawable.putanaimg;
                    role.name=allRoles[v];
                    break;

            }
            arr1[v]=role;
        }
        for(int i=0; i<arr.length; i++){
            Person pers=new Person();
            int x=rand.nextInt(arr.length-i);
            pers.names=playerNames.get(i);
            pers.roles=arr1[x];
            for(int m=x; m<arr.length-1; m++){
                arr1[m]=arr1[m+1];
            }
            arr[i]=pers;
        }
        return arr;
    }

}