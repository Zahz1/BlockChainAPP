package com.example.blockchainnewyearmlh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<BlockInfo> blockList = null;
    customBlockList blockAdapter = null;
    ListView blockListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blockListView = findViewById(R.id.listView);
        blockList = new ArrayList<BlockInfo>();
        blockAdapter = new customBlockList(this, blockList);
        blockListView.setAdapter(blockAdapter);

    }

    public void buttonSendFunction(View view){
        String sender, receiver;
        int amount;

        EditText s = findViewById(R.id.editTextTextUserName);
        sender = s.getText().toString();

        EditText r = findViewById(R.id.editTextTextPersonName);
        receiver = r.getText().toString();

        EditText n = findViewById(R.id.editTextNumber);
        amount = Integer.parseInt(n.getText().toString());

        BlockInfo curr = new BlockInfo(sender,receiver,amount);
        //then add it to the list
        blockList.add(curr);
        blockAdapter.notifyDataSetChanged();
    }


}