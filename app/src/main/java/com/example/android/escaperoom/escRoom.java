package com.example.android.escaperoom;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class escRoom extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    ArrayList<Integer> invetory;
    int check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esc_room);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<Integer> auxiliar = args.getIntegerArrayList("ARRAYLIST");
        invetory = new ArrayList<>();
        invetory = auxiliar;
        Button chest = findViewById(R.id.chest);
        Button paint = findViewById(R.id.paint);
        Button safe = findViewById(R.id.safe);
        ImageView takenPaint = findViewById(R.id.takenPaint);

        if (invetory.contains(6))
        {chest.setBackgroundResource(R.drawable.open_chest);}
        if (invetory.contains(8))
        {safe.setBackgroundResource(R.drawable.open_safe);}
        if (invetory.contains(10))
        {   check=1;
            takenPaint.setVisibility(View.VISIBLE);
            paint.setVisibility(View.GONE);}
    }

    public void inventory (View view){
        Intent transferToInventory = new Intent(escRoom.this, inventory.class);
        Bundle args = new Bundle();
        args.putIntegerArrayList("ARRAYLIST", invetory);
        transferToInventory.putExtra("BUNDLE", args);
        startActivity(transferToInventory);
    }

    public void moveToSafe (View view){
        Intent transferToSafe = new Intent(escRoom.this, safe.class);
        Bundle args = new Bundle();
        args.putIntegerArrayList("ARRAYLIST", invetory);
        transferToSafe.putExtra("BUNDLE", args);
        startActivity(transferToSafe);
    }

    public void popupBookstand(View view) {

        PopupMenu menu = new PopupMenu(this, view);
        menu.setOnMenuItemClickListener(escRoom.this);
        menu.inflate(R.menu.book_stand);
        menu.show();
    }

    public void popupChest(View view) {

        PopupMenu menuChest = new PopupMenu(this, view);
        menuChest.setOnMenuItemClickListener(escRoom.this);
        menuChest.inflate(R.menu.chest);
        menuChest.show();
    }

    public void popupDoor(View view) {

        PopupMenu menu = new PopupMenu(this, view);
        menu.setOnMenuItemClickListener(escRoom.this);
        menu.inflate(R.menu.door_lock);
        menu.show();
    }

    public void popupJacket(View view) {

        PopupMenu menu = new PopupMenu(this, view);
        menu.setOnMenuItemClickListener(escRoom.this);
        menu.inflate(R.menu.jacket);
        menu.show();
    }

    public void popupPaint(View view) {

        PopupMenu menu = new PopupMenu(this, view);
        menu.setOnMenuItemClickListener(escRoom.this);
        menu.inflate(R.menu.paint);
        if(check==1){
            menu.getMenu().findItem(R.id.removePaint).setVisible(true);
            menu.getMenu().findItem(R.id.correctPaint).setVisible(false);
        }
        menu.show();
    }

    public void popupSofa(View view) {

        PopupMenu menu = new PopupMenu(this, view);
        menu.setOnMenuItemClickListener(escRoom.this);
        menu.inflate(R.menu.sofa);
        menu.show();
    }

    public void popupTrashCan(View view) {

        PopupMenu menu = new PopupMenu(this, view);
        menu.setOnMenuItemClickListener(escRoom.this);
        menu.inflate(R.menu.trash_can);
        menu.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.searchJacket:
                if(invetory.contains(2)){
                    Toast.makeText(getBaseContext(), "...another piece with strange characters!", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getBaseContext(), "I found a piece of paper with strange characters!", Toast.LENGTH_LONG).show();}
                invetory.add(1);
                return true;

            case R.id.searchTrashCan:
                if(invetory.contains(1)){
                    Toast.makeText(getBaseContext(), "...another piece with strange characters!", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getBaseContext(), "I found a piece of paper with strange characters!", Toast.LENGTH_LONG).show();}
                invetory.add(2);
                return true;

            case R.id.searchBookstand:

                Intent transferToTheBookstand = new Intent(escRoom.this, bookstand.class);
                Bundle args1 = new Bundle();
                args1.putIntegerArrayList("ARRAYLIST", invetory);
                transferToTheBookstand.putExtra("BUNDLE", args1);
                startActivity(transferToTheBookstand);

                return true;

            case R.id.openChest:

                if (invetory.contains(5)) {
                    Intent transferToTheChest = new Intent(escRoom.this, chest.class);
                    Bundle args = new Bundle();
                    args.putIntegerArrayList("ARRAYLIST", invetory);
                    transferToTheChest.putExtra("BUNDLE", args);
                    startActivity(transferToTheChest);
                } else {
                    Toast.makeText(getBaseContext(), " I don`t have any key`s ...", Toast.LENGTH_SHORT).show();
                }
                return true;

            case R.id.watchPaint:

                Toast.makeText(getBaseContext(), " Great color palette  !", Toast.LENGTH_SHORT).show();

                return true;
            case R.id.correctPaint:
                if (check != 1) {
                    Toast.makeText(getBaseContext(), " I CAN`T ! Something seems to block him", Toast.LENGTH_SHORT).show();
                    check = 1;
                    invetory.add(10);
                }

                return true;

            case R.id.removePaint:
                Button paint = findViewById(R.id.paint);
                ImageView takenPaint = findViewById(R.id.takenPaint);
                takenPaint.setVisibility(View.VISIBLE);
                paint.setVisibility(View.GONE);
                invetory.add(4);

                return true;

            case R.id.openDoor:
                if (invetory.contains(9)) {
                    Toast.makeText(getBaseContext(), "You are FREE", Toast.LENGTH_SHORT).show();
                    Intent transferToSafe = new Intent(escRoom.this, free.class);
                    Bundle args2 = new Bundle();
                    args2.putIntegerArrayList("ARRAYLIST", invetory);
                    transferToSafe.putExtra("BUNDLE", args2);
                    startActivity(transferToSafe);
                }else {
                    Toast.makeText(getBaseContext(), "It would be too simple", Toast.LENGTH_SHORT).show();
                }

                return true;

            default:
                return false;
        }
    }


}
