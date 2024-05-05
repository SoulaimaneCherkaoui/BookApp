package com.example.seashapp.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import com.example.seashapp.models.GoogleBooksResponse;

public interface GoogleBooksAPI {
    @GET("v1/volumes")
    Call<GoogleBooksResponse> searshBooks(@Query("q") String query);

}
