package com.example.a021520211;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MPMyRatings extends Fragment {
    FragmentTransaction fragmentTransaction;
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_m_p_my_ratings, container, false);
        listView = (ListView)v.findViewById(R.id.my_ratings);
//        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, generateList());

        ArrayList data = new ArrayList<HashMap<String, String>>();
        String [] titleArray=new String[]{"Casey Academic Center", "Sados", "Royal Farms"};
        String [] subItemArray=new String[]{"4/5 This was a well lit area and ...", "2/5","4/5 Not much traffic at night ..."};
        for(int i=0;i<titleArray.length;i++){
            HashMap<String,String> datum = new HashMap<String, String>();
            datum.put("LocName", titleArray[i]);
            datum.put("LocAd", subItemArray[i]);
            data.add(datum);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), data, android.R.layout.simple_list_item_2, new String[] {"LocName", "LocAd"}, new int[] {android.R.id.text1, android.R.id.text2});
        listView.setAdapter(adapter);
        return v;
    }
}