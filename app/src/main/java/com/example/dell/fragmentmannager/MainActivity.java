package com.example.dell.fragmentmannager;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,FirstFragment.IcomTowActivity{


    private static final String TAG = MainActivity.class.getSimpleName();
    private FrameLayout mFramecontainer;
    private View mMainLayout;
    private boolean mTowpane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTowpane=getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT;
        if(mTowpane)
        {
            mFramecontainer = (FrameLayout) findViewById(R.id.frame_layout);
            mMainLayout = findViewById(R.id.activity_main);
            mMainLayout.setOnClickListener(this);
        }
        else
        {
            final Button btnSwap = (Button) findViewById(R.id.btn_Swap);
            btnSwap.setOnClickListener(this);
            FragmentManager fragm = getSupportFragmentManager();
            fragm.beginTransaction().add(R.id.fragment_container_activity_main_land, new FirstFragment(), "First Fragment").commit();
        }
    }

    @Override
    public void onClick(View v) {
        if(mTowpane) {
            if (v.getId() == R.id.activity_main) {
                Log.v(MainActivity.TAG, "Clicket");
                FragmentManager fragm = getSupportFragmentManager();
                fragm.beginTransaction().add(R.id.frame_layout, new FirstFragment(), "FirstFragment").commit();
            }
        }
        else  if (v.getId() == R.id.btn_Swap)
        {
            FragmentManager fm = getSupportFragmentManager();
        boolean isFirstFragment=  fm.findFragmentByTag("First Fragment")!=null;

            LinearLayout mlinearlayout =(LinearLayout)findViewById(R.id.Linear_content_button);
int color;
            Fragment fragmet;
            String fragmentTag;
            if(isFirstFragment)
            {fragmet=new SecontFragment();
            fragmentTag="Secont Fragment";
               color=R.color.colorAccent;
            }
            else
            {fragmet=new FirstFragment();
                fragmentTag="First Fragment";
                color=R.color.colorPrimaryDark;

            }
            fm.beginTransaction()
                    .replace(R.id.fragment_container_activity_main_land,fragmet,fragmentTag).commit();
            mlinearlayout.setBackgroundColor(ContextCompat.getColor(this,color));

        }


    }

    @Override
    public void getRandomNumberFromFragmentone() {
        double randomnumber=Math.random();
        Log.e(MainActivity.TAG,"Random"+randomnumber);

      //  Fragment fragment =findViewById(R.id.Fragment_secont_main);

    }
}
