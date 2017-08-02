package com.example.quanlm.restfulapicalling;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by QuanLM on 8/2/2017.
 */

public class AdtContact extends ArrayAdapter<Model_Contact> {
    int resource;

    public AdtContact(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Model_Contact contact = getItem(position);
        View contactView = LayoutInflater.from(getContext()).inflate(this.resource, parent, false);
        TextView txtContactName = (TextView) contactView.findViewById(R.id.txtContactName);
        TextView txtContactEmail = (TextView) contactView.findViewById(R.id.txtContactEmail);
        TextView txtContactAddress = (TextView) contactView.findViewById(R.id.txtContactAddress);
        txtContactName.setText(contact.getContactName());
        txtContactEmail.setText(contact.getContactEmail());
        txtContactAddress.setText(contact.getContactAddress());
        return contactView;
    }
}
