package com.example.program13;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        DBHandler db = new DBHandler(this);

        Button insert = (Button) findViewById(R.id.insert);
        Button update = (Button) findViewById(R.id.update);
        Button display = (Button) findViewById(R.id.display);
        Button search = (Button) findViewById(R.id.search);
        Button delete = (Button) findViewById(R.id.delete);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(DisplayActivity.this, MainActivity.class);
                startActivity(i1);
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayActivity.this, ViewDetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}