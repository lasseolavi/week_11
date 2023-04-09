package com.example.week11;

import java.io.Serializable;

public class Item implements Serializable {

    private String itemName;
    private String note;
    private long timestamp;

    public  Item(String itemName, String note, long timestamp) {
        this.itemName = itemName;
        this.note = note;
        this.timestamp = timestamp;
    }

    public String getItemName() {
        return itemName;
    }

    public String getNote() {
        return note;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public Long getTimestamp(){
        return timestamp;
    }
    public void setTimestamp(Long timestamp){
        this.timestamp = timestamp;
    }
}
