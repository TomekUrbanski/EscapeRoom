package com.example.android.escaperoom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class inventory extends AppCompatActivity {

    ArrayList<Integer> auxiliar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<Integer> inventory = args.getIntegerArrayList("ARRAYLIST");
        auxiliar = new ArrayList<>();
        auxiliar = inventory;

        ImageView first_peace = findViewById(R.id.first_peace);
        ImageView second_peace = findViewById(R.id.second_peace);
        ImageView formula = findViewById(R.id.formula);
        ImageView keys = findViewById(R.id.keys);
        ImageView key = findViewById(R.id.key);

        if(auxiliar.contains(1)){first_peace.setVisibility(View.VISIBLE);}
        if(auxiliar.contains(2)){second_peace.setVisibility(View.VISIBLE);}
        if(auxiliar.contains(7)){formula.setVisibility(View.VISIBLE);}
        if(auxiliar.contains(5)){keys.setVisibility(View.VISIBLE);}
        if(auxiliar.contains(9)){key.setVisibility(View.VISIBLE);}

    }

    public void back(View view) {
        Intent transferToTheRoom = new Intent(inventory.this, escRoom.class);
        Bundle args = new Bundle();
        args.putIntegerArrayList("ARRAYLIST", auxiliar);
        transferToTheRoom.putExtra("BUNDLE",args);
        startActivity(transferToTheRoom);
    }
}
