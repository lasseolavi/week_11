package com.example.week11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private ItemStorage itemStorage;
    private  ItemListAdapter itemListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemStorage = ItemStorage.getInstance();

        recyclerView = findViewById(R.id.rvItemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemListAdapter = new ItemListAdapter(this,itemStorage.getItems(), recyclerView);
        itemListAdapter.sortItemsByTime(itemStorage.getItems());
        recyclerView.setAdapter(itemListAdapter);


    }
    protected void onResume() {
        super.onResume();
        itemListAdapter.notifyDataSetChanged();
    }
    public void switchToAddItem(View view){
        Intent intent = new Intent(this, addItemActivity.class);
        startActivity(intent);
    }
}