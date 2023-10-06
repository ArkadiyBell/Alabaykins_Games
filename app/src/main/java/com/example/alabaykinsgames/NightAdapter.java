package com.example.alabaykinsgames;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NightAdapter extends ArrayAdapter<Person> {

    public NightAdapter(@NonNull Context context,Person[] arr) {
        super(context, R.layout.person, arr);
    }
    int i=0;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Person person=getItem(position);
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.person,null);
        }
        ((TextView)convertView.findViewById(R.id.textView6)).setText(person.names);
        ((TextView)convertView.findViewById(R.id.textView8)).setText(person.role);

        TextView name=(TextView) convertView.findViewById(R.id.textView6);
        View finalConvertView = convertView;
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person.count= i;
                i++;
            }
        });




        return convertView;
    }
}
