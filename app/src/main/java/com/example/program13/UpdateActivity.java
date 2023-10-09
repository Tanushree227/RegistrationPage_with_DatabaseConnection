package com.example.program13;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    DBHandler dbHandler;
    EditText userUpdate, phoneUpdate, emailUpdate, passwordUpdate, cPasswordUpdate;
    Button update, delete;
    String user1, email1, phone1, password1, cPassword1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        userUpdate = findViewById(R.id.userNameUpdate);
        emailUpdate = findViewById(R.id.emailUpdate);
        phoneUpdate = findViewById(R.id.phoneUpdate);
        passwordUpdate = findViewById(R.id.passwordUpdate);
        cPasswordUpdate = findViewById(R.id.cPasswordUpdate);
        update = findViewById(R.id.updateBtn);
        delete = findViewById(R.id.deleteBtn);
        ImageButton back = (ImageButton) findViewById(R.id.backUpdate);

        dbHandler = new DBHandler(UpdateActivity.this);

        user1 = getIntent().getStringExtra("name");
        email1 = getIntent().getStringExtra("email");
        phone1 = getIntent().getStringExtra("phone");
        password1 = getIntent().getStringExtra("password");
        cPassword1 = getIntent().getStringExtra("cpassword");

        userUpdate.setText(user1);
        emailUpdate.setText(email1);
        phoneUpdate.setText(phone1);
        passwordUpdate.setText(password1);
        cPasswordUpdate.setText(cPassword1);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHandler.UpdateUserDetails(user1, emailUpdate.getText().toString(), phoneUpdate.getText().toString(), passwordUpdate.getText().toString(), cPasswordUpdate.getText().toString());
                Toast.makeText(UpdateActivity.this, "User Details Updated", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateActivity.this, ViewDetailsActivity.class);
                startActivity(intent);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHandler.DeleteUser(user1);
                Toast.makeText(UpdateActivity.this, "Deleted the User", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateActivity.this, ViewDetailsActivity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}