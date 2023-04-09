package com.example.week11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class addItemActivity extends AppCompatActivity {

    private EditText addItemET, addNoteET;
    private Button addItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

        addItemET = findViewById(R.id.etAddItem);
        addNoteET = findViewById(R.id.etAddNoteToItem);
        addItem = findViewById(R.id.addItemButton);

    }
    public void addItem(View view) {
        String item = addItemET.getText().toString();
        String note = addNoteET.getText().toString();

        Item newItem = new Item(item,note,System.currentTimeMillis());
        ItemStorage itemStorage = ItemStorage.getInstance();
        itemStorage.addItem(newItem);

    }
}
