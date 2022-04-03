package com.example.frige.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.frige.R;
import com.example.frige.login.ui.login.LoginActivity;
import com.example.frige.models.FrigeItemModel;

import java.util.List;

public class FrigeAdapter extends BaseAdapter {
    private List<FrigeItemModel> items;
    private Context context;
    private TextView product;
    private TextView quantity;
    private TextView lastRefill;

    public FrigeAdapter(List<FrigeItemModel> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, @NonNull ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(R.layout.frige_list_detail, parent, false);
        product = view.findViewById(R.id.productTV);
        quantity = view.findViewById(R.id.quantityTV);
        lastRefill = view.findViewById(R.id.lastRefillTV);

            product.setText(items.get(i).getItemID());
            quantity.setText(items.get(i).getQuantity());
            lastRefill.setText(items.get(i).getUpdateDate());



        return view;
    }
}
