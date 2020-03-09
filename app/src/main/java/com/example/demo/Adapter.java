package com.example.demo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<MyViewHolder> {


    Context context;

    ArrayList<String> name,roll;
    ArrayList<String> id;

    public Adapter(Context context, ArrayList<String> name, ArrayList<String> roll, ArrayList<String> id) {
        this.context= context;
        this.name = name;
        this.roll = roll;
        this.id=id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.show_datalayout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.nameTExtView.setText(name.get(position));
        holder.rollTextView.setText(roll.get(position));



        holder.delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                // Alert Dialog Box
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setCancelable(false);
                builder.setIcon(R.drawable.ic_delete);
                builder.setTitle("Confirmation Delete");
                builder.setMessage("Are you sure deleted ");


                final AlertDialog alertDialog = builder.create();
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {



                        // delete item
                        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
                        dataBaseHelper.getWritableDatabase();
                        int status =dataBaseHelper.deleteData(id.get(position));

                        Toast.makeText(context, "" + id.get(position)+" ID Deleted", Toast.LENGTH_SHORT).show();

                        alertDialog.dismiss();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });
                builder.show();


            }
        });

    }

    @Override
    public int getItemCount() {
        return name.size();
    }
}
