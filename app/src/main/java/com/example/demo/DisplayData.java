package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class DisplayData extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;

    ArrayList<String> name,roll,id;
    RecyclerView   recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);



        dataBaseHelper = new DataBaseHelper(DisplayData.this);

        Cursor cursor = dataBaseHelper.showData();
        if (cursor.getCount()==0){

        }

        name = new ArrayList<>();
        roll = new ArrayList<>();
        id = new ArrayList<>();

        while (cursor.moveToNext()){


            name.add(cursor.getString(cursor.getColumnIndex(Query.Name)));
            roll.add(cursor.getString(cursor.getColumnIndex(Query.Roll)));
            id.add(cursor.getString(cursor.getColumnIndex(Query.ID)));
        }

        recyclerView = findViewById(R.id.recyclerView_ID);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(DisplayData.this,name,roll,id);
        recyclerView.setAdapter(adapter);
    }
}
