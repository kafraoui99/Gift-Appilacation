package com.example.giftapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Recommandation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommandation);


    }
    public void envoyerImage(View view){
        Intent intent = new Intent(Recommandation.this, ImageDeatails.class);
        intent.putExtra("vue", view.getTag().toString());

        startActivity(intent);
    }
}