package com.utkarsh.counter.Data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class ItemProvider extends ContentProvider {

    ItemDbHelper itemDbHelper;
    SQLiteDatabase db;

    private static final int ITEM = 100;
    private static final int ITEM_COLUMN = 101;


    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(ItemContract.CONTENT_AUTHORITY, ItemContract.PATH,ITEM);
        sUriMatcher.addURI(ItemContract.CONTENT_AUTHORITY,ItemContract.PATH + "/#",ITEM_COLUMN);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        itemDbHelper = new ItemDbHelper(getContext());
        db = itemDbHelper.getReadableDatabase();

        int match = sUriMatcher.match(uri);
        Cursor cursor;
        switch (match) {
            case ITEM:
                cursor = db.query(ItemContract.ItemEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case ITEM_COLUMN:
               selection = ItemContract.ItemEntry._ID + "=?";
               selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri))};
               cursor = db.query(ItemContract.ItemEntry.TABLE_NAME,
                       projection,
                       selection,
                       selectionArgs,
                       null,
                       null,
                       sortOrder);
               break;
               default:
                   throw new IllegalArgumentException("not found");
        }
        return cursor;
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

        int match = sUriMatcher.match(uri);
        switch (match) {
            case ITEM:
                return insertItem(uri,values);
            default:
                throw new IllegalArgumentException("Cannot be inserted");
        }
    }

    public Uri insertItem(Uri uri,ContentValues values) {
        long id = db.insert(ItemContract.ItemEntry.TABLE_NAME,null,values);
        return ContentUris.withAppendedId(uri,id);
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
