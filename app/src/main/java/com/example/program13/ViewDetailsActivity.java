package com.example.program13;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewDetailsActivity extends AppCompatActivity {

    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        dbHandler = new DBHandler(this);

        ArrayList<HashMap<String, String>> userList = dbHandler.getUsers();
        ListView userListView = (ListView) findViewById(R.id.userList);
        ListAdapter adapter = new SimpleAdapter(ViewDetailsActivity.this, userList, R.layout.list_row, new String[]{"userName"}, new int[]{R.id.name});
        userListView.setAdapter(adapter);

        Button backBtn = (Button) findViewById(R.id.btnBack);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}