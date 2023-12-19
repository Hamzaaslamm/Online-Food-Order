package com.uzair.foodapp;


import com.squareup.picasso.Picasso;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Data extends RecyclerView.Adapter<Adapter_Data.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<DataModel> dataModelArrayList;


    public  Adapter_Data(Context ctx, ArrayList<DataModel> dataModelArrayList){

        inflater = LayoutInflater.from(ctx);
        this.dataModelArrayList = dataModelArrayList;
    }

    @Override
    public Adapter_Data.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.sample_mainfood, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(Adapter_Data.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Picasso.get().load(dataModelArrayList.get(position).getImgURL()).into(holder.imageView);
        holder.name.setText(dataModelArrayList.get(position).getName());
        holder.price.setText(dataModelArrayList.get(position).getPrice());
        holder.description.setText(dataModelArrayList.get(position).getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(view.getContext(),DetailActivity.class);

                intent.putExtra("name",dataModelArrayList.get(position).getName());
                intent.putExtra("price",dataModelArrayList.get(position).getPrice());
                intent.putExtra("description",dataModelArrayList.get(position).getDescription());
                intent.putExtra("image_url",dataModelArrayList.get(position).getImgURL());
                intent.putExtra("type",1);

                view.getContext().startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, price,description;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.Name);
            price = (TextView) itemView.findViewById(R.id.orderprice);
            imageView = (ImageView) itemView.findViewById(R.id.item_image);
            description = (TextView) itemView.findViewById(R.id.description);
        }

    }
}
