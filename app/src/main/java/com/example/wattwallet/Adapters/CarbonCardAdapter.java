package com.example.wattwallet.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wattwallet.R;

import java.util.List;

public class CarbonCardAdapter extends RecyclerView.Adapter<CarbonCardAdapter.ViewHolder>{

    private List<Integer> mDrawables;
    private String totalIncome;
    private LayoutInflater mInflater;
    private String mTotalWatts;



    public CarbonCardAdapter(Context context, String totalIncome, String totalKw, List<Integer> drawables) {
        this.mInflater = LayoutInflater.from(context);
        this.totalIncome = totalIncome;
        this.mTotalWatts = totalKw;
        this.mDrawables = drawables;
    }

    @NonNull
    @Override
    public CarbonCardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.carbon_card, parent, false);
        return new CarbonCardAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarbonCardAdapter.ViewHolder holder, int position) {

        holder.cardText.setText(totalIncome);
        int drawableResId = mDrawables.get(position);
        holder.imageView.setImageResource(drawableResId);
        holder.tvkW.setText(mTotalWatts);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView cardText;
        ImageView imageView;
        TextView tvkW;
        ViewHolder(View itemView) {
            super(itemView);
            cardText = itemView.findViewById(R.id.tveth);
            imageView = itemView.findViewById(R.id.ivLandscape);
            tvkW = itemView.findViewById(R.id.tvkW);
        }
    }
}