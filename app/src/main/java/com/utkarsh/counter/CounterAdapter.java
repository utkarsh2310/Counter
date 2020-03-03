package com.utkarsh.counter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CounterAdapter extends CursorAdapter {

    public CounterAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameTextView = view.findViewById(R.id.name_textView);
        TextView priceTextView = view.findViewById(R.id.price_textView);
        TextView quantityTextView = view.findViewById(R.id.quantity_textView);

        nameTextView.setText();
        priceTextView.setText();
        quantityTextView.setText();
    }
}
