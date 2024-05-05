package com.example.seashapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.seashapp.adapters.BookAdapter;
import com.example.seashapp.models.Book;
import com.example.seashapp.models.GoogleBooksResponse;
import com.example.seashapp.services.GoogleBooksAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Book> books;
    ListView listViewBook;
    Button bunttonSearch;
    EditText editTextQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        books=new ArrayList<>();
        //charger les donners dans un adapter
        BookAdapter bookBookAdapter=new BookAdapter(this,R.layout.list_book_item,books);
      listViewBook = findViewById(R.id.listViewBooks);
        //generer la liste view dans l'adapter quand on creer
        listViewBook.setAdapter(bookBookAdapter);
        bunttonSearch=findViewById(R.id.buttonSearch);
        editTextQ=findViewById(R.id.editTextQuery);

        Gson gson = new GsonBuilder().create();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        GoogleBooksAPI booksAPI = retrofit.create(GoogleBooksAPI.class);
        bunttonSearch.setOnClickListener(v -> {
String query = editTextQ.getText().toString();

            Call<GoogleBooksResponse> call = booksAPI.searshBooks(query);
            //Asynchrone:
            call.enqueue(new Callback<GoogleBooksResponse>() {
                @Override
                public void onResponse(Call<GoogleBooksResponse> call, Response<GoogleBooksResponse> response) {
                    GoogleBooksResponse booksResponse = response.body();
                    books.clear();
                    books.addAll(booksResponse.getItems());
                  Log.i("info","test5554 " + booksResponse.toString());
                    bookBookAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<GoogleBooksResponse> call, Throwable t) {
                    t.printStackTrace();
                    Toast.makeText(MainActivity.this,"Erreur de connexion",Toast.LENGTH_SHORT);
                }
            });


        });

}}