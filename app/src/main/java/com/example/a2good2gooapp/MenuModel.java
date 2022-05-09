package com.example.a2good2gooapp;

public class MenuModel {

    public String menuName;
    public boolean hasChildren, isGroup, isSelectable;

    public MenuModel(String menuName, boolean isGroup, boolean hasChildren, boolean isSelectable) {

        this.menuName = menuName;
        this.isSelectable = isSelectable;
        this.isGroup = isGroup;
        this.hasChildren = hasChildren;

    }

}
