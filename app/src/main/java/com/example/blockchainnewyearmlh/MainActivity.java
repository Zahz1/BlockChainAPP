package com.example.blockchainnewyearmlh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void nextPage (View view){

        EditText u = findViewById(R.id.editTextTextPersonName2);
        EditText p = findViewById(R.id.editTextTextPersonName3);

        if (u.getText().toString().equals("")){
            Toast.makeText(this, "Username empty.", Toast.LENGTH_SHORT).show();
        }else{

            if (p.getText().toString().equals("")){
                Toast.makeText(this, "Passwords empty.", Toast.LENGTH_SHORT).show();
            }else{


                //check to see if it is in the database
                //if(in database)


                try () {
                    Intent i = new Intent(this, inSideApp.class);
                    i.putExtra("name", "usernameHere");
                    startActivity(i);
                }

            }
        }
    }

    public void createNewA (View view){
        Intent i = new Intent(this, CreateNewAccount.class);
        startActivity(i);
    }

    public void adminPass(View view){
        Intent i = new Intent(this, inSideApp.class);
        i.putExtra("name", "admin");
        startActivity(i);
    }



}