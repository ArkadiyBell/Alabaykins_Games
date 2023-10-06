package com.example.alabaykinsgames;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class MafiaLobbyAdapter extends ArrayAdapter<Role> {


    public MafiaLobbyAdapter(Context context, Role[] arr) {
        super(context, R.layout.role, arr);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final Role role = getItem(position);
        if (convertView== null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.role, null);
        }
        ((ImageView) convertView.findViewById(R.id.imageView)).setImageResource(role.img);
        ((TextView) convertView.findViewById(R.id.textView3)).setText(role.name);
        ((TextView) convertView.findViewById(R.id.count)).setText(String.valueOf(role.count));




        Button buttonMinus =(Button) convertView.findViewById(R.id.buttonMinus);
        View finalConvertView = convertView;
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (role.count>0 ) {
                    role.count--;
                    ((TextView) finalConvertView.findViewById(R.id.count)).setText(String.valueOf(role.count));
                }

            }
        });
        Button buttonPlus =(Button) convertView.findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(role.count<=10 && Objects.equals(role.name, "Мирный") || role.count<=10 && Objects.equals(role.name, "Мафия")) {
                    role.count++;
                    ((TextView) finalConvertView.findViewById(R.id.count)).setText(String.valueOf(role.count));
                }

                else if(Objects.equals(role.name, "Дон Мафии")&& role.count<1 || Objects.equals(role.name, "Комиссар")&& role.count<1 ||Objects.equals(role.name, "Врач")&& role.count<1 ||Objects.equals(role.name, "Путана")&& role.count<1||Objects.equals(role.name, "Маньяк")&& role.count<1 ){
                    role.count++;
                    ((TextView) finalConvertView.findViewById(R.id.count)).setText(String.valueOf(role.count));
                }

            }
        });
        return convertView;
    }
}
