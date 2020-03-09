package com.example.demo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyViewHolder extends RecyclerView.ViewHolder {

    TextView nameTExtView,rollTextView;

    ImageView editText_btn, delete_btn;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTExtView = itemView.findViewById(R.id.textName);
        rollTextView = itemView.findViewById(R.id.texRoll);
        editText_btn = itemView.findViewById(R.id.Edit_id);
        delete_btn = itemView.findViewById(R.id.deleted_id);

    }
}
