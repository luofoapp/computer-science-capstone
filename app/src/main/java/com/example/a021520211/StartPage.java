package com.example.a021520211;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class StartPage extends Fragment {
    
    FragmentTransaction fragmentTransaction;

    public StartPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_start_page, container, false);
        Button signUpBtn = v.findViewById(R.id.sign_up_button);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getParentFragmentManager().beginTransaction();
                SignUpPage signUpFrag = new SignUpPage();
                fragmentTransaction.replace(R.id.content_container, signUpFrag);
                fragmentTransaction.commit();
            }
        });

        return v;
    }

}