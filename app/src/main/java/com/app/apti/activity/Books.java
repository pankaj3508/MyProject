package com.app.apti.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.apti.R;

/**
 * Created by pankajjoshi on 13/10/17.
 */

public class Books extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        Bundle b=getArguments();
        String s=b.getString("book").toString();
        View v=null;
        if(s.equals("aptitude"))
            v=inflater.inflate(R.layout.books,container,false);
        else if(s.equals("logical"))
            v=inflater.inflate(R.layout.books2,container,false);

        return v;
    }
}
