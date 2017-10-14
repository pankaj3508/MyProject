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
 * Created by pankajjoshi on 14/10/17.
 */

public class Engineering_book extends Fragment{

    LinearLayout csit,civil,electrical,electronics,mechanical,chemical,bio,intrument;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        View v=inflater.inflate(R.layout.engineering_books,container,false);
        csit=(LinearLayout)v.findViewById(R.id.csit);
        civil=(LinearLayout)v.findViewById(R.id.civil);
        electrical=(LinearLayout)v.findViewById(R.id.electrical);
        electronics=(LinearLayout)v.findViewById(R.id.electronics);
        mechanical=(LinearLayout)v.findViewById(R.id.mechanical);
        chemical=(LinearLayout)v.findViewById(R.id.chemical);
        bio=(LinearLayout)v.findViewById(R.id.biotech);
        intrument=(LinearLayout)v.findViewById(R.id.instrument);

        csit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f=new EngineeringBranch();
                Bundle b=new Bundle();
                b.putString("engineering","CS/IT");
                f.setArguments(b);
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.frame,f);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        civil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f=new EngineeringBranch();
                Bundle b=new Bundle();
                b.putString("engineering","CIVIL");
                f.setArguments(b);
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.frame,f);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        electrical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f=new EngineeringBranch();
                Bundle b=new Bundle();
                b.putString("engineering","ELECTRICAL");
                f.setArguments(b);
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.frame,f);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        electronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f=new EngineeringBranch();
                Bundle b=new Bundle();
                b.putString("engineering","ELECTRONICS");
                f.setArguments(b);
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.frame,f);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        mechanical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f=new EngineeringBranch();
                Bundle b=new Bundle();
                b.putString("engineering","MECHANICAL");
                f.setArguments(b);
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.frame,f);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        chemical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f=new EngineeringBranch();
                Bundle b=new Bundle();
                b.putString("engineering","CHEMICAL");
                f.setArguments(b);
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.frame,f);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        bio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f=new EngineeringBranch();
                Bundle b=new Bundle();
                b.putString("engineering","BIO TECHNOLOGY");
                f.setArguments(b);
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.frame,f);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        intrument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f=new EngineeringBranch();
                Bundle b=new Bundle();
                b.putString("engineering","INSTRUMENTATION");
                f.setArguments(b);
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
