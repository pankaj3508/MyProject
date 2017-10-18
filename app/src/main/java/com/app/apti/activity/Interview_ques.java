package com.app.apti.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.apti.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by pankajjoshi on 18/10/17.
 */

public class Interview_ques extends Fragment {

    MyDatabase myDatabase;
    private ArrayList<storedatabsevalue> questions;
    TextView ques,ans,compa;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.interview_ques,container,false);
        ques=(TextView)v.findViewById(R.id.textView);
        ans=(TextView)v.findViewById(R.id.textView3);
        compa=(TextView)v.findViewById(R.id.textView4);
        ques.setText(questions.get(0).ques);
        ans.setText(questions.get(0).answer);
        compa.setText(questions.get(0).company);


        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myDatabase=new MyDatabase(getActivity());

        questions=myDatabase.getQuestions();
    }
}
