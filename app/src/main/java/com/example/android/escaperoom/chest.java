package com.example.android.escaperoom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class chest extends AppCompatActivity {

    RadioGroup radioGroup;
    int checked;
    ArrayList<Integer> auxiliar;
    boolean checker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);

        ImageView closedChest = findViewById(R.id.chest_in_use);
        final Button formula = findViewById(R.id.formula);
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<Integer> inventory = args.getIntegerArrayList("ARRAYLIST");
        auxiliar = new ArrayList<>();
        auxiliar = inventory;
        if(auxiliar.contains(6)){
            closedChest.setImageResource(R.drawable.open_chest);
            formula.setVisibility(View.GONE);}

        radioGroup = findViewById(R.id.keys);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ImageView closedChest = findViewById(R.id.chest_in_use);
                TextView text = findViewById(R.id.keys_msg);
                String dis_text;
                checker = auxiliar.contains(6);
                checked = radioGroup.indexOfChild(findViewById(checkedId));

                switch (checked){
                    case 0:

                        if (!checker) {
                            dis_text = "ehh dont feet...";
                            text.setText(dis_text);
                        }else {
                            Toast.makeText(getBaseContext(), " You alredy found the right key", Toast.LENGTH_LONG).show();
                        }

                        break;
                    case 1:
                        if (!checker) {
                        dis_text = "NO ...";
                        text.setText(dis_text);
                        }else {
                            Toast.makeText(getBaseContext(), " You alredy found the right key", Toast.LENGTH_LONG).show();
                        }

                        break;
                    case 2:
                        if(!checker){
                            dis_text = "Yey !";
                            text.setText(dis_text);
                            closedChest.setImageResource(R.drawable.open_chest);
                            formula.setVisibility(View.VISIBLE);
                            auxiliar.add(6);}
                        else{
                            dis_text = "You've already taken the key";
                            text.setText(dis_text);
                        }


                        break;
                    case 3:
                        if (!checker) {
                        dis_text = "too big ...";
                        text.setText(dis_text);
                        }else {
                            Toast.makeText(getBaseContext(), " You alredy found the right key", Toast.LENGTH_LONG).show();
                        }

                        break;
                    case 4:
                        if (!checker) {
                        dis_text = "nooooo ...";
                        text.setText(dis_text);
                        }else {
                            Toast.makeText(getBaseContext(), " You alredy found the right key", Toast.LENGTH_LONG).show();
                        }

                        break;
                }

            }
        });

    }
    public void formula(View view){
        Button formula = findViewById(R.id.formula);
        formula.setVisibility(View.INVISIBLE);
        auxiliar.add(7);
        Toast.makeText(getBaseContext(), "Added to the backpack", Toast.LENGTH_LONG).show();

    }

    public void back(View view) {
        Intent transferToTheRoom = new Intent(chest.this, escRoom.class);
        Bundle args = new Bundle();
        args.putIntegerArrayList("ARRAYLIST", auxiliar);
        transferToTheRoom.putExtra("BUNDLE",args);
        startActivity(transferToTheRoom);
    }
}
