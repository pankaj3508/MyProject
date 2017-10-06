package com.app.apti.activity;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.apti.R;

import java.util.List;

/**
 * Created by pankajjoshi on 6/10/17.
 */

public class CustomDrawerAdapter extends BaseAdapter {


    private Context context;
    public List<DrawerItem> item;
    private static LayoutInflater inflator=null;

    public CustomDrawerAdapter(HomePage homePage, List<DrawerItem> drawerItems) {
        context=homePage;
        item=drawerItems;
        inflator=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Holder holder=new Holder();
        View v=view;
        if(v==null)
        v=inflator.inflate(R.layout.drawer_listview,null);

        TextView tv=(TextView)v.findViewById(R.id.drawer_text);
        ImageView img=(ImageView)v.findViewById(R.id.drawer_image);
        tv.setText(item.get(i).getName());
        img.setImageResource(item.get(i).getImgid());
        return v;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
}
