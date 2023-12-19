package com.uzair.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.uzair.foodapp.databinding.ActivityDetailBinding;
import com.uzair.foodapp.databinding.ActivityOrdersBinding;

import org.antlr.v4.runtime.atn.SemanticContext;

import java.util.ArrayList;

public class ordersActivity extends AppCompatActivity {

    ActivityOrdersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityOrdersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Orders");


        DBHelperOrderDataStore dbHelperOrderDataStore =new DBHelperOrderDataStore(this);
        ArrayList<OrdersModel> list =dbHelperOrderDataStore.getOrders();
        for (int i=0;i<list.size();i++){


            OrdersAdapter adapter =new OrdersAdapter(ordersActivity.this,list);
            binding.recyclerViewSoldItem.setAdapter(adapter);

            LinearLayoutManager layoutManager=new LinearLayoutManager(this);
            binding.recyclerViewSoldItem.setLayoutManager(layoutManager);

        }




    }
}