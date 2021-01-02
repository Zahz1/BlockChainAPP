package com.example.blockchainnewyearmlh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class inSideApp extends AppCompatActivity {
    ArrayList<BlockInfo> blockList = null;
    customBlockList blockAdapter = null;
    ListView blockListView = null;
    String name;
    public Map<String, Object> getData = new HashMap<String, Object>();

    private DocumentReference mDocRef = FirebaseFirestore.getInstance().collection("appData").document("BlockChain");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_side_app);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");

        blockListView = findViewById(R.id.listView);
        blockList = new ArrayList<BlockInfo>();
        blockAdapter = new customBlockList(this, blockList);
        blockListView.setAdapter(blockAdapter);

    }

    public void buttonSendFunction(View view){
        String receiver;
        int amount;

        EditText r = findViewById(R.id.editTextTextPersonName);
        receiver = r.getText().toString();

        EditText n = findViewById(R.id.editTextNumber);
        amount = Integer.parseInt(n.getText().toString());

        BlockInfo curr = new BlockInfo(name,receiver,amount);
        //then add it to the list

        Map<String, BlockInfo> dataToSave = new HashMap<String, BlockInfo>();
        dataToSave.put(name,curr);
        mDocRef.set(dataToSave).addOnSuccessListener(new OnSuccessListener<Void>() {
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

        blockList.add(curr);
        blockAdapter.notifyDataSetChanged();
    }

    public void refreshBlocks(View view){

        mDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    getData =documentSnapshot.getData();
                }
            }
        });
        ArrayList<Object> newList = new ArrayList<Object>(getData.values());
        blockList.clear();
        for (int i = 0; i < newList.size(); i++){
            Map<String, Object> curr = (Map<String, Object>) newList.get(i);
            blockList.add(new BlockInfo((String) curr.get("sender"), (String) curr.get("receiver"), ((Long) curr.get("amount")).intValue()));
        }
        blockAdapter.notifyDataSetChanged();
    }


}