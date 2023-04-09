package com.example.week11;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private Button deleteButton, modifyButton;
    private TextView itemID, note;
    private Context context;
    private RecyclerView recyclerView;
    private ItemStorage is;


    public ItemViewHolder(@NonNull View itemView, RecyclerView recyclerView) {
        super(itemView);
        context = itemView.getContext();
        this.recyclerView = recyclerView;
        deleteButton = itemView.findViewById(R.id.delete_button);
        modifyButton = itemView.findViewById(R.id.modify_button);
        itemID = itemView.findViewById(R.id.tv_itemId);
        note = itemView.findViewById(R.id.tv_note);

        deleteButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                is =ItemStorage.getInstance();
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    ItemListAdapter itemListAdapter = (ItemListAdapter) recyclerView.getAdapter();
                    itemListAdapter.removeItem(position);
                    itemListAdapter.notifyItemRemoved(position);
                    itemListAdapter.notifyItemRangeChanged(position, itemListAdapter.getItemCount());
                }
            }
        }));

        modifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            //Here i first add new modified object to list and then remove the old one
            public void onClick(View view) {
                is = ItemStorage.getInstance();
                int position = getAdapterPosition();
                Item itemToModify = is.getItems().get(position);
                if (context != null){
                    Intent intent = new Intent(context, modifyItemActivity.class);
                    intent.putExtra("itemToModify", itemToModify);
                    context.startActivity(intent);
                }
                if (position != RecyclerView.NO_POSITION) {
                    ItemListAdapter itemListAdapter = (ItemListAdapter) recyclerView.getAdapter();
                    itemListAdapter.removeItem(position);
                    itemListAdapter.notifyItemRemoved(position);
                    itemListAdapter.notifyItemRangeChanged(position, itemListAdapter.getItemCount());
                }
            }


        });
    }

    public void bind(Item item) {
        itemID.setText(item.getItemName());
        note.setText(item.getNote());
    }
}
