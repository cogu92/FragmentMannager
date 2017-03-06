package com.example.dell.fragmentmannager;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {


    private static final String TAG =FirstFragment.class.getSimpleName();
public interface IcomTowActivity{
    public void getRandomNumberFromFragmentone();
}
private IcomTowActivity mInterface;
    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context  context) {
        super.onAttach(context);
        mInterface=(IcomTowActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView =inflater.inflate(R.layout.fragment_first, container, false);
      final Button btnupdatefragmentf = (Button) rootView.findViewById(R.id.Btn_update_fragment_first);
        btnupdatefragmentf.setOnClickListener(this);
           return rootView;
    }

    @Override
    public void onClick(View v) {

        Log.i(FirstFragment.TAG," click ");
        MainActivity activity = new MainActivity();
        activity.getRandomNumberFromFragmentone();

    }
}
