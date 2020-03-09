package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameEdit,rollEdit;
    Button submit_btn,show_btn;

    String name,roll;
    DataBaseHelper dataBaseHelper;

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

        nameEdit = (EditText) findViewById(R.id.editName_ID);
        rollEdit = (EditText) findViewById(R.id.Roll_ID);
        submit_btn = (Button) findViewById(R.id.button_Id);
        show_btn = (Button) findViewById(R.id.showDAta_ID);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (nameEdit.length()<=0 | nameEdit==null){

                    nameEdit.setError("Enter your Name");
                }
                else if (rollEdit.length()<=0 | rollEdit==null){
                    rollEdit.setError("Enter a Roll");
                }
                else {



                    roll = rollEdit.getText().toString();
                    name = nameEdit.getText().toString();
                    dataBaseHelper.getWritableDatabase();

                    long id =dataBaseHelper.insertData(new Student(name,roll));
                    Toast.makeText(MainActivity.this, String.valueOf(id), Toast.LENGTH_SHORT).show();

                }

            }
        });

        show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,DisplayData.class);
                startActivity(intent);
            }
        });



    }

    // BreackPress Item
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}
