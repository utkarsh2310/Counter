package com.utkarsh.counter.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;


public class ItemDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "item.db";
    public static final int DATABASE_VERSION = 1;

    public ItemDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE " + "TABLE " + ItemContract.ItemEntry.TABLE_NAME
                + "(" + ItemContract.ItemEntry.NAME_COLUMN + "text,"
                + ItemContract.ItemEntry.PRICE_COLUMN + "int,"
                + ItemContract.ItemEntry.QUANTITY_COLUMN + "int"
                + ")" ;
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
