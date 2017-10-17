package com.app.apti.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.app.apti.R;

/**
 * Created by pankajjoshi on 17/10/17.
 */

public class Extra extends Fragment {
    int toggle=0;
    LinearLayout visible,invisible;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        View v=inflater.inflate(R.layout.extra,container,false);
        visible=(LinearLayout)v.findViewById(R.id.resume_visible);
        invisible=(LinearLayout)v.findViewById(R.id.resume_invisible);
        visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggle==0) {
                    invisible.setVisibility(View.VISIBLE);
                    toggle=1;
                }
                else
                {
                    invisible.setVisibility(View.GONE);
                    toggle=0;
                }
            }
        });
        return v;
    }
}
