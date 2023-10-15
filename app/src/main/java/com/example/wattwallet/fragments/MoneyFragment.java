package com.example.wattwallet.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.wattwallet.Adapters.CarbonCardAdapter;
import com.example.wattwallet.Adapters.CardAdapter;
import com.example.wattwallet.R;
import com.example.wattwallet.User;
import com.parse.ParseUser;

import java.util.Arrays;
import java.util.List;

public class MoneyFragment extends Fragment {
    ParseUser user = ParseUser.getCurrentUser();
    private RecyclerView rv_carbon;
    private CarbonCardAdapter adapter;
    View view;
    TextView cardText;
    ImageView imageView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_money, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<Integer> drawableList = Arrays.asList(
                R.drawable.ic_launcher_forest,
                R.drawable.ic_launcher_tree,
                R.drawable.ic_launcher_blue);
        String totalIncome = user.getString(User.KEY_TOTAL_INCOME);
        String totalWatts = user.getString(User.KEY_TOTAL_WATT);


        rv_carbon = view.findViewById(R.id.rv_carbon);
        rv_carbon.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        adapter = new CarbonCardAdapter(getContext(), totalIncome, totalWatts, drawableList);
        rv_carbon.setAdapter(adapter);
    }
}