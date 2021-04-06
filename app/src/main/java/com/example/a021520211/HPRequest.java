package com.example.a021520211;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HPRequest extends Fragment {
    LinearLayout ll;
    ListView listView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_h_p_request, container, false);
        listView = (ListView)v.findViewById(R.id.rfNames);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, generateList());
        listView.setAdapter(arrayAdapter);

        AdapterView.OnItemClickListener listViewOnItemClick = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View arg1, int position, long id) {

                ll = (LinearLayout) v.findViewById(R.id.linlay);
                TextView textView = new TextView(getActivity());
                textView.setTextSize(40);
                textView.setText("text");

                ll.addView(textView);
                ll.invalidate();

//                Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.fragment_fade_enter);
//                mSelectedItem = position;
//                arrayAdapter.notifyDataSetChanged();
            }
        };




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