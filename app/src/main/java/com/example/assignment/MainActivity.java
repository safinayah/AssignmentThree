package com.example.assignment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.assignment.model.DataLoader;
import com.example.assignment.model.Item;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SharedPreferences.Editor editor;
    private SharedPreferences prefs;
    private Gson gson = new Gson();

    public static final String MY_ITEMS = "";
   DataLoader database ;
   Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedpreferences = context.getSharedPreferences(MY_ITEMS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        setContentView(R.layout.activity_main);
        RecyclerView recycler = findViewById(R.id.RV_fitafe);
        database = new DataLoader(this);
        List<Item> item = new ArrayList<>();
       Item items = new Item();
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
            items.setName(Item.menu[i].getName());
            items.setContents( Item.menu[i].getContents());
            items.setImageID(Item.menu[i].getImageID());
            item.add(new Item(Item.menu[i].getName(),  Item.menu[i].getContents(),Item.menu[i].getImageID()));
        }

        editor.apply();
        database.addItem(items);
        database.saveAll();

        recycler.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(name, content,ids);
        recycler.setAdapter(adapter);

    }






}
