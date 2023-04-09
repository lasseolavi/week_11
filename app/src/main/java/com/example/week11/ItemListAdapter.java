package com.example.week11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private Context context;

    private ArrayList<Item> listItems;
    private RecyclerView recyclerView;

    public ItemListAdapter(Context context, ArrayList<Item> listItems, RecyclerView recyclerView) {
        this.context = context;
        this.listItems = listItems;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.list_view,parent,false),recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(listItems.get(position));
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
    public void removeItem(int position) {
        listItems.remove(position);
        notifyItemRemoved(position);
    }
    public void sortItemsByTime(ArrayList<Item> items) {
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item item, Item t1) {
                return Long.compare(item.getTimestamp(), t1.getTimestamp());
            }
        });
    }

}
