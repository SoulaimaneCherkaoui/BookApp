package com.example.seashapp.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GoogleBooksResponse implements Serializable {
@SerializedName(value = "kind")
    private String kind;
    @SerializedName(value = "totalItems")

    private int totalItems;
    @SerializedName(value = "items")

    private List<Book> items;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<Book> getItems() {
        return items;
    }

    public void setItems(List<Book> items) {
        this.items = items;
    }
}
