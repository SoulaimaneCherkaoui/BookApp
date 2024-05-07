package com.example.seashapp.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class volumeInfo implements Serializable {
    @SerializedName("title")
    private String title;
    @SerializedName("authors")
    private List<String> authors;
    @SerializedName("publisher")
    private String publisher;
    @SerializedName("description")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public com.example.seashapp.models.imageLinks getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(com.example.seashapp.models.imageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }

    @SerializedName("imageLinks")
    private imageLinks imageLinks;

}
