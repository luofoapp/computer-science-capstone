package com.example.a021520211;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomePage extends Fragment {

    FragmentTransaction fragmentTransaction;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_page, container, false);

        Button requestBtn = v.findViewById(R.id.request_btn);
        Button waitingBtn = v.findViewById(R.id.waiting_btn);
        Button goBtn = v.findViewById(R.id.go_btn);


        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HPRequest requestFrag = new HPRequest();
                fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.drawer_frags, requestFrag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        waitingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HPWaitingRoom waitingFrag = new HPWaitingRoom();
                fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.drawer_frags, waitingFrag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HPGoNow goFrag = new HPGoNow();
                fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.drawer_frags, goFrag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });






        return v;
    }
}