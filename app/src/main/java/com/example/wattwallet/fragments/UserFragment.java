package com.example.wattwallet.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.wattwallet.R;
import com.example.wattwallet.User;
import com.parse.ParseUser;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogOutCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class UserFragment extends BaseFragment implements View.OnClickListener {
    TextView tvUsername;
    ImageView ivProfilePhoto;
    TextView tvAllTime;
    TextView tvPowerGen;
    TextView tvIncomeText;
    TextView tvIncome;
    TextView tvPower;

    ParseUser user = ParseUser.getCurrentUser();

    public UserFragment() {
        // Empty public constructor
    }

    public static UserFragment newInstance(ParseUser userToFilterBy) {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        args.putParcelable("userToFilterBy", userToFilterBy);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        tvUsername = view.findViewById(R.id.tvName);
        tvAllTime = view.findViewById(R.id.tvAlltime);
        tvPowerGen = view.findViewById(R.id.tvPowerText);
        tvIncomeText = view.findViewById(R.id.tvIncomeText);
        ivProfilePhoto = view.findViewById(R.id.ivProfilePhoto);
        tvIncome = view.findViewById(R.id.tvIncome);
        tvPower = view.findViewById(R.id.tvPower);


        user.fetchInBackground(new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    user = (ParseUser) object;
                    displayUserInfo();
                } else {
                    // Handle the error
                    Toast.makeText(getContext(), "Error fetching user info: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void displayUserInfo() {
        User userInstance = (User) user;
        tvUsername.setText(user.getUsername());

        // Assuming that getProfilePhoto is a field on ParseUser and not an exclusive method of User class
        ParseFile profilePhoto = ((User) user).getProfilePhoto();
        if (profilePhoto != null) {
            Glide.with(getContext())
                    .load(((User) user).getProfilePhoto().getUrl())
                    .placeholder(R.drawable.ic_launcher_load) // Placeholder while image is loading
                    .circleCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL) // Cache the image for better performance
                    .into(ivProfilePhoto);
        } else {
            Toast.makeText(getContext(), "Profile Photo does not exist for " + user.getUsername(), Toast.LENGTH_SHORT).show();
        }
        String totalIncome = userInstance.getString(User.KEY_TOTAL_INCOME);
        String totalWatts = userInstance.getString(User.KEY_TOTAL_WATT);
        tvIncome.setText(totalIncome);
        tvPower.setText(totalWatts);
    }

    @Override
    public void onClick(View view) {
        // Handle your click events here
    }
}
