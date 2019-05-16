package com.example.assignment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.assignment.model.Item;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SharedPreferences.Editor editor;
    private SharedPreferences prefs;
    private Gson gson = new Gson();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        RecyclerView recycler = findViewById(R.id.RV_fitafe);

        String[] content = new String[Item.menu.length];
        String[] name = new String[Item.menu.length];
        int[] ids = new int[Item.menu.length];

        for(int i = 0; i<name.length;i++){
            name[i] = Item.menu[i].getName();
            editor.putString("name",name[i] = Item.menu[i].getName());
            content[i] = Item.menu[i].getContents();
            editor.putString("content",name[i] = Item.menu[i].getContents());
            ids[i] = Item.menu[i].getImageID();
            editor.putString("Image",name[i] = String.valueOf(Item.menu[i].getImageID()));
        }



        recycler.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(name, content,ids);
        recycler.setAdapter(adapter);

    }


}
