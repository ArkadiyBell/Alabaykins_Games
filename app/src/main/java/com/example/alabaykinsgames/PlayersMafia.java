package com.example.alabaykinsgames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class PlayersMafia extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_mafia);

        ListView listView = (ListView) findViewById(R.id.playerList);
        EditText editText = (EditText) findViewById(R.id.editText);
        Button buttonNext =(Button) findViewById(R.id.button2);

        ArrayList<String> playerNames = new ArrayList<>();



        CustomListAdapter adapterPlayers;
        adapterPlayers = new CustomListAdapter(this,
                R.layout.custom_adapter, playerNames);
        listView.setAdapter(adapterPlayers);



        editText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if (keyCode == KeyEvent.KEYCODE_ENTER) {
                        playerNames.add(0, editText.getText().toString());
                        adapterPlayers.notifyDataSetChanged();
                        editText.setText("");
                        return true;
                    }
                return false;
            }
        });


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToLobby =new Intent(PlayersMafia.this, MafiaLobby.class);
                intentToLobby.putExtra("Player_Names", playerNames);
                startActivity(intentToLobby);
            }
        });


    }

}