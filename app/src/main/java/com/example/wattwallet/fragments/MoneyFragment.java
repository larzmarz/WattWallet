package com.example.wattwallet.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

public class MoneyFragment extends Fragment {
    ParseUser user = ParseUser.getCurrentUser();
    private RecyclerView rv_carbon;
    private CarbonCardAdapter adapter;
    View view;
    TextView cardText;
    ImageView imageView;
    private Button downloadButton;



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
        
        downloadButton = view.findViewById(R.id.btnDownload);
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureAndSaveRecyclerView();
            }
        });
    }

    private void captureAndSaveRecyclerView() {
        Bitmap bitmap = Bitmap.createBitmap(rv_carbon.getWidth(), rv_carbon.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);
        rv_carbon.draw(canvas);

        try {
            // Use MediaStore to save the bitmap
            String savedImageURL = MediaStore.Images.Media.insertImage(
                    getContext().getContentResolver(),
                    bitmap,
                    "screenshot" ,
                    "Screenshot of RecyclerView"
            );

            // Notify the gallery about the new image so it immediately appears
            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri contentUri = Uri.parse(savedImageURL);
            mediaScanIntent.setData(contentUri);
            getContext().sendBroadcast(mediaScanIntent);

            Toast.makeText(getContext(), "Saved to gallery!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Error occurred!", Toast.LENGTH_SHORT).show();
        }
    }

}