package com.example.alabaykinsgames;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MafiaLobby extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mafia_count_of_players);

        TextView msgView=(TextView) findViewById(R.id.textView2);
        ArrayList<String> playerNames = (ArrayList<String>) getIntent().getStringArrayListExtra("Player_Names");
        int size = playerNames.size();
        msgView.setText(String.valueOf(size)+ " Игроков");


        MafiaLobbyAdapter adapter = new MafiaLobbyAdapter(this, makeRole());
        ListView lv = (ListView) findViewById(R.id.List);
        lv.setAdapter(adapter);



        Button btnNext=(Button) findViewById(R.id.buttonNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x=0;
                for(int i=0; i<7;i++){
                    x+=adapter.getItem(i).count;
                }

                int countOfMafias=adapter.getItem(0).count;
                int countOfDons=adapter.getItem(1).count;
                int countOfKillers=adapter.getItem(2).count;
                int countOfGoodBoys=adapter.getItem(3).count;
                int countOfKomissars=adapter.getItem(4).count;
                int countOfDoctors=adapter.getItem(5).count;
                int countOfPutanas=adapter.getItem(6).count;

                if(size==x&&countOfMafias!=0){
                    Intent intentWIW=new Intent(MafiaLobby.this, WhoIsWho.class);
                    intentWIW.putExtra("PlayerNames1", playerNames);
                    intentWIW.putExtra("countOfMafias",countOfMafias);
                    intentWIW.putExtra("countOfDons",countOfDons);
                    intentWIW.putExtra("countOfKillers",countOfKillers);
                    intentWIW.putExtra("countOfGoodBoys",countOfGoodBoys);
                    intentWIW.putExtra("countOfKomissars",countOfKomissars);
                    intentWIW.putExtra("countOfDoctors",countOfDoctors);
                    intentWIW.putExtra("countOfPutanas",countOfPutanas);
                    startActivity(intentWIW);

                }
                else if(size<x&&countOfMafias!=0){
                    msgView.setText("Персонажей больше, чем игроков: "+ x +"/"+ size);
                }

                else if(size>x&&countOfMafias!=0){
                    msgView.setText("Персонажей меньше, чем игроков: "+ x +"/"+ size);
                }
                else{
                    msgView.setText("Как можно играть в мафию без мафии?!");
                }
            }
        });


    }

    public Role[] makeRole(){
        Role[] arr= new Role[7];
        String[] nameArr={"Мафия", "Дон Мафии", "Маньяк","Мирный", "Комиссар", "Врач", "Путана"};
        int[] imgArr={R.drawable.mafiaimg, R.drawable.donimg, R.drawable.killerimg, R.drawable.goodboy, R.drawable.komissarimg, R.drawable.doctorimg, R.drawable.putanaimg};
        int[] countArr={0,0,0,0,0,0,0};

        for(int i=0; i<arr.length; i++){
            Role role= new Role();
            role.count=countArr[i];
            role.img=imgArr[i];
            role.name=nameArr[i];
            arr[i]=role;
        }
        return arr;
    }


    }



