package com.example.wattwallet.fragments;

import androidx.fragment.app.Fragment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.wattwallet.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    private CardAdapter adapter;
    View view;
    private LineChart lineChart;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lineChart = view.findViewById(R.id.lineChart);
        setupLineChart();

        List<String> oddData = Arrays.asList("Week 1", "Week 3", "Week 5", "Week 7", "Week 9");
        List<String> evenData = Arrays.asList("Week 2", "Week 4", "Week 6", "Week 8", "Week 10");
        List<String> KwE = Arrays.asList("20 kW", "10 kW", "15kw", "16 kW", "5 kW", "2 kW", "16 kW", "8 kW", "17 kW", "10 kW");
        List<String> KwO = Arrays.asList("2 kW", "16 kW", "8 kW", "17 kW", "10 kW");


        recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        adapter = new CardAdapter(getContext(), oddData, evenData, KwO, KwE);
        recyclerView.setAdapter(adapter);
    }

    private void setupLineChart() {
        // Example data points
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0f, 20f));
        entries.add(new Entry(1f, 10f));
        entries.add(new Entry(2f, 15f));
        entries.add(new Entry(3f, 16f));
        entries.add(new Entry(4f, 5f));
        // ... add more entries ...

        LineDataSet dataSet = new LineDataSet(entries, "Energy Consumption (kW)");
        dataSet.setColor(Color.BLUE);
        dataSet.setValueTextColor(Color.RED);

        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);
        lineChart.invalidate();  // refresh the chart
    }

    @Override
    public void onClick(View view) {

    }
}