package com.example.android.escaperoom;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class safe extends AppCompatActivity {

    ArrayList<Integer> auxiliar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<Integer> inventory = args.getIntegerArrayList("ARRAYLIST");
        auxiliar = new ArrayList<>();
        auxiliar = inventory;
        ImageView star = findViewById(R.id.star);
        Button key = findViewById(R.id.key);
        boolean check = auxiliar.contains(8);
        boolean check2 = auxiliar.contains(9);
        if(check){
            Button open_safe = findViewById(R.id.open_safe);
            Button open_code_frame = findViewById(R.id.open_code_frame);
            ImageView safe = findViewById(R.id.safe);
            safe.setImageResource(R.drawable.open_safe);
            open_safe.setVisibility(View.GONE);
            open_code_frame.setVisibility(View.GONE);
            if(!check2){star.setVisibility(View.VISIBLE);
                key.setVisibility(View.VISIBLE);}}
    }

    public void enterCode(View v) {

       RelativeLayout codeMsg = (RelativeLayout)findViewById(R.id.relativeLayoutCodeMesage);
       codeMsg.setVisibility(View.VISIBLE);
    }


    public void openSafe(View v) {

        EditText customerName = (EditText) findViewById(R.id.code);
        String pas =  customerName.getText().toString();
        ImageView safe = findViewById(R.id.safe);
        ImageView star = findViewById(R.id.star);
        Button key = findViewById(R.id.key);


        if(TextUtils.isEmpty(pas)){

            Toast.makeText(getBaseContext(), " ERROR ! WRONG CODE !", Toast.LENGTH_LONG).show();

        } else {
            int customer = Integer.parseInt(pas);

            if (customer == 3942) {

                RelativeLayout codeMsg = (RelativeLayout)findViewById(R.id.relativeLayoutCodeMesage);
                Toast.makeText(getBaseContext(), " Congratulates! the door are open", Toast.LENGTH_LONG).show();
                codeMsg.setVisibility(View.GONE);
                safe.setImageResource(R.drawable.open_safe);
                star.setVisibility(View.VISIBLE);
                key.setVisibility(View.VISIBLE);
                auxiliar.add(8);

            } else {

                Toast.makeText(getBaseContext(), " ERROR ! WRONG CODE !", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void key(View view){
        Button key = findViewById(R.id.key);
        ImageView star = findViewById(R.id.star);
        star.setVisibility(View.GONE);
        key.setVisibility(View.GONE);
        Toast.makeText(getBaseContext(), "Added to the backpack", Toast.LENGTH_LONG).show();
        auxiliar.add(9);

    }


    public void back(View view){
        Intent transferToTheRoom = new Intent(safe.this,escRoom.class);
        Bundle args = new Bundle();
        args.putIntegerArrayList("ARRAYLIST", auxiliar);
        transferToTheRoom.putExtra("BUNDLE",args);
        startActivity(transferToTheRoom);
    }
}
