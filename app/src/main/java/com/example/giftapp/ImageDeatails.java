package com.example.giftapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class ImageDeatails extends AppCompatActivity {

    CustomAdapter cusAdpapter;
    ArrayList<User> userList;
    ListView lv;
    Button commentButton, favoriteButton;
    ImageView likeImage,dislikeImage;
    EditText comment, username;
    TextView likeText;
    TextView dislikeText;
    Dialog myDialog;
    int like = 0, dislike = 0;
    int favorite = 0;
    Drawable res;
    //int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_deatails);

        commentButton = (Button) findViewById(R.id.butComment);
        favoriteButton = (Button) findViewById(R.id.butFavorite);
        likeImage = (ImageView) findViewById(R.id.like);
        dislikeImage = (ImageView) findViewById(R.id.dislike);
        comment = (EditText) findViewById(R.id.comment);
        username = (EditText) findViewById(R.id.username);
        likeText = (TextView) findViewById(R.id.likeText);
        dislikeText = (TextView) findViewById(R.id.dislikeText);
        TextView test = (TextView) findViewById(R.id.test);
        myDialog = new Dialog(this);
        userList = new ArrayList<User>();
        userList.add(new User("name", "email", "phone","comment example"));
        cusAdpapter = new CustomAdapter(ImageDeatails.this, userList);
        lv = (ListView) findViewById(R.id.lView);
        lv.setAdapter(cusAdpapter);


        String tag = getIntent().getExtras().getString("vue");
        ImageView img = (ImageView) findViewById(R.id.img);
        String url = "@drawable/"+tag;
        int imageRessource = getResources().getIdentifier(url, null, getPackageName());
         res = getResources().getDrawable(imageRessource);
        img.setImageDrawable(res);

        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commentText = comment.getText().toString();
                String usernameText = username.getText().toString();
                if( !commentText.isEmpty() &&  !usernameText.isEmpty()) {
                    //commentText.replace("\n", " ");
                    User u = new User(usernameText, "emailtest", "0000", commentText);
                    userList.add(u);
                    cusAdpapter.notifyDataSetChanged();
                    comment.setText("");
                    username.setText("");
                    Toast.makeText(ImageDeatails.this, "success comment!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ImageDeatails.this, "user or/and comment should not be empty !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( favorite == 0) {
                    favoriteButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_favorite_24,0,0,0);
                    favorite = 1;
                } else {
                    favoriteButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_favorite_border_24,0,0,0);
                    favorite = 0;

                }
            }
        });



    }
    public void ShowPopup(View v) {
        TextView txtclose;
        EditText urlText;
        Button btnContinuer;
        myDialog.setContentView(R.layout.mypopup);
        ImageView imag = (ImageView) myDialog.findViewById(R.id.imgPopUp);
        imag.setImageDrawable(res);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);

        urlText =(EditText) myDialog.findViewById(R.id.urlText);
        btnContinuer =(Button) myDialog.findViewById(R.id.btnContinuer);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        btnContinuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = urlText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        //myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }


    public void likeAction(View v) {
        int likes = Integer.parseInt(likeText.getText().toString().trim());
        int dislikes = Integer.parseInt(dislikeText.getText().toString().trim());
        if(dislike == 1){
            dislike = 0 ;
            dislikeImage.setBackgroundResource(R.drawable.dislike);
            dislikes--;
            dislikeText.setText(""+dislikes+"");
        }
        if( like == 0 ) {
            likeImage.setBackgroundResource(R.drawable.like_active);
            like = 1;
            likes++;
            likeText.setText(""+likes+"");
        } else {
            likeImage.setBackgroundResource(R.drawable.like);
            like = 0;
            likes--;
            likeText.setText(""+likes+"");
        }
    }


    public void dislikeAction(View v) {
        int likes = Integer.parseInt(likeText.getText().toString().trim());
        int dislikes = Integer.parseInt(dislikeText.getText().toString().trim());
        if(like == 1){
            like =0 ;
            likeImage.setBackgroundResource(R.drawable.like);
            likes--;
            likeText.setText(""+likes+"");
        }
        if( dislike == 0 ) {
            dislikeImage.setBackgroundResource(R.drawable.dislike_active);
            dislike = 1;
            dislikes++;
            dislikeText.setText(""+dislikes+"");
        } else {
            dislikeImage.setBackgroundResource(R.drawable.dislike);
            dislike = 0;
            dislikes--;
            dislikeText.setText(""+dislikes+"");
        }
    }
}