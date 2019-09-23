package com.rifkistwn.top10;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private UnivAdapter adapter;
    private ArrayList<Univ> Unives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new UnivAdapter(this);

        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        //Menyipakan data dari resource
        prepare();

        //Menambahkan data dari resource ke adapter
        addItem();

        //Memberi aksi pada listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, Unives.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        Unives = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Univ Univ = new Univ();
            Univ.setPhoto(dataPhoto.getResourceId(i, -1));
            Univ.setName(dataName[i]);
            Univ.setDescription(dataDescription[i]);
            Unives.add(Univ);
        }

        adapter.setUnives(Unives);
    }
}
