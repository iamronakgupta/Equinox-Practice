package com.example.tabular;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    ArrayList<ExampleItem> alist;
    public static class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView occasion;
        TextView date;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            occasion=itemView.findViewById(R.id.occasion);
            date=itemView.findViewById(R.id.date);
        }
    }
    public CustomAdapter(ArrayList<ExampleItem> mlist){
        alist=mlist;
    }
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.holiday_list,parent,false);
        CustomViewHolder viewHolder=new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        ExampleItem exampleItem=alist.get(position);
        holder.occasion.setText(exampleItem.getOcassion());
        holder.date.setText(exampleItem.getDate());

    }

    @Override
    public int getItemCount() {
        return alist.size();
    }
}
