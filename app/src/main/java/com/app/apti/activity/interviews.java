package com.app.apti.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.app.apti.R;

/**
 * Created by pankajjoshi on 12/10/17.
 */

public class interviews extends Fragment {
    LinearLayout hr,cs,mba,company,govt,extra;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.interviews,container,false);
        hr=(LinearLayout)v.findViewById(R.id.hr);
        cs=(LinearLayout)v.findViewById(R.id.software);
        mba=(LinearLayout)v.findViewById(R.id.mba);
        company=(LinearLayout)v.findViewById(R.id.company);
        govt=(LinearLayout)v.findViewById(R.id.govt);
        extra=(LinearLayout)v.findViewById(R.id.extra);
        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b=new Bundle();
                b.putString("interview_topic","cs");
                Fragment f=new interview_topic();
                f.setArguments(b);
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame,f);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });

        hr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b=new Bundle();
                b.putString("interview_topic","hr");
                Fragment f=new interview_topic();
                f.setArguments(b);
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame,f);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });

        govt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b=new Bundle();
                b.putString("interview_topic","govt");
                Fragment f=new interview_topic();
                f.setArguments(b);
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame,f);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });

        company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b=new Bundle();
                b.putString("interview_topic","company");
                Fragment f=new interview_topic();
                f.setArguments(b);
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame,f);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });

        return v;
    }
}
