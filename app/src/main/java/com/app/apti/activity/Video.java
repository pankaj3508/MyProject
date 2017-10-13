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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.apti.R;

/**
 * Created by pankajjoshi on 12/10/17.
 */

public class Video extends Fragment {

  ImageView iv;
    TextView tv;
    LinearLayout logical,quant;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.video,container,false);
        String title=((AppCompatActivity) getActivity()).getSupportActionBar().getTitle().toString();
        iv=(ImageView)v.findViewById(R.id.title_image);
       tv=(TextView)v.findViewById(R.id.title_topic);
        if(title.equals("Books"))
        {
            iv.setImageResource(R.drawable.books);
            tv.setText("Books");
        }else if(title.equals("Video"))
        { iv.setImageResource(R.drawable.video);
            tv.setText("Video");
        }
        quant=(LinearLayout)v.findViewById(R.id.formula_logical);
        logical=(LinearLayout)v.findViewById(R.id.problems_logical);
        quant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b=new Bundle();
                b.putString("book","aptitude");
                Fragment f=new Books();
                f.setArguments(b);
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame,f);
                fragmentTransaction.addToBackStack(null).commit();
            }
        });

        logical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b=new Bundle();
                b.putString("book","logical");
                Fragment f=new Books();
                f.setArguments(b);
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame,f);
                fragmentTransaction.addToBackStack(null).commit();
            }
        });
        return v;
    }
}
