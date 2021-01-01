package com.example.blockchainnewyearmlh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class customBlockList extends ArrayAdapter<BlockInfo> {
    public customBlockList(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.block_layout, parent, false);

        BlockInfo currBlock = getItem(position);

        TextView index = listItemView.findViewById(R.id.positionNum);
        index.setText(position);

        String infoString = currBlock.getSender().concat(" gave ").concat(currBlock.getReceiver()).concat(" ").concat(String.valueOf(currBlock.getAmount()));

        TextView info = listItemView.findViewById(R.id.BlockInfo);
        info.setText(infoString);

        return listItemView;
    }
}
