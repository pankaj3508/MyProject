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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.app.apti.R;

/**
 * Created by pankajjoshi on 18/10/17.
 */

public class interview_topic extends Fragment implements AdapterView.OnItemClickListener {
    String topic;
    TextView head;
    String [] topic_array;
    ListView list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        View v=inflater.inflate(R.layout.engineering_branch,container,false);
        Bundle b=getArguments();
        topic=b.getString("interview_topic");
        head=(TextView)v.findViewById(R.id.branch_topic);
        list=(ListView)v.findViewById(R.id.branchtopic_list);
        if(topic.equalsIgnoreCase("cs"))
        {
            head.setText("Software Development");
            topic_array=getResources().getStringArray(R.array.software_interview);
        }
        else if(topic.equalsIgnoreCase("hr"))
        {
            head.setText("Human Resource ");
            topic_array=new String[]{"For Fresher","For Experience "};
        }
        else if(topic.equalsIgnoreCase("govt"))
        {
            head.setText("Government Exams ");
            topic_array=new String[]{"SBI PO","IBPS PO","SSC CGL","UPSC","CDS"};
        }
        else if(topic.equalsIgnoreCase("company"))
        {
            head.setText(" Company Wise ");
            topic_array=getResources().getStringArray(R.array.comapny_list);
        }
        list.setAdapter(new CustomBranchSubject(getActivity(), topic_array));
        list.setOnItemClickListener(this);


        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Bundle b=new Bundle();
        b.putString("company",topic_array[i]);
        Fragment f=new Interview_ques();
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,f);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
