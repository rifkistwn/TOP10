package com.rifkistwn.top10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rifkistwn.top10.R;
import com.rifkistwn.top10.Univ;

import java.util.ArrayList;

public class UnivAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Univ> Unives;

    void setUnives(ArrayList<Univ> Unives) {
        this.Unives = Unives;
    }

    UnivAdapter(Context context) {
        this.context = context;
        Unives = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return Unives.size();
    }

    @Override
    public Object getItem(int i) {
        return Unives.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {

            view = LayoutInflater.from(context).inflate(R.layout.item_univ, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);

        Univ Univ = (Univ) getItem(i);
        viewHolder.bind(Univ);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Univ Univ) {
            txtName.setText(Univ.getName());
            txtDescription.setText(Univ.getDescription());
            imgPhoto.setImageResource(Univ.getPhoto());
        }
    }
}
