package com.example.wattwallet.fragments;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wattwallet.Adapters.CardAdapter;

import java.util.Arrays;
import java.util.List;
import com.example.wattwallet.R;

public class HomeFragment extends Fragment implements View.OnClickListener{

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

        List<String> sampleData = Arrays.asList("Text 1", "Text 2", "Text 3"); // Sample data

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        adapter = new CardAdapter(getContext(), sampleData);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

    }
}