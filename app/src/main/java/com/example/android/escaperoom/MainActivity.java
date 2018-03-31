package com.example.android.escaperoom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> auxiliar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moveOn(View view){

        RadioButton rb1 = findViewById(R.id.radioButton1);
        RadioButton rb2 = findViewById(R.id.radioButton2);
        auxiliar = new ArrayList<>(10);
        auxiliar.add(0);

       if(rb1.isChecked()){
            Intent transferToTheRoom = new Intent(MainActivity.this,escRoom.class);
           Bundle args = new Bundle();
           args.putIntegerArrayList("ARRAYLIST", auxiliar);
           transferToTheRoom.putExtra("BUNDLE",args);
           startActivity(transferToTheRoom);

        }else if(rb2.isChecked()){
            finish();
            System.exit(0);

        }else {
            Toast.makeText(getBaseContext(), "Please mark the answer", Toast.LENGTH_LONG).show();

        }

    }
}
