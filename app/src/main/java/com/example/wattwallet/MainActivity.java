package com.example.wattwallet;

import android.os.Bundle;

import com.example.wattwallet.fragments.HomeFragment;
import com.example.wattwallet.fragments.MoneyFragment;
import com.example.wattwallet.fragments.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.wattwallet.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView bottomNavigationView;
    MoneyFragment moneyfragment = new MoneyFragment();
    HomeFragment homeFragment = new HomeFragment();
    UserFragment userFragment = new UserFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //attaching variables to their respective views
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        //setting click listeners
        bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    //assigns fragments to their respective xmls
                    //home fragment
                    case R.id.action_home:
                        fragment = homeFragment;
                        break;
                    //user fragment
                    case R.id.action_user:
                        fragment = userFragment;
                        break;
                    //money fragment
                    case R.id.action_money:
                    default:
                        fragment =moneyfragment;
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }
}