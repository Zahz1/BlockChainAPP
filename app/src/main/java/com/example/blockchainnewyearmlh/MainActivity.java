package com.example.blockchainnewyearmlh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private DocumentReference mDocRef = FirebaseFirestore.getInstance().collection("appData").document("Passwords");
    public Map<String, String> getData = new HashMap<String, String>();
    List<Map<String, String>> mArrayList;

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

                final boolean[] found = {false};

                mDocRef.collection("Passwords").whereEqualTo(u.getText().toString(),p.getText().toString()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            found[0] = true;
                        } else {
                            return;
                        }
                    }
                });

                if (found[0]){
                    Intent i = new Intent(this, inSideApp.class);
                    i.putExtra("name", "usernameHere");
                    startActivity(i);
                } else {
                    Toast.makeText(this, "wrong info", Toast.LENGTH_SHORT).show();
                }


              //  if (().equals(p.getText().toString()) ){
              //      Intent i = new Intent(this, inSideApp.class);
              //      i.putExtra("name", "usernameHere");
              //      startActivity(i);
              //  };

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