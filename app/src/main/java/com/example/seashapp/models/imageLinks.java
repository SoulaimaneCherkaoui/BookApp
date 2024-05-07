package com.example.seashapp.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class imageLinks implements Serializable {
    @SerializedName("smallThumbnail")
    private String smallThumbnail;
    @SerializedName("thumbnail")
    private String thumbnail;

    public imageLinks() {
    }

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public imageLinks(String smallThumbnail, String thumbnail) {
        this.smallThumbnail = smallThumbnail;
        this.thumbnail = thumbnail;
    }

    public void setSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
