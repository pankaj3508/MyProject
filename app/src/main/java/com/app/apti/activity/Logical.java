package com.app.apti.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.app.apti.R;

/**
 * Created by pankajjoshi on 9/10/17.
 */

public class Logical extends Fragment {


    LinearLayout formula,problem,tricks,test;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        View v=inflater.inflate(R.layout.logical_category,container,false);
        formula=(LinearLayout)v.findViewById(R.id.formula_logical);
        problem=(LinearLayout)v.findViewById(R.id.problems_logical);
        tricks=(LinearLayout)v.findViewById(R.id.tricks_logical);
        test=(LinearLayout)v.findViewById(R.id.test_logical);

        formula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f=new Topic();
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.frame,f);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f=new Topic();
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.frame,f);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        tricks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f=new Topic();
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.frame,f);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f=new Topic();
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.frame,f);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return v;
    }
}
