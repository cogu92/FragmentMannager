package com.example.dell.fragmentmannager;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private FrameLayout mFramecontainer;
    private View mMainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFramecontainer=(FrameLayout)findViewById(R.id.frame_layout);
        mMainLayout=(View)findViewById(R.id.activity_main);
        mMainLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.activity_main)
        {
            Log.v(MainActivity.TAG,"Clicket");

            FragmentManager fragm =getSupportFragmentManager();
            fragm.beginTransaction().add(R.id.frame_layout, new FirstFragment(),"FirstFragment").commit();
         }

    }
}
