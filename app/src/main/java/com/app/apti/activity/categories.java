package com.app.apti.activity;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.app.apti.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class categories extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);
        String s=getIntent().getStringExtra("category").toString();
        getSupportActionBar().setTitle(s);
        setContentView(R.layout.activity_categories);
        switch(s)
        {
            case "Aptitude": aptitude();
                break;
            case "Logical Reasoning":logical();
                break;
            case "Verbal": verbal();
                break;
            case "Puzzle":puzzles();
                break;
            case "Interview":interview();
                break;
            case "Books": video();
                break;
            case "Video": video();
                break;
            default:

        }

    }
    private void aptitude()
    {
        Fragment f=new Aptitude();
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,f);
        fragmentTransaction.commit();
    }



    private void logical()
    {
        Fragment f=new Logical();
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,f);
        fragmentTransaction.commit();
    }

    private void verbal()
    {
        Fragment f=new Topic();
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,f);
        fragmentTransaction.commit();
    }

    private void puzzles()
    {
        Fragment f=new Topic();
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,f);
        fragmentTransaction.commit();
    }

    private void interview()
    {
        Fragment f=new interviews();
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,f);
        fragmentTransaction.commit();
    }
    private void video()
    {
        Fragment f=new Video();
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,f);
        fragmentTransaction.commit();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
