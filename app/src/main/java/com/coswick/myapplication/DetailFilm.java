package com.coswick.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailFilm extends AppCompatActivity {

    private TextView tvtitle,tvdescription,tvcategory;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_film);

        tvtitle = (TextView) findViewById(R.id.txtTitle);
        tvdescription = (TextView) findViewById(R.id.txtDesc);
        tvcategory = (TextView) findViewById(R.id.txtCat);
        img = (ImageView) findViewById(R.id.resepthumbnail);


        Intent intent = getIntent();
        String Title  = intent.getExtras().getString("Title");
        String Description  = intent.getExtras().getString("Description");
        String Categori =  intent.getExtras().getString("Categori");
        int image  = intent.getExtras().getInt("Thumbnail");


        tvtitle.setText(Title);
        tvdescription.setText(Description);
        tvcategory.setText(Categori);
        img.setImageResource(image);

    }
}
