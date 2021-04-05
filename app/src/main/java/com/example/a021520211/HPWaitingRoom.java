package com.example.a021520211;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HPWaitingRoom extends Fragment {

    ListView listView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_h_p_waiting_room, container, false);
        listView = (ListView)v.findViewById(R.id.wrNames);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, generateList());
        listView.setAdapter(arrayAdapter);
        return v;
    }
    public ArrayList<String> generateList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Callie McMaster");
        return arrayList;
    }
}