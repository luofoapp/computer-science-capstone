package com.example.a021520211;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


//import android.support.annotation.NonNull;
//import android.support.design.widget.NavigationView;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import android.view.MenuItem;
import android.widget.Toast;

public class NavigationActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    FragmentTransaction fragmentTransaction;
    Fragment newFragment;
//    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        dl = (DrawerLayout)findViewById(R.id.activity_nav);
//        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);
        t = new ActionBarDrawerToggle(this, dl, R.string.navigation_drawer_open, R.string.navigation_drawer_close);


        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.go_somewhere_it:
                        HomePage homePageFrag = new HomePage();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.drawer_frags, homePageFrag);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        dl.closeDrawers();
                        return true;
                    case R.id.find_friends_it:
                        MPFindFriends findFriendsFrag = new MPFindFriends();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.drawer_frags, findFriendsFrag);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        dl.closeDrawers();
                        return true;
                    case R.id.recent_places_it:
                        MPRecentPlaces recentPlacesFrag = new MPRecentPlaces();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.drawer_frags, recentPlacesFrag);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        dl.closeDrawers();
                        return true;
                    case R.id.my_friends_it:
                        MPMyFriends myFriendsFrag = new MPMyFriends();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.drawer_frags, myFriendsFrag);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        dl.closeDrawers();
                        return true;
                    case R.id.my_ratings_it:
                        MPMyRatings myRatingsFrag = new MPMyRatings();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.drawer_frags, myRatingsFrag);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        dl.closeDrawers();
                        return true;
                    case R.id.settings_it:
                        MPSettings settingsFrag = new MPSettings();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.drawer_frags, settingsFrag);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        dl.closeDrawers();
                        return true;
                    default:
                        return onOptionsItemSelected(item);
                }
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}