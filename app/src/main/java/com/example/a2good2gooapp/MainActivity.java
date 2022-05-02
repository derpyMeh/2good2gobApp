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
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};//,'Æ','Ø','Å'
    public String[] vegetablesArray = {"Gulderod","Broccoli","Kartoffel","Pore","Tomat","Squash","Peberfrugt","Løg","Hvidløg", "Chili", "Champignon","Celleri", "Blomkål"};
    int totalIngrediensSelected = 0;
    public ArrayList<String> vegetablesList = new ArrayList<String>();
    public ArrayList<String> ingredientsSelected = new ArrayList<String>();
    //ArrayList<String> vegetablesSorted=new ArrayList<String>(); not needed
    int newestListId=1;//if we at some point want to add list updating
    int currentListId=0;
    int n = 1;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MakeCategoryToolBar();
        MakeTable();


    }
    public void MakeTable() {
        //androidx.gridlayout.widget.GridLayout gridMaster = findViewById(R.id.gridMaster);
        LinearLayout llMaster = findViewById(R.id.llMaster);
        for (String s : vegetablesArray) {
            vegetablesList.add(s);
        }
        Collections.sort(vegetablesList);
        for (String alpha: alphabet) {
            ArrayList<String> currentLetter = new ArrayList<String>();
            for (int i=0; i<vegetablesArray.length-1;i++){
                if (vegetablesArray[i].startsWith(alpha)){
                    currentLetter.add(vegetablesArray[i]);
                }
            }
            if (!currentLetter.isEmpty()){
                TextView letter = new TextView(this);
                letter.setText(alpha);
                llMaster.addView(letter);
                GridLayout letterGrid = new GridLayout(this);
                for (String s : currentLetter) {

                    //all of the object creation
                    CardView cardView = new CardView(this);
                    ImageView ingredientPicture = new ImageView(this);
                    LinearLayout llIngredient = new LinearLayout(this);
                    TextView textView = new TextView(this);
                    //gridMaster.setPadding(50,50,50,50);
                /*
                LinearLayout llcolumns = new LinearLayout(this);
                llcolumns.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout llrows = new LinearLayout(this);
                llrows.setOrientation(LinearLayout.VERTICAL);*/

                    //image
                    String ls = s.toLowerCase(Locale.ROOT);
                    int id = getResources().getIdentifier(ls, "drawable", getPackageName());
                    ingredientPicture.setImageResource(id);
                    GradientDrawable border = new GradientDrawable();
                    border.setColor(0xFFFFFFFF);
                    border.setStroke(15,0xFFFEAD30);
                    ingredientPicture.setBackgroundDrawable(border);


                    llIngredient.setHorizontalGravity(11);
                    llIngredient.setGravity(11);
                    llIngredient.setOrientation(LinearLayout.VERTICAL);

                    ingredientPicture.setClickable(true);
                    ingredientPicture.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Context context = getApplicationContext();
                            if (ingredientsSelected.contains(s)){
                                ingredientsSelected.remove(s);
                                totalIngrediensSelected--;
                                border.setStroke(15,0xFFFEAD30);
                                ingredientPicture.setBackgroundDrawable(border);
                            }
                            else{
                                ingredientsSelected.add(s);
                                totalIngrediensSelected++;
                                border.setStroke(25,0xFFFEAD30);
                                ingredientPicture.setBackgroundDrawable(border);
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
                    cardView.setLayoutParams(new RelativeLayout.LayoutParams(300, 300));
                    ingredientPicture.setPadding(20, 20, 20, 20);

                    //ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    //layoutParams.width();
                    //imageView.setLayoutParams(layoutParams);

                    //The ingredient text
                    textView.setPadding(20, 20, 20, 20);
                    textView.setGravity(11);
                    textView.setText(s);
                    //textView.setLayoutParams(params);

                    llIngredient.setPadding(20, 20, 20, 20);

                    //putting everything together
                    cardView.addView(ingredientPicture);
                    llIngredient.addView(cardView);
                    llIngredient.addView(textView);
                    if (letterGrid.getParent()!=null){
                        ((ViewGroup)letterGrid.getParent()).removeView(letterGrid);
                    }

                    letterGrid.addView(llIngredient);
                    llMaster.addView(letterGrid);
                }
            }
        }
        //Integer[] picture = {R.drawable.blomkl,R.drawable.broccoli,R.drawable.celleri,R.drawable.chili,R.drawable.gulderod,R.drawable.hvidlg,R.drawable.kartoffel,R.drawable.lg,R.drawable.peberfrugt,R.drawable.pore,R.drawable.tomat};
    }
    public void MakeCategoryToolBar(){

    }
}