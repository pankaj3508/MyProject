package com.app.apti.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.apti.R;
/**
 * Created by pankajjoshi on 9/10/17.
 */

public class CustomTopicAdapter extends BaseAdapter {

    private Context context;
    String []title;
    TypedArray img;
    private static LayoutInflater inflater=null;

    public CustomTopicAdapter(Activity topic, String[] topicnames,TypedArray images) {
        context=topic;
        title=topicnames;
        img=images;
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
            v=inflater.inflate(R.layout.topic_list,null);

        TextView tv=(TextView)v.findViewById(R.id.topiclist_text);
        ImageView im=(ImageView)v.findViewById(R.id.topiclist_image);
        tv.setText(title[i]);
       im.setImageResource(img.getResourceId(i,-1));
        return v;
    }
}
