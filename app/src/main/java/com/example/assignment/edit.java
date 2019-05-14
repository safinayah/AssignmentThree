package com.example.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    }

    public void edit(View view) {
        Item item = new Item();
        EditText editText =findViewById(R.id.editTxt);
        String update = editText.getText().toString();
        item.setName(update);
        TextView txt = findViewById(R.id.viewer);
        txt.setText(item.getName().toString());


    }

    public void back(View view) {

        view.getContext().startActivity(new Intent(view.getContext(), edit.class));

    }
}
