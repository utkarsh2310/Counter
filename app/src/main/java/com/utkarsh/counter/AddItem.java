package com.utkarsh.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.utkarsh.counter.Data.ItemContract;

import java.util.List;

public class AddItem extends AppCompatActivity {

    EditText mNameEditText;
    EditText mQuantityEditText;
    EditText mPriceTextView;
    String nameText;
    String quantityText;
    String priceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);
        mNameEditText = findViewById(R.id.name_textView);
        mPriceTextView = findViewById(R.id.price_textView);
        mQuantityEditText = findViewById(R.id.quantity_textView);

        nameText = mNameEditText.getText().toString();
        quantityText = mQuantityEditText.getText().toString();
        priceText = mPriceTextView.getText().toString();

    }





    public void insert() {

        ContentValues contentValues = new ContentValues();

        contentValues.put(ItemContract.ItemEntry.NAME_COLUMN,nameText);
        contentValues.put(ItemContract.ItemEntry.PRICE_COLUMN,priceText);
        contentValues.put(ItemContract.ItemEntry.QUANTITY_COLUMN,quantityText);

        Uri newUri = getContentResolver().insert(ItemContract.ItemEntry.BASE_URI,contentValues);
    }

    public void display() {
        String[] projection = {
                ItemContract.ItemEntry._ID,
                ItemContract.ItemEntry.NAME_COLUMN,
                ItemContract.ItemEntry.QUANTITY_COLUMN,
                ItemContract.ItemEntry.PRICE_COLUMN
        };

        Cursor cursor = getContentResolver().query(ItemContract.ItemEntry.BASE_URI,projection,
                null,null,null);

        ListView listView = findViewById(R.id.listView);

        CounterAdapter adapter = new CounterAdapter(this,cursor);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.insert_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.save_insert) {
            insert();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
