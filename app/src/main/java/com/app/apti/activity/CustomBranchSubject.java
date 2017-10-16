package com.app.apti.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.app.apti.R;

/**
 * Created by pankajjoshi on 14/10/17.
 */

public class CustomBranchSubject extends BaseAdapter {

    private Context context;
    String []title;
    private static LayoutInflater inflater=null;
    public CustomBranchSubject(Activity topic, String[] topicnames) {
        context=topic;
        title=topicnames;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return title.length;
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
        View v=view;
        if(v==null)
            v=inflater.inflate(R.layout.subjects_list,null);
        LinearLayout color=(LinearLayout)v.findViewById(R.id.colorchange);
       /* if((i&1)==1)
        {
            color.setBackgroundColor(Color.parseColor("#A7C6C6"));
        }
        else
            color.setBackgroundColor(Color.parseColor("#C9D7DA"));*/
        TextView tv=(TextView)v.findViewById(R.id.topiclist_text);
        tv.setText(title[i]);
        return v;
    }
}
