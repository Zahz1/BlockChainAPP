package com.example.blockchainnewyearmlh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CreateNewAccount extends AppCompatActivity {

    private CollectionReference mColRef = FirebaseFirestore.getInstance().collection("appData").document("Passwords").collection("Passwords");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_account);
    }


    public void createAccount(View view){
        EditText u = findViewById(R.id.Username);
        EditText p = findViewById(R.id.Password);
        EditText p2 = findViewById(R.id.Password2);
        if (!u.getText().toString().equals("")){
            if (!p.getText().toString().equals("")){
                if (p.getText().toString().equals(p2.getText().toString())){
                    //send this info to fire base and move to next page
                    Map<String, String> dataToSave = new HashMap<String, String>();
                    dataToSave.put(u.getText().toString(),p.getText().toString());
                    mColRef.document().set(dataToSave).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d("Password","document not saved!");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("Password","document not saved!", e);
                        }
                    });

                    Intent i = new Intent(this, inSideApp.class);
                    i.putExtra("name", u.getText().toString());
                    startActivity(i);
                } else {
                    Toast.makeText(this, "Passwords not the same.", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Passwords empty.", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Username empty.", Toast.LENGTH_SHORT).show();
        }
    }

}