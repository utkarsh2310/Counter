package com.utkarsh.counter.Data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ProxyInfo;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;

public class ItemProvider extends ContentProvider {

    ItemDbHelper itemDbHelper;
    SQLiteDatabase db;

    private static final int ITEM = 100;
    private static final int ITEM_COLUMN = 101;


    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(ItemContract.CONTENT_AUTHORITY, ItemContract.PATH,100);
        sUriMatcher.addURI(ItemContract.CONTENT_AUTHORITY,ItemContract.PATH + "/#",101);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {

        itemDbHelper = new ItemDbHelper(getContext());
        db = itemDbHelper.getWritableDatabase();

        long id = db.insert(ItemContract.ItemEntry.TABLE_NAME,null,values);
        return ;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
