package com.example.a021520211;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HPWaitingRoom#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HPWaitingRoom extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_h_p_waiting_room, container, false);
        return v;
    }
}