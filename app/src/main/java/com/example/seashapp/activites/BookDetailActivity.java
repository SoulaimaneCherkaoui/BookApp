package com.example.seashapp.activites;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.seashapp.R;
import com.example.seashapp.models.Book;
import com.squareup.picasso.Picasso;

public class BookDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_item);
        Intent intent=getIntent();
        Book book = (Book) intent.getSerializableExtra("books");
        TextView textView= findViewById(R.id.titleDetail);
        TextView textViewAuthor= findViewById(R.id.AuthorDetail);
        TextView textViewDesc= findViewById(R.id.DescriptionDetail);
        ImageView imageView=findViewById(R.id.imageViewBookDetail);
        Button buttonShare = findViewById(R.id.button_share);

        textView.setText(book.getVolumeInfo().getTitle());
        textViewAuthor.setText(book.getVolumeInfo().getAuthors().toString());
        textViewDesc.setText(book.getVolumeInfo().getDescription());
        Picasso.get().load(book.getVolumeInfo().getImageLinks().getThumbnail().replace("http://","https://")).into(imageView);
buttonShare.setOnClickListener(v -> {
    String sharedMsg="Titre" + book.getVolumeInfo().getTitle() + " "
            + " /// Description : " + book.getVolumeInfo().getDescription();
    Intent Shareintent = new Intent(Intent.ACTION_SEND);
    Shareintent.setType("text/plain");
    Shareintent.putExtra(Intent.EXTRA_TEXT,sharedMsg);
    //chooser qui permet de specifier l'appclication ou on veut partager :
    startActivity(Intent.createChooser(Shareintent,"Partager via:"));
});


    }
}
