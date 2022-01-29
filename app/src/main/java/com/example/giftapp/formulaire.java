package com.example.giftapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class formulaire extends AppCompatActivity {

    Spinner ageSpinner, sexeSpinner ;
    Button valider, annuler ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire);

        ageSpinner = (Spinner) findViewById(R.id.ageSpinner) ;

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(formulaire.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ages));
        ageSpinner.setAdapter(myAdapter);

        sexeSpinner = (Spinner) findViewById(R.id.sexeSpinner);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<>(formulaire.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sexe));
        sexeSpinner.setAdapter(myAdapter2);


        valider = (Button) findViewById(R.id.valider);
        annuler = (Button) findViewById(R.id.annuler);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(formulaire.this, Recommandation.class);
                startActivity(myIntent);
            }
        });

        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(formulaire.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
/*
        String tag = getIntent().getExtras().getString("vue");
        ImageView img = (ImageView) findViewById(R.id.img);
        img.setImageResource();

 */
        //});
        /*
        int id = getIntent().getExtras().getInt("vue");
        ImageView image =  (ImageView)findViewById(R.id.);
        image.setImageResource(id);

         */
     //   image.setI

       /* Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("picture");

        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        View image =  findViewById(R.id.img);
        image.setImageBitmap(bmp);

        */

/*
        String tag = getIntent().getExtras().getString("vue");
        ImageView img = (ImageView) findViewById(R.id.img);
        String url = "@drawable/"+tag;
        int imageRessource = getResources().getIdentifier(url, null, getPackageName());
        Drawable res = getResources().getDrawable(imageRessource);
        img.setImageDrawable(res);

 */

    }
}