package com.example.a2good2gooapp;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public String[] vegetablesArray = {"Gulderod","Broccoli","Kartoffel","Pore","Tomat","Squash","Peberfrugt","Løg","Hvidløg", "Chili", "Champignon","Celleri", "Blomkål"};
    int totalIngrediensSelected = 0;
    public ArrayList<String> vegetablesList = new ArrayList<String>();
    public ArrayList<String> ingredientsSelected = new ArrayList<String>();
    //ArrayList<String> vegetablesSorted=new ArrayList<String>(); not needed
    int newestListId=1;//if we at some point want to add list updating
    int currentListId=0;
    int n = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void MakeTable() {

        for (String s : vegetablesArray) {
            vegetablesList.add(s);
        }
        Collections.sort(vegetablesList);
        GridLayout gridMaster = findViewById(R.id.gridMaster);
        //GridLayout gridMaster = findViewById(R.id.gridMaster);
        Integer[] picture = {R.drawable.blomkl,R.drawable.broccoli,R.drawable.celleri,R.drawable.chili,R.drawable.gulderod,R.drawable.hvidlg,R.drawable.kartoffel,R.drawable.lg,R.drawable.peberfrugt,R.drawable.pore,R.drawable.tomat};

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
            imageView.setImageResource(R.drawable.ic_launcher_background);

            GradientDrawable border = new GradientDrawable();
            border.setColor(0xFFFFFFFF);
            border.setStroke(15,0xFFFEAD30);
            imageView.setBackgroundDrawable(border);
            //making the singular ingredient

            llIngredient.addView(cardView);
            llIngredient.addView(textView);
            gridMaster.addView(llIngredient);



            llIngredient.setHorizontalGravity(11);
            llIngredient.setGravity(11);
            llIngredient.setOrientation(LinearLayout.VERTICAL);
            imageView.setClickable(true);
            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = getApplicationContext();
                    if (ingredientsSelected.contains(s)){
                        ingredientsSelected.remove(s);
                        totalIngrediensSelected--;
                        border.setStroke(15,0xFFFEAD30);
                        imageView.setBackgroundDrawable(border);
                    }
                    else{
                        ingredientsSelected.add(s);
                        totalIngrediensSelected++;
                        border.setStroke(25,0xFFFEAD30);
                        imageView.setBackgroundDrawable(border);
                    }
                    CharSequence selected = s;
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, selected, duration);
                    toast.show();
                }
            });

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

            cardView.addView(imageView);
            llIngredient.setGravity(11);

        }
    }
}