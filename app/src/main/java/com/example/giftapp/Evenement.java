package com.example.giftapp;

import android.provider.BaseColumns;

public class Evenement {
    public Evenement() {
    }

    public static final class EvenementDetails implements BaseColumns{

        public static final String TABLE_NAME = "Evenement" ;
        public static final String COL_ID = "id";
        public static final String COL_NAME = "nom" ;

    }
}
