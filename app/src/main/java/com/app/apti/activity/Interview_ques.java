package com.app.apti.activity;

import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    static int pos=0;
    LinearLayout prev,next,share;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.interview_ques,container,false);
        ques=(TextView)v.findViewById(R.id.textView);
        ans=(TextView)v.findViewById(R.id.textView3);
        prev=(LinearLayout)v.findViewById(R.id.move_prev);
        next=(LinearLayout) v.findViewById(R.id.move_next);
        share=(LinearLayout) v.findViewById(R.id.share);
        ques.setText(questions.get(pos).ques);
        ans.setText(questions.get(pos).answer);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pos!=0)
                    pos--;
                ques.setText(questions.get(pos).ques);
                ans.setText(questions.get(pos).answer);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pos!=questions.size()-1)
                    pos++;
                ques.setText(questions.get(pos).ques);
                ans.setText(questions.get(pos).answer);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shareBody = "Hey check out this question \n\n"+questions.get(pos).ques+"\n\n"+questions.get(pos).answer;
                Intent sharing=new Intent(Intent.ACTION_SEND);
                sharing.setType("text/plain");
                sharing.putExtra(android.content.Intent.EXTRA_SUBJECT, "Prepare aptitude and for interviews");

                sharing.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                try {
                    startActivity(Intent.createChooser(sharing, "Share via"));
                }
                catch (ActivityNotFoundException e)
                {
                    Toast.makeText(getActivity().getApplication(),"There is no email/message client in your device",Toast.LENGTH_SHORT).show();
                }
            }
        });



        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myDatabase=new MyDatabase(getActivity());

        questions=myDatabase.getQuestions();
    }
}
