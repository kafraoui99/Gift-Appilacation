package com.example.giftapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<User>{

    public CustomAdapter(Context context, ArrayList<User> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        User user = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        TextView name = convertView.findViewById(R.id.name);
        TextView comment = convertView.findViewById(R.id.itemComment);

        if(user.name != null)
            name.setText(user.name);

        if(user.comment != null)
            comment.setText(user.comment);


        return convertView;
    }


}
