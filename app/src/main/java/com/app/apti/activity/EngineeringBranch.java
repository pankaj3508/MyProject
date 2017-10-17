package com.app.apti.activity;

import android.app.Dialog;
import android.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.app.apti.R;

/**
 * Created by pankajjoshi on 14/10/17.
 */

public class EngineeringBranch extends Fragment implements AdapterView.OnItemClickListener {
    TextView branchText;
    private ListView listsubject;
    private String []subjects;
    private String []books;
    String branch;
    Dialog dialog=null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.engineering_branch,container,false);
        Bundle b=getArguments();
         branch=b.getString("engineering");
        branchText=(TextView)v.findViewById(R.id.branch_topic);
        branchText.setText(branch);
        if(branch.equalsIgnoreCase("mechanical"))
        {
            subjects=getResources().getStringArray(R.array.mechanical);
        }
        else if(branch.equalsIgnoreCase("cs/it"))
        {
            subjects=getResources().getStringArray(R.array.csit);
        }
        else if(branch.equalsIgnoreCase("electronics"))
        {
            subjects=getResources().getStringArray(R.array.electronics);
        }else if(branch.equalsIgnoreCase("electrical"))
        {
            subjects=getResources().getStringArray(R.array.electrical);
        }else if(branch.equalsIgnoreCase("civil"))
        {
            subjects=getResources().getStringArray(R.array.civil);
        }
        else if(branch.equalsIgnoreCase("chemical"))
        {
            subjects=getResources().getStringArray(R.array.chemical);
        }
        else if(branch.equalsIgnoreCase("INSTRUMENTATION"))
        {
            subjects=getResources().getStringArray(R.array.instrumentation);
        }
        else if(branch.equalsIgnoreCase("BIO TECHNOLOGY"))
        {
            ImageView iv=(ImageView)v.findViewById(R.id.notfound);
            iv.setVisibility(View.VISIBLE);
        }
        if(!branch.equalsIgnoreCase("BIO TECHNOLOGY")) {
            listsubject = (ListView) v.findViewById(R.id.branchtopic_list);
            listsubject.setAdapter(new CustomBranchSubject(getActivity(), subjects));
            listsubject.setOnItemClickListener(this);
        }
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(branch.equalsIgnoreCase("mechanical"))
        {
            books=getResources().getStringArray(R.array.mechanical_books);
            opendialog(subjects[i],i);
        }else if(branch.equalsIgnoreCase("cs/it"))
        {
            books=getResources().getStringArray(R.array.csit_books);
            opendialog(subjects[i],i);
        }else if(branch.equalsIgnoreCase("electronics"))
        {
            books=getResources().getStringArray(R.array.electronics_books);
            opendialog(subjects[i],i);
        }else if(branch.equalsIgnoreCase("electrical"))
        {
            books=getResources().getStringArray(R.array.electrical_books);
            opendialog(subjects[i],i);
        }else if(branch.equalsIgnoreCase("civil"))
        {
            books=getResources().getStringArray(R.array.civil_books);
            opendialog(subjects[i],i);
        }else if(branch.equalsIgnoreCase("chemical"))
        {
            books=getResources().getStringArray(R.array.chemical_books);
            opendialog(subjects[i],i);
        }else if(branch.equalsIgnoreCase("INSTRUMENTATION"))
        {
            books=getResources().getStringArray(R.array.instrumentation_books);
            opendialog(subjects[i],i);
        }
    }

    void opendialog(String heading,int i)
    {
        dialog=new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.books_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        TextView head=(TextView)dialog.findViewById(R.id.sub);
        TextView book1=(TextView)dialog.findViewById(R.id.book1);
        TextView book2=(TextView)dialog.findViewById(R.id.book2);
        String b=books[i*2+1];
        book1.setText(books[i*2]);
        if(b.equals(""))
        {
            LinearLayout l=(LinearLayout)dialog.findViewById(R.id.visible);
            l.setVisibility(View.INVISIBLE);
        }
        else
        book2.setText(books[i*2+1]);
        head.setText(heading);
        LinearLayout close=(LinearLayout)dialog.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
