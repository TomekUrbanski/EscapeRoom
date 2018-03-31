package com.example.android.escaperoom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class free extends AppCompatActivity {

    ArrayList<Integer> auxiliar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<Integer> inventory = args.getIntegerArrayList("ARRAYLIST");
        auxiliar = new ArrayList<>();
        auxiliar = inventory;
    }

    public void inventory (View view){
        Intent transferToInventory = new Intent(free.this, inventory.class);
        Bundle args = new Bundle();
        args.putIntegerArrayList("ARRAYLIST", auxiliar);
        transferToInventory.putExtra("BUNDLE", args);
        startActivity(transferToInventory);
    }
}
