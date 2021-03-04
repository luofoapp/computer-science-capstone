package com.example.a021520211;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

public class MyProfile extends Fragment {
    FragmentTransaction fragmentTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.my_profile, container, false);
        Button find_friends_btn = v.findViewById(R.id.find_friends_buton);
        Button recent_places_btn = v.findViewById(R.id.recent_places_button);
        Button my_friends_btn = v.findViewById(R.id.my_friends_button);
        Button my_ratings_btn = v.findViewById(R.id.my_ratings_button);
        Button my_comments_btn = v.findViewById(R.id.my_comments_button);
        Button settings_btn = v.findViewById(R.id.settings_button);

        find_friends_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MPFindFriends findFriendsFrag = new MPFindFriends();
                fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_container, findFriendsFrag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        recent_places_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MPRecentPlaces recentPlacesFrag = new MPRecentPlaces();
                fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_container, recentPlacesFrag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        my_friends_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MPMyFriends myFriendsFrag = new MPMyFriends();
                fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_container, myFriendsFrag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        my_ratings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MPMyRatings myRatingsFrag = new MPMyRatings();
                fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_container, myRatingsFrag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        my_comments_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MPMyComments myCommentsFrag = new MPMyComments();
                fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_container, myCommentsFrag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        settings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MPSettings settingsFrag = new MPSettings();
                fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_container, settingsFrag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return v;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}