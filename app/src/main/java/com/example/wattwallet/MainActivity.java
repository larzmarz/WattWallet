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
import com.parse.ParseUser;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        fragment = getOrCreateFragment(HomeFragment.class, "HomeFragment");
                        break;
                    case R.id.action_user:
                        fragment = getOrCreateFragment(UserFragment.class, "UserFragment");
                        if (getSupportActionBar() != null) {
                            getSupportActionBar().hide();
                        }
                        if (fragment.getArguments() == null) {
                            Bundle args = new Bundle();
                            args.putParcelable("currentUser", ParseUser.getCurrentUser()); // Assumes ParseUser is Parcelable; adjust as needed.
                            fragment.setArguments(args);
                        }
                        break;
                    case R.id.action_money:
                    default:
                        fragment = getOrCreateFragment(MoneyFragment.class, "MoneyFragment");
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });

        if (savedInstanceState == null) {
            // Load default fragment when activity is first created
            bottomNavigationView.setSelectedItemId(R.id.action_home);
        }
    }

    private <T extends Fragment> T getOrCreateFragment(Class<T> fragmentClass, String tag) {
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment == null) {
            try {
                fragment = fragmentClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return (T) fragment;
    }
}
