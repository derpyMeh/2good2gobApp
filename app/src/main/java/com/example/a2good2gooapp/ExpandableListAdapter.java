package com.example.a2good2gooapp;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<MenuModel> listDataHeader;
    private HashMap<MenuModel, List<MenuModel>> listDataChild;

    public ExpandableListAdapter(Context context, List<MenuModel> listDataHeader, HashMap<MenuModel, List<MenuModel>> listChildData) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listChildData;
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPos) {
        if (this.listDataChild.get(this.listDataHeader.get(groupPos)) == null) {
            return 0;
        }else{
            return this.listDataChild.get(this.listDataHeader.get(groupPos)).size();
        }
    }

    @Override
    public MenuModel getGroup(int groupPos) {
return this.listDataHeader.get(groupPos);

    }

    @Override
    public MenuModel getChild(int groupPos, int childPos) {
        return this.listDataChild.get(this.listDataHeader.get(groupPos)).get(childPos);
    }

    @Override
    public long getGroupId(int groupPos) {
        return groupPos;
    }

    @Override
    public long getChildId(int groupPos, int childPos) {
        return childPos;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPos, boolean isExpanded, View convertView, ViewGroup viewGroup) {
        String headerTitle = getGroup(groupPos).menuName;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_header,null);
        }
        TextView labelListHeader = convertView.findViewById(R.id.labelListHead);
        labelListHeader.setTypeface(null, Typeface.BOLD);
        labelListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPos, int childPos, boolean isLastChild, View convertView, ViewGroup viewGroup) {

        final String childText = getChild(groupPos, childPos).menuName;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_children, null);
        }
        TextView txtListChild = convertView.findViewById(R.id.labelListItem);
        txtListChild.setText(childText);
        return convertView;

    }

    @Override
    public boolean isChildSelectable(int groupPos, int childPos) {
        return true;
    }
}
