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
    private LayoutInflater mInflater;

    public CardAdapter(Context context, List<String> odd, List<String> even) {
        this.mInflater = LayoutInflater.from(context);
        this.mOdd = odd;
        this.mEven = even;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String oddText = position < mOdd.size() ? mOdd.get(position) : ""; // Check bounds
        String evenText = position < mEven.size() ? mEven.get(position) : ""; // Check bounds
        holder.tvweeknumber.setText(oddText);
        holder.tvweeknumber2.setText(evenText);
    }

    @Override
    public int getItemCount() {
        return Math.max(mOdd.size(), mEven.size());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView cardText;
        TextView tvweeknumber;
        TextView tvweeknumber2;

        ViewHolder(View itemView) {
            super(itemView);
            tvweeknumber = itemView.findViewById(R.id.tvweeknumber); // Assuming this ID for the odd weeks
            tvweeknumber2 = itemView.findViewById(R.id.tvweeknumber2); // Assuming this ID for the even weeks
        }
    }
}
