package com.example.program13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username = (EditText) findViewById(R.id.userName);
        EditText email = (EditText) findViewById(R.id.email);
        EditText phone = (EditText) findViewById(R.id.phone);
        EditText password = (EditText) findViewById(R.id.password);
        EditText c_password = (EditText) findViewById(R.id.cPassword);
        MaterialButton submit = (MaterialButton) findViewById(R.id.submitBtn);

        dbHandler = new DBHandler(MainActivity.this);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uName1 = username.getText().toString();
                String email1 = email.getText().toString();
                String phone1 = phone.getText().toString();
                String password1 = password.getText().toString();
                String cPassword1 = c_password.getText().toString();

                if (uName1.isEmpty() && email1.isEmpty() && phone1.isEmpty() && password1.isEmpty() && cPassword1.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbHandler.addNewUser(uName1, email1, phone1, password1, cPassword1);


                Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                username.setText("");
                email.setText("");
                phone.setText("");
                password.setText("");
                c_password.setText("");

                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }

}