package com.example.blockchainnewyearmlh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class inSideApp extends AppCompatActivity {
    ArrayList<BlockInfo> blockList = null;
    customBlockList blockAdapter = null;
    ListView blockListView = null;
    String name;

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
        blockList.add(curr);
        blockAdapter.notifyDataSetChanged();
    }


}