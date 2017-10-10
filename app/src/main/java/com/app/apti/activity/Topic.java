package com.app.apti.activity;


import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.app.apti.R;

/**
 * Created by pankajjoshi on 9/10/17.
 */

public class Topic extends Fragment {
    private ListView topiclist;
    private String []topicnames;
    private TypedArray imagenames;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        View v=inflater.inflate(R.layout.topic,container,false);
         String category=((AppCompatActivity)getActivity()).getSupportActionBar().getTitle().toString();
        if(category.equals("Aptitude")) {
            topicnames = getResources().getStringArray(R.array.aptitude);
            imagenames=getResources().obtainTypedArray(R.array.aptitude_img);
        }
        else if(category.equals("Logical Reasoning")) {
            topicnames = getResources().getStringArray(R.array.Logical);
            imagenames=getResources().obtainTypedArray(R.array.logical_img);
        }
        else if(category.equals("Verbal"))
        {
            topicnames=getResources().getStringArray(R.array.verbal);
            imagenames=getResources().obtainTypedArray(R.array.verbal_img);
        }

        for(int i=0;i<topicnames.length;i++)
        {
            topicnames[i]=topicnames[i].toUpperCase();

        }
        topiclist=(ListView)v.findViewById(R.id.topiclist);
        topiclist.setAdapter(new CustomTopicAdapter(getActivity(),topicnames,imagenames));
        return v;
    }
}
