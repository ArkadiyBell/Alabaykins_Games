package com.example.alabaykinsgames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Night extends AppCompatActivity {
    ArrayList<String> names;
    ArrayList<String> rolesI;
    int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night);

        TextView text=(TextView) findViewById(R.id.textView7);

        names=(ArrayList<String>)getIntent().getStringArrayListExtra("Names");
        rolesI=(ArrayList<String>)getIntent().getStringArrayListExtra("Roles");
        ArrayList<Integer>imgs=(ArrayList<Integer>)getIntent().getIntegerArrayListExtra("Imgs");
        size=names.size();

        NightAdapter adapter=new NightAdapter(this, makePerson());
        ListView lv=(ListView) findViewById(R.id.list2);
        lv.setAdapter(adapter);

        boolean mafia=false;
        boolean don=false;
        boolean killer=false;
        boolean komissar=false;
        boolean doctor=false;
        boolean putana=false;
        int count=0;

        for(int i=0; i<size; i++){
            switch (rolesI.get(i)){
                case "Мафия":
                    mafia=true;
                    count++;
                    break;
                case "Дон мафии":
                    don=true;
                    break;
                case "Маньяк":
                    killer=true;
                    count++;
                    break;
                case "Комиссар":
                    komissar=true;
                    break;
                case "Врач":
                    doctor=true;
                    count++;
                    break;
                case "Путана":
                    putana=true;
                    count++;
                    break;
            }
        }

        String arr[]=new String[count];
        int arrON[]=new int[count];
        String[] arrRole=new String[count];
        String[] makeChoice=new String[count];
        String a="Выбор делает ";
        count=0;

        if (mafia) {
            arr[count] = "убит мафией";
            arrON[count]=count;
            arrRole[count]="Мафия";
            makeChoice[count]=a+arrRole[count];
            count++;
            Log.d("mafia", String.valueOf(count));

        }
        if (killer) {
            arr[count] = "убит маньяком";
            arrON[count]=count;
            arrRole[count]="Маньяк";
            makeChoice[count]=a+arrRole[count];
            count++;
            Log.d("killer", String.valueOf(count));
        }
        if (doctor) {
            arr[count] = "вылечен врачом";
            arrON[count]=count;
            arrRole[count]="Врач";
            makeChoice[count]=a+arrRole[count];
            count++;
            Log.d("doctor", String.valueOf(count));

        }
        if (putana) {
            arr[count] = "посетила путана";
            arrON[count]=count;
            arrRole[count]="Путана";
            makeChoice[count]=a+arrRole[count];
            count++;
            Log.d("putana", String.valueOf(count));
        }

        String t="Сначала просыпается";
        String d=" дон мафии";
        String k=" комиссар";

        if ((!komissar)&&(!don)){
            text.setText("Нажми сюда");
        }
        else  if ((komissar)&&(!don)){
            text.setText(t+k);
        }
        else  if ((!komissar)&&(don)){
            text.setText(t+d);
        }
        else{
            text.setText(t+d+" и"+k);
        }

        Intent intentDay = new Intent(Night.this, Day.class);
        int[][] arrActions= new int[makeChoice.length][makeChoice.length];



        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int max=-1;
                for(int i=0;i< size;i++){
                    Log.d("dfsd", String.valueOf(adapter.getItem(i).count));
                    if(adapter.getItem(i).count>max){
                        max=adapter.getItem(i).count;
                        for(int y=0;y<makeChoice.length;i++){
//                            if
                        }
//
//                        arrActions[i]=max;
                    }
                }
                Log.d("max", String.valueOf(max));


                if(max+1<makeChoice.length){
                    text.setText(makeChoice[max+1]);
                }
                else{



                }
            }
        });



    }

    public Person[] makePerson(){
        Person[] arr=new Person[size];
        String[] nameArr= names.toArray(new String[0]);
        String[] roleArr= rolesI.toArray(new String[0]);

        for(int i=0;i< arr.length;i++){
            Person pers=new Person();
            pers.names=nameArr[i];
            pers.role= rolesI.get(i);
            arr[i]=pers;
        }

        return arr;
    }
}