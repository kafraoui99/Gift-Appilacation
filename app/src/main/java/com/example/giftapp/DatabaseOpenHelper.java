package com.example.giftapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.Nullable;


import java.io.File;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private Context context ;

    public static final String DB_NAME = "db.db";
    public static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "evenement";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "nom";


    public DatabaseOpenHelper(@Nullable Context context){
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
       /* String EVENEMENT_TABLE = "CREATE TABLE " + Evenement.EvenementDetails.TABLE_NAME +"(" +
                ""+ Evenement.EvenementDetails.COL_ID + " INTEGER PRIMARY KEY, " +
                "" + Evenement.EvenementDetails.COL_NAME + " TEXT);";



        db.execSQL(EVENEMENT_TABLE);
        System.out.println("succees creation ! ");

        */

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT);";
        db.execSQL(CREATE_TABLE);

    }

    // -------------- addEvenement -------------------------

    public void addEvenement (String name){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_TITLE, name);

        long sid = db.insert(TABLE_NAME, null, values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
/*
        db.execSQL("DROP TABLE IF EXISTS " +Evenement.EvenementDetails.TABLE_NAME);
        onCreate(db);

 */
    }


    /*
    private static final String DATABASE_NAME = "db.db" ;
    private final File DB_FILE;
    private final Context mContext;
    // constructeur

    public DatabaseOpenHelper(Context context){

       // super(context, DATABASE_NAME, null,1);

        super(context, DATABASE_NAME, null, 1);
        DB_FILE = context.getDatabasePath(DATABASE_NAME);
        this.mContext = context;
    }

     */


}
