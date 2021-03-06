package com.example.osolapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import androidx.recyclerview.widget.GridLayoutManager;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<String> personNames;
    ArrayList<Integer> personImages;

    Context context;

    public CustomAdapter(ArrayList<String> personNames, ArrayList<Integer> personImages) {
        this.personNames = personNames;
        this.personImages = personImages;
    }


    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        LayoutInflater inflater = LayoutInflater.from(context);
        //View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        View v=inflater.inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,SecondActivity.class);
                context.startActivity(intent);
            }
        });

        return vh;
    }


    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        holder.name.setText(personNames.get(position));
        holder.image.setImageResource(personImages.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open another activity on item click
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("image", personImages.get(position)); // put image data in Intent
                context.startActivity(intent); // start Intent
            }
        });

    }


    public int getItemCount() {

        return personNames.size();
    }




    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        private CardView item;

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);
            item = (CardView) itemView.findViewById(R.id.cardview_id);

        }
    }
}
