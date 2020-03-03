package com.utkarsh.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;

import com.utkarsh.counter.Data.ItemContract;

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

        Uri newUri = getContentResolver().insert(ItemContract.BASE_URI,contentValues);
    }
}
