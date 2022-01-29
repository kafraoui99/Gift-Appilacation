package com.example.giftapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    ImageView img ;
    Button tendance, populaire, dernier ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tendance = findViewById(R.id.tendance);
        populaire = findViewById(R.id.populaire);
        dernier = findViewById(R.id.dernier);

        tendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Recommandation.class);
                startActivity(intent);
            }
        });

        populaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Recommandation.class);
                startActivity(intent);
            }
        });

        dernier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Recommandation.class);
                startActivity(intent);
            }
        });

    }

    public void afficherFormulaire(View view){
        Intent myIntent = new Intent(MainActivity.this, formulaire.class);
        startActivity(myIntent);
    }

    public void envoyerImage(View view){
        //img = (ImageView) findViewById();
        //View img = findViewById(view.getId());

        Intent intent = new Intent(MainActivity.this, ImageDeatails.class);
        intent.putExtra("vue", view.getTag().toString());
        //intent.putExtra("vue", view.getId());
        startActivity(intent);

       // Toast.makeText(MainActivity.this, view.getTag().toString(),Toast.LENGTH_SHORT).show();

        /*Toast.makeText(MainActivity.this, String.valueOf(view.getId()),Toast.LENGTH_SHORT).show();

        Bitmap bmp = BitmapFactory.decodeResource(getResources(), img.getId());
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        Intent intent = new Intent(MainActivity.this, formulaire.class);
        startActivity(intent);
 */
    }
}

