package com.rktuhin.robi_10minuteschooltask.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rktuhin.robi_10minuteschooltask.R;
import com.rktuhin.robi_10minuteschooltask.adapter.ItemRecyclerAdapter;
import com.rktuhin.robi_10minuteschooltask.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<ItemModel> itemModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        ItemRecyclerAdapter itemRecyclerAdapter = new ItemRecyclerAdapter(this, itemModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemRecyclerAdapter);
    }

    private void initData() {
        itemModelList = new ArrayList<>();
        itemModelList.add(new ItemModel("Chapter 1", ""));
        itemModelList.add(new ItemModel("Chapter 2", ""));
        itemModelList.add(new ItemModel("Video 3.0", ""));
        itemModelList.add(new ItemModel("Document 4.0", "Md. Rejaul Karim"));
    }

}
