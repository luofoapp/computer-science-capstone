package com.example.a021520211;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MPMyFriends extends Fragment {
    FragmentTransaction fragmentTransaction;
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_m_p_my_friends, container, false);
        listView = (ListView)v.findViewById(R.id.mfNames);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, generateList());
        listView.setAdapter(arrayAdapter);
        return v;
    }

    public ArrayList<String> generateList() {
        List<String> namesList = Arrays.asList( "Callie McMaster", "Michelle Ly", "Eloise Claire Lienert", "Omolola Sanusi", "Amy Lai");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(namesList);
        java.util.Collections.sort(arrayList);
        return arrayList;
    }
}