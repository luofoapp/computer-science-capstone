package com.example.a021520211;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.fragment.NavHostFragment;

public class SignUpPage extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.sign_up_page, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(SecondFragment.this)
//                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
//            }
//        });
    }

//    public void checkConfirmEmail (View v) {
//        EditText actualEmail = (EditText)v.findViewById(R.id.signUpInitEmail);
//
//        EditText confEmail = (EditText)v.findViewById(R.id.signUpEmailConfirm);
//
//        actualEmail.setOnClickListener(new View.OnClickListener()  {
//            @Override
//            public void onClick(View v) {
//                if(actualEmail != confEmail) {
//                    actualEmail.setText("this is a test");
//                }
//            }
//        });
//
//    }
}