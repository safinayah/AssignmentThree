package com.example.assignment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment.model.DataLoader;
import com.example.assignment.model.Item;

public class edit extends AppCompatActivity {

    private DataLoader database;

    private  Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        database = new DataLoader(this);
    }

    public String edit(View view) {
        Item item = new Item();
        EditText editText =findViewById(R.id.editTxt);
        String update = editText.getText().toString();
        item.setName(update);
        TextView txt = findViewById(R.id.viewer);
        txt.setText(item.getName());
        SharedPreferences sharedpreferences = context.getSharedPreferences(MainActivity.MY_ITEMS, Context.MODE_PRIVATE);
        database.saveAll();
        return sharedpreferences.getString("name", "notfound");


    }

    public void back(View view) {

     view.getContext().startActivity(new Intent(view.getContext(), MainActivity.class));


    }
}
