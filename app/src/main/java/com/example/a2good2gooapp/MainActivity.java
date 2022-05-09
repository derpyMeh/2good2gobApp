package com.example.a2good2gooapp;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.gridlayout.widget.GridLayout;


import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public String[] vegetablesArray = {"Gulderod", "Broccoli", "Kartoffel", "Pore", "Kage", "Tomat", "Squash", "Salat", "Peberfrugt", "Løg", "Hvidløg", "Chili", "Champignon", "Celleri", "Blomkål"};
    public ArrayList<String> vegetablesList = new ArrayList<String>();
    //ArrayList<String> vegetablesSorted=new ArrayList<String>(); not needed
    int newestListId = 1;//if we at some point want to add list updating
    int currentListId = 0;
    int n = 1;

    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.profilebar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "That just happened", Snackbar.LENGTH_LONG).setAction("Action", null).show();


            }
        });

        expandableListView = findViewById(R.id.expandableListView);
        prepareMenuData();
        populateExpandableList();


        MakeTable();
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_Favorit_Ret) {

        } else if (id == R.id.nav_fravalgte_ingredienser) {

        } else if (id == R.id.nav_diæt) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    private void prepareMenuData() {
        MenuModel menuModel = new MenuModel("Favorit Retter", true, true, false);
        headerList.add(menuModel);

        List<MenuModel> childModelList = new ArrayList<>();
        MenuModel childModel = new MenuModel("Ting 1", false, false, true);
        childModelList.add(childModel);
        childModel = new MenuModel("Ting 2", false, false, true);
        childModelList.add(childModel);
        childModel = new MenuModel("Ting 3", false, false, true);
        childModelList.add(childModel);
        childModel = new MenuModel("Ting 4", false, false, true);
        childModelList.add(childModel);



        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelList);

        }
        childModelList = new ArrayList<>();
        menuModel = new MenuModel("Fravalgte Ingredienser", true, true, false);
        headerList.add(menuModel);

        childModel = new MenuModel("Ting 1", false, false, true);
        childModelList.add(childModel);
        childModel = new MenuModel("Ting 2", false, false, true);
        childModelList.add(childModel);
        childModel = new MenuModel("Ting 3", false, false, true);
        childModelList.add(childModel);
        childModel = new MenuModel("Ting 4", false, false, true);
        childModelList.add(childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelList);

        }

        childModelList = new ArrayList<>();
        menuModel = new MenuModel("Diæt", true, true, false);
        headerList.add(menuModel);

        childModel = new MenuModel("Vegetar", false, false, true);
        childModelList.add(childModel);
        childModel = new MenuModel("Veganer", false, false, true);
        childModelList.add(childModel);
        childModel = new MenuModel("Spiser Kød", false, false, true);
        childModelList.add(childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelList);
        }

    }

    private void populateExpandableList() {
        expandableListAdapter = new com.example.a2good2gooapp.ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPos, long id) {
                return false;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPos, int childPos, long id) {
                if (childList.get(headerList.get(groupPos)) != null) {
                    MenuModel model = childList.get(headerList.get(groupPos)).get(childPos);
                    if (model.isSelectable) {
                        model.isSelectable = false;
                        Toast.makeText(getApplicationContext(),"Button is now"+model.isSelectable,Toast.LENGTH_SHORT).show();
                    } else {
                        model.isSelectable = true;
                        Toast.makeText(getApplicationContext(),"Button is now"+model.isSelectable,Toast.LENGTH_SHORT).show();

                    }
                }
                return false;
            }
        });
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