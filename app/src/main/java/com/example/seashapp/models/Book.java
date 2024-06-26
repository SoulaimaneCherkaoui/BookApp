package com.example.seashapp.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Book implements Serializable {
    @SerializedName("volumeInfo")
    private volumeInfo volumeInfo;

    public com.example.seashapp.models.volumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public Book(com.example.seashapp.models.volumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public Book() {
    }

    public void setVolumeInfo(com.example.seashapp.models.volumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }
}
