package com.example.tour_app;

import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
public class MainActivity extends AppCompatActivity implements CityListFragment.OnCitySelectedListener {

    private  static final String CITY_LIST_FRAGMENT_TAG = "CityListFragment";

//tee
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.green));
        }
        if (savedInstanceState == null) {
            CityListFragment cityListFragment = new CityListFragment();
            cityListFragment.setOnCitySelectedListener(this);
            showCityListFragment();
        }
    }
    private void showCityListFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        CityListFragment cityListFragment = (CityListFragment) fragmentManager.findFragmentByTag(CITY_LIST_FRAGMENT_TAG);

        if (cityListFragment == null) {
            cityListFragment = new CityListFragment();
            cityListFragment.setOnCitySelectedListener(this);
        }

        if (!cityListFragment.isAdded()) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, cityListFragment, CITY_LIST_FRAGMENT_TAG)
                    .commit();
        }
    }
    @Override
    public void onCitySelected(String cityName) {
        if (!isFinishing() && !isDestroyed()) {
            CityDescriptionFragment descriptionFragment = CityDescriptionFragment.newInstance(cityName);

            getSupportFragmentManager().popBackStack(); // Clear the back stack before adding a new fragment

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, descriptionFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

}
