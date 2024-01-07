package com.example.tour_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class CityDescriptionFragment extends Fragment {

    private static final String ARG_CITY_NAME = "cityName";

    public CityDescriptionFragment() {
        // Required empty public constructor
    }

    public static CityDescriptionFragment newInstance(String cityName) {
        CityDescriptionFragment fragment = new CityDescriptionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CITY_NAME, cityName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city_description, container, false);
        TextView cityNameTextView = view.findViewById(R.id.cityNameTextView);
        TextView descriptionTextView = view.findViewById(R.id.descriptionTextView);
        ImageView cityImageView = view.findViewById(R.id.cityImageView);

        if (getArguments() != null) {
            String cityName = getArguments().getString(ARG_CITY_NAME);
            cityNameTextView.setText(cityName);

            // Set description and image based on cityName (using a switch statement)
            switch (cityName) {
                case "Alexandria":
                    descriptionTextView.setText(getString(R.string.alexandria_description));
                    cityImageView.setImageResource(R.drawable.alexandria);
                    break;
                case "Aswan":
                    descriptionTextView.setText(getString(R.string.aswan_description));
                    cityImageView.setImageResource(R.drawable.aswan);
                    break;
                case "Cairo":
                    descriptionTextView.setText(getString(R.string.cairo_description));
                    cityImageView.setImageResource(R.drawable.cairo);
                    break;
                case "Matrouh":
                    descriptionTextView.setText(getString(R.string.matrouh_description));
                    cityImageView.setImageResource(R.drawable.matrouh);
                    break;
                case "Hurghada":
                    descriptionTextView.setText(getString(R.string.hurghada_description));
                    cityImageView.setImageResource(R.drawable.hurghada);
                    break;
                default:
                    // Handle default case or show an error message
                    break;
            }
        }

        return view;
    }

}
