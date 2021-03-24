package com.example.a021520211;

import android.media.ImageReader;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class HomePage extends Fragment implements OnMapReadyCallback {


    private GoogleMap map;
    private MapView mapView;
    private static final String MAP_VIEW_BUNDLE_KEY = "MapViewBundleKey";

    FragmentTransaction fragmentTransaction;




    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_page, container, false);


        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY);
        }

        mapView = v.findViewById(R.id.mapView);
        mapView.onCreate(mapViewBundle);
        mapView.getMapAsync(this);



        Button requestBtn = v.findViewById(R.id.request_btn);
        Button waitingBtn = v.findViewById(R.id.waiting_btn);
        Button goBtn = v.findViewById(R.id.go_btn);
//        SupportMapFragment supportMapFragment = SupportMapFragment.newInstance()


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


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setMinZoomPreference(12);
        LatLng ny = new LatLng(40.7143528, -74.0059731);
        map.moveCamera(CameraUpdateFactory.newLatLng(ny));
//        map = googleMap;
//        LatLng cheeter = new LatLng(39.21892860762234, -76.07043063105402);
//        map.addMarker(new MarkerOptions().position(cheeter).title("I miss here"));
//        map.moveCamera(CameraUpdateFactory.newLatLng(cheeter));
    }


//    @Override
//    protected void onResume() {
//        super.onResume();
//        mapView.onResume();
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        mapView.onStart();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        mapView.onStop();
//    }
//    @Override
//    protected void onPause() {
//        mapView.onPause();
//        super.onPause();
//    }
//    @Override
//    protected void onDestroy() {
//        mapView.onDestroy();
//        super.onDestroy();
//    }
//


}