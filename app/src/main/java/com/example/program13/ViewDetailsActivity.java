package com.example.program13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewDetailsActivity extends AppCompatActivity {

    DBHandler dbHandler;
    private ArrayList<UserModal> userModalArrayList;
    private UserAdapter userAdapter;
    private RecyclerView userRV;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        dbHandler = new DBHandler(this);
        userModalArrayList = new ArrayList<>();
        userModalArrayList = dbHandler.readUsers();

        userAdapter = new UserAdapter(userModalArrayList, ViewDetailsActivity.this);
        userRV = findViewById(R.id.RVUsers);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewDetailsActivity.this, RecyclerView.VERTICAL, false);
        userRV.setLayoutManager(linearLayoutManager);
        userRV.setAdapter(userAdapter);

        Button backBtn = (Button) findViewById(R.id.btnBack);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}