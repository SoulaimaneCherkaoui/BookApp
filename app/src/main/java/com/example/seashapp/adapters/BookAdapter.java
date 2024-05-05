package com.example.seashapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.seashapp.R;
import com.example.seashapp.models.Book;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {


    public BookAdapter(@NonNull Context context, int resource, @NonNull List<Book> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
if (convertView==null) {
    convertView=LayoutInflater.from(getContext()).inflate(R.layout.list_book_item,parent,false);

}
Book book=getItem(position);
ImageView imageViewBook = convertView.findViewById(R.id.imageViewBook);
        TextView textViewtitle=convertView.findViewById(R.id.textViewTitle);
        TextView textViewAuthot=convertView.findViewById(R.id.textViewAuthor);
        TextView textViewDescrition=convertView.findViewById(R.id.textViewDescription);
        textViewtitle.setText(book.getVolumeInfo().getTitle());
        textViewAuthot.setText(book.getVolumeInfo().getAuthors().toString());
        textViewDescrition.setText(book.getVolumeInfo().getDescription());
        Picasso.get().load(book.getVolumeInfo().getImageLinks().getThumbnail().replace("http://","https://")).into(imageViewBook);
return convertView;

    }
}
