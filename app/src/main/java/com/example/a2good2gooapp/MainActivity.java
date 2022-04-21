package com.example.a2good2gooapp;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.gridlayout.widget.GridLayout;


import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public String[] vegetablesArray = {"Gulderod","Broccoli","Kartoffel","Pore","Kage","Tomat","Squash","Salat","Peberfrugt","Løg","Hvidløg", "Chili", "Champignon","Celleri", "Blomkål"};
    public ArrayList<String> vegetablesList = new ArrayList<String>();
    //ArrayList<String> vegetablesSorted=new ArrayList<String>(); not needed
    int newestListId=1;//if we at some point want to add list updating
    int currentListId=0;
    int n = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MakeTable();

        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
    public void MakeTable() {
        for (String s : vegetablesArray) {
            vegetablesList.add(s);
        }
        Collections.sort(vegetablesList);
        GridLayout gridMaster = findViewById(R.id.gridMaster);
        //GridLayout gridMaster = findViewById(R.id.gridMaster);


        for (String s : vegetablesList) {

            //all of the object creation
            CardView cardView = new CardView(this);
            ImageView imageView = new ImageView(this);
            LinearLayout llIngredient = new LinearLayout(this);

            TextView textView = new TextView(this);
            //gridMaster.setPadding(50,50,50,50);
            LinearLayout llcolumns = new LinearLayout(this);
            llcolumns.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout llrows = new LinearLayout(this);
            llrows.setOrientation(LinearLayout.VERTICAL);

            //image
            imageView.setImageResource(R.drawable.ic_launcher_foreground);

            //making the singular ingredient
            cardView.addView(imageView);
            llIngredient.addView(cardView);
            llIngredient.addView(textView);
            gridMaster.addView(llIngredient);

            llIngredient.setHorizontalGravity(11);
            llIngredient.setGravity(11);
            llIngredient.setOrientation(LinearLayout.VERTICAL);


            //The card only containing the picture of the ingredient.
            cardView.setRadius(20);
            cardView.setPadding(50, 50, 50, 50);
            cardView.getCardBackgroundColor();


            imageView.setPadding(20, 20, 20, 20);

            //ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            //layoutParams.width();
            //imageView.setLayoutParams(layoutParams);


            //The ingredient text
            textView.setPadding(20, 20, 20, 20);
            textView.setGravity(11);
            textView.setText(s);
            //textView.setLayoutParams(params);

            llIngredient.setPadding(20, 20, 20, 20);


            //putting everything in order


            llIngredient.setGravity(11);

        }
    }
}