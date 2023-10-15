package com.example.wattwallet.fragments;

import androidx.fragment.app.Fragment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wattwallet.Adapters.CardAdapter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import com.example.wattwallet.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    private CardAdapter adapter;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> oddData = Arrays.asList("Week 1", "Week 3", "Week 5", "Week 7", "Week 9"); // Sample data
        List<String> evenData = Arrays.asList("Week 2", "Week 4", "Week 6", "Week 8", "Week 10"); // Sample data


        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        adapter = new CardAdapter(getContext(), oddData, evenData);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {

    }
}