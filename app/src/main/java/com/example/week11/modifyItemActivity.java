package com.example.week11;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class modifyItemActivity extends AppCompatActivity {
    private EditText addItemET, addNoteET;
    private Button modifyItem;
    private ItemStorage is;
    private Item itemToModify;
    private Long timestamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_item);

        addItemET = findViewById(R.id.etAddItem);
        addNoteET = findViewById(R.id.etAddNoteToItem);
        modifyItem = findViewById(R.id.modifyItemButton);
        is = ItemStorage.getInstance();

        itemToModify = (Item) getIntent().getSerializableExtra("itemToModify");
        timestamp = itemToModify.getTimestamp();

        addItemET.setText(itemToModify.getItemName());
        addNoteET.setText(itemToModify.getNote());

        modifyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newItemName = addItemET.getText().toString();
                String newNote = addNoteET.getText().toString();
                itemToModify.setItemName(newItemName);
                itemToModify.setNote(newNote);
                itemToModify.setTimestamp(timestamp);
                is.getItems().add(itemToModify);
                finish();
            }
        });

    }

    public void modifyItem(View view) {

    }
}
