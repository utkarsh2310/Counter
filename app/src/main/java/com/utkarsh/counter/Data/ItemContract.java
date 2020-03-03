package com.utkarsh.counter.Data;

import android.net.Uri;
import android.net.wifi.aware.PublishConfig;
import android.provider.BaseColumns;

public class ItemContract {

    public static final String CONTENT_AUTHORITY = "com.utkarsh.counter";
    public static final String PATH = "item";
    public static final Uri CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    private ItemContract() {}

    public static final class ItemEntry implements BaseColumns {

        public static final Uri BASE_URI = Uri.withAppendedPath(CONTENT_URI,PATH);

        public static final String TABLE_NAME = "Items";
        public static final String _ID = BaseColumns._ID;
        public static final String NAME_COLUMN = "name";
        public static final String QUANTITY_COLUMN = "quantity";
        public static final String PRICE_COLUMN = "price";
    }

}
