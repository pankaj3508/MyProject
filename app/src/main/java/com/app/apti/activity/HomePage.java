package com.app.apti.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.app.apti.R;

import java.util.ArrayList;
import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class HomePage extends AppCompatActivity {

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawer;
    private ListView mDrawerListView;
    private LinearLayout apt,logical,verbal,puzzle,video,interview,books,extra;
    List<DrawerItem> drawerItems;
    Dialog dialog=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);


        mDrawerListView = (ListView) findViewById(R.id.left_drawer);
        drawerItems=new ArrayList<>();


        drawerItems.add(new DrawerItem("Bookmarks",R.drawable.bookmark));
        drawerItems.add(new DrawerItem("Notifications",R.drawable.notification));
        drawerItems.add(new DrawerItem("Settings",R.drawable.settings));
        drawerItems.add(new DrawerItem("Share",R.drawable.share));
        drawerItems.add(new DrawerItem("Feedback",R.drawable.feedback));
        drawerItems.add(new DrawerItem("Rate Us",R.drawable.rateus));
        drawerItems.add(new DrawerItem("Theme",R.drawable.theme));
        drawerItems.add(new DrawerItem("Help",R.drawable.help));
        drawerItems.add(new DrawerItem("Check for Update",R.drawable.update));
        mDrawerListView.setAdapter(new CustomDrawerAdapter(this,drawerItems));

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        // These lines are needed to display the top-left hamburger button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Aptitude");
        // Make the hamburger button work
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawer,R.string.app_name,R.string.app_name){
            @Override
            public void onDrawerClosed(View drawerView) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }
        };
        mDrawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();


        mDrawerListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i)
                {
                    case 3: share();
                        break;
                    case 4: Intent intent=new Intent(HomePage.this, Feedback.class);
                        startActivity(intent);
                        break;
                    case 5: rateus();
                        break;
                    default:
                }

                //start coding here
                mDrawer.closeDrawer(GravityCompat.START);
            }
        });


        apt=(LinearLayout)findViewById(R.id.apt);
        logical=(LinearLayout)findViewById(R.id.logical);
        verbal=(LinearLayout)findViewById(R.id.verbal);
        puzzle=(LinearLayout)findViewById(R.id.puzzle);
        interview=(LinearLayout)findViewById(R.id.interview);
        video=(LinearLayout)findViewById(R.id.video);
        books=(LinearLayout)findViewById(R.id.books);
        extra=(LinearLayout)findViewById(R.id.extra);
        apt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HomePage.this,categories.class);
                i.putExtra("category","Aptitude");
                startActivity(i);
            }
        });

        logical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HomePage.this,categories.class);
                i.putExtra("category","Logical Reasoning");
                startActivity(i);
            }
        });

        verbal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HomePage.this,categories.class);
                i.putExtra("category","Verbal");
                startActivity(i);
            }
        });

        puzzle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HomePage.this,categories.class);
                i.putExtra("category","Puzzle");
                startActivity(i);
            }
        });

        interview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HomePage.this,categories.class);
                i.putExtra("category","Interview");
                startActivity(i);
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HomePage.this,categories.class);
                i.putExtra("category","Video");
                startActivity(i);
            }
        });

        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HomePage.this,categories.class);
                i.putExtra("category","Books");
                startActivity(i);
            }
        });

        extra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HomePage.this,categories.class);
                i.putExtra("category","Extra");
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    public void rateus()
    {
        dialog=new Dialog(HomePage.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.rating);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        LinearLayout sure,cancel;

        sure=(LinearLayout)dialog.findViewById(R.id.sure);
        cancel=(LinearLayout)dialog.findViewById(R.id.later);
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("hello");
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        dialog.show();
    }


    public void share()
    {
        String shareBody = "https://play.google.com/store/apps/details?";
        Intent sharing=new Intent(Intent.ACTION_SEND);
        sharing.setType("text/plain");
        sharing.putExtra(android.content.Intent.EXTRA_SUBJECT, "Prepare aptitude and for interviews");

        sharing.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharing, "Share via"));
    }
}
