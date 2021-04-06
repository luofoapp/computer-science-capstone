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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MPRecentPlaces extends Fragment {
    FragmentTransaction fragmentTransaction;
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_m_p_recent_places, container, false);
        listView = (ListView)v.findViewById(R.id.placesNames);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, generateList());



        ArrayList data = new ArrayList<HashMap<String, String>>();
        String [] titleArray=new String[]{"Casey Academic Center", "Sados", "Royal Farms"};
        String [] subItemArray=new String[]{"300 Washington Avenue Chestertown, MD 21620", " 870 High St, Chestertown, MD 21620", "859 High St, Chestertown, MD 21620"};
        for(int i=0;i<titleArray.length;i++){
            HashMap<String,String> datum = new HashMap<String, String>();
            datum.put("LocName", titleArray[i]);
            datum.put("LocAd", subItemArray[i]);
            data.add(datum);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), data, android.R.layout.simple_list_item_2, new String[] {"LocName", "LocAd"}, new int[] {android.R.id.text1, android.R.id.text2});
        listView.setAdapter(adapter);



//        ArrayAdapter arrayAdapter2 = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_2, generateList2());

//        listView.setAdapter(arrayAdapter);
//        listView.setAdapter(arrayAdapter2);
        return v;
    }

    //generateList functions are not called, fix up when hooking everything together
    public ArrayList<String> generateList() {
        List<String> namesList = Arrays.asList( "Casey Academic Center", "Sados", "Royal Farms");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(namesList);
        return arrayList;
    }

    public ArrayList<String> generateList2() {
        List<String> namesList = Arrays.asList( "300 Washington Avenue Chestertown, MD 21620", " 870 High St, Chestertown, MD 21620", "859 High St, Chestertown, MD 21620");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(namesList);
        return arrayList;
    }
}