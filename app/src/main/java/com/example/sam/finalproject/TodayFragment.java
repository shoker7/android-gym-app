package com.example.sam.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Sam on 11/25/16.
 */

public class TodayFragment extends Fragment{
    public TodayFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_today,container, false);
    }

    public void startWorkoutActivity(View view) {
        Intent intent = new Intent(getActivity(), WorkoutActivity.class);
        startActivity(intent);
    }
}
