package com.example.wattwallet.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wattwallet.R;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private List<String> mOdd;
    private List<String> mEven;
    private List<String> kWE;
    private List<String> kWO;

    private LayoutInflater mInflater;

    public CardAdapter(Context context, List<String> oddData, List<String> evenData, List<String> kwO, List<String> kwE) {
        this.mInflater = LayoutInflater.from(context);
        this.mOdd = oddData;
        this.mEven = evenData;
        this.kWO = kwO;
        this.kWE = kwE;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String oddText = position < mOdd.size() ? mOdd.get(position) : ""; // Check bounds for odd week
        String evenText = position < mEven.size() ? mEven.get(position) : ""; // Check bounds for even week
        String kwOText = position < kWO.size() ? kWO.get(position) : ""; // Check bounds for odd kW
        String kwEText = position < kWE.size() ? kWE.get(position) : ""; // Check bounds for even kW

        holder.tvweeknumber.setText(oddText);
        holder.tvweeknumber2.setText(evenText);
        holder.tvKwUse.setText(kwOText);
        holder.tvKwUse2.setText(kwEText);
    }

    @Override
    public int getItemCount() {
        return Math.max(mOdd.size(), mEven.size()); // Ensuring it takes the larger list size
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvweeknumber;
        TextView tvweeknumber2;
        TextView tvKwUse;
        TextView tvKwUse2;

        ViewHolder(View itemView) {
            super(itemView);
            tvweeknumber = itemView.findViewById(R.id.tvweeknumber);
            tvweeknumber2 = itemView.findViewById(R.id.tvweeknumber2);
            tvKwUse = itemView.findViewById(R.id.tvKwUse);
            tvKwUse2 = itemView.findViewById(R.id.tvKwUse2);
        }
    }
}
