package com.example.a021520211;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Button sign_in_btn = (Button) findViewById(R.id.sign_in_button);
//        sign_in_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openNewActivity();
//            }
//        });

    }
//
//
//    public void openNewActivity(){
//        Intent intent = new Intent(this, NavigationActivity.class);
//        startActivity(intent);
//    }


//        fragmentTransaction = getSupportFragmentManager().beginTransaction();


}