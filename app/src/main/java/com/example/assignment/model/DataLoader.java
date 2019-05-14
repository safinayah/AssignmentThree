package com.example.assignment.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.util.ArrayList;

public class DataLoader {

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private Gson gson = new Gson();
    private ArrayList <Item> items = new ArrayList<>();

    public DataLoader(Context obj){

       prefs= PreferenceManager.getDefaultSharedPreferences(obj);
       editor=prefs.edit();
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public boolean saveAll(){
        if(items.size() == 0){
            return false;
        }

        //first convert the arraylist into array
        Item[] item = new Item [items.size()];
        item = items.toArray(item);

        // now use Gson to convert the array into JSON
        String jsonStr = gson.toJson(item);
        //save it at sharedpreferences
        editor.putString("123", jsonStr);
        editor.commit();
        //clear your arraylist
        items.clear();
        return true;

    }


    public void addItem(Item obj){

        items.add(obj);

    }
    public Item[] loadItem(){
        //first get the json string
        String json = prefs.getString("123", "");
        //convert it to array
        if(json.length() > 0) {
            Item[] items = gson.fromJson(json, Item[].class);

            return items;
        }
        else{
            return null;
        }
    }



}
