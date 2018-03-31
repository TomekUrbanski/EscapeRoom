package com.example.android.escaperoom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class bookstand extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    RadioGroup radioGroup;
    String dis_text;
    ArrayList<Integer> auxiliar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookstand);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<Integer> inventory = args.getIntegerArrayList("ARRAYLIST");
        auxiliar = new ArrayList<>();
        auxiliar = inventory;
        if(auxiliar.contains(5)){
            Button key = findViewById(R.id.key);
            key.setVisibility(View.GONE);}

    }

    public void popupBookKey(View view) {

        PopupMenu menu = new PopupMenu(this, view);
        menu.setOnMenuItemClickListener(bookstand.this);
        menu.inflate(R.menu.book_key);
        menu.show();
    }

    public void readBook(View v) {
        TextView text = findViewById(R.id.book_description);

        ImageView book = findViewById(R.id.book);
        ImageView secret_book = findViewById(R.id.secretBook);
        Button key = findViewById(R.id.key);

        //Separate radioButtons
        RadioButton rb1 = findViewById(R.id.rb1);
        RadioButton rb2 = findViewById(R.id.rb2);
        RadioButton rb3 = findViewById(R.id.rb3);
        RadioButton rb4 = findViewById(R.id.rb4);
        RadioButton rb5 = findViewById(R.id.rb5);
        RadioButton rb6 = findViewById(R.id.rb6);
        RadioButton rb7 = findViewById(R.id.rb7);
        RadioButton rb8 = findViewById(R.id.rb8);
        RadioButton rb9 = findViewById(R.id.rb9);

        if (rb1.isChecked()) {
            key.setVisibility(View.INVISIBLE);
            secret_book.setVisibility(View.INVISIBLE);
            book.setVisibility(View.VISIBLE);
            dis_text = "Not enough pictures ...";
            text.setText(dis_text);


        } else if (rb2.isChecked()) {
            key.setVisibility(View.INVISIBLE);
            secret_book.setVisibility(View.INVISIBLE);
            book.setVisibility(View.VISIBLE);
            dis_text = "hmmm ...too small letters...";
            text.setText(dis_text);

        } else if (rb3.isChecked()) {
            key.setVisibility(View.INVISIBLE);
            secret_book.setVisibility(View.INVISIBLE);
            book.setVisibility(View.VISIBLE);
            dis_text = "I have a more interesting occupation";
            text.setText(dis_text);

        } else if (rb4.isChecked()) {
            key.setVisibility(View.INVISIBLE);
            secret_book.setVisibility(View.INVISIBLE);
            book.setVisibility(View.VISIBLE);
            dis_text = "A banal plot ... ";
            text.setText(dis_text);

        } else if (rb5.isChecked()) {
            key.setVisibility(View.INVISIBLE);
            secret_book.setVisibility(View.INVISIBLE);
            book.setVisibility(View.VISIBLE);
            dis_text = "I will not waste time...";
            text.setText(dis_text);

        } else if (rb6.isChecked()) {
            secret_book.setVisibility(View.VISIBLE);
            if(auxiliar.contains(5)){
            }else{key.setVisibility(View.VISIBLE);}
            dis_text = "Knowledge is useful !";
            text.setText(dis_text);

        } else if (rb7.isChecked()) {
            key.setVisibility(View.INVISIBLE);
            secret_book.setVisibility(View.INVISIBLE);
            book.setVisibility(View.VISIBLE);
            dis_text = "I read it at school";
            text.setText(dis_text);

        } else if (rb8.isChecked()) {
            key.setVisibility(View.INVISIBLE);
            secret_book.setVisibility(View.INVISIBLE);
            book.setVisibility(View.VISIBLE);
            dis_text = "eee... too heavy...";
            text.setText(dis_text);

        } else if (rb9.isChecked()) {
            key.setVisibility(View.INVISIBLE);
            secret_book.setVisibility(View.INVISIBLE);
            book.setVisibility(View.VISIBLE);
            dis_text = "... cover does not impress !";
            text.setText(dis_text);
        }


    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.colectBookKey:
                Button key = findViewById(R.id.key);
                key.setVisibility(View.GONE);
                auxiliar.add(5);

                return true;

            default:
                return false;
        }

    }

    public void back(View view) {
        TextView text = findViewById(R.id.book_description);
        ImageView book = findViewById(R.id.book);
        ImageView secret_book = findViewById(R.id.secretBook);
        Button key = findViewById(R.id.key);
        radioGroup = (RadioGroup) findViewById(R.id.bookList);
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Intent transferToTheRoom = new Intent(bookstand.this, escRoom.class);
            Bundle args = new Bundle();
            args.putIntegerArrayList("ARRAYLIST", auxiliar);
            transferToTheRoom.putExtra("BUNDLE",args);
            startActivity(transferToTheRoom);

        } else {
            key.setVisibility(View.INVISIBLE);
            secret_book.setVisibility(View.INVISIBLE);
            book.setVisibility(View.INVISIBLE);
            radioGroup.clearCheck();
            dis_text = "";
            text.setText(dis_text);

        }
    }
}
