package com.example.tour_app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class CityListFragment extends Fragment {

    private String[] cities = {"Alexandria", "Aswan", "Cairo", "Matrouh", "Hurghada"};
    private OnCitySelectedListener listener;

    public interface OnCitySelectedListener {
        void onCitySelected(String cityName);
    }
    public CityListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true); // Retain fragment instance across configuration changes
        if (getActivity() instanceof OnCitySelectedListener) {
            listener = (OnCitySelectedListener) getActivity();
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnCitySelectedListener) {
            listener = (OnCitySelectedListener) context;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city_list, container, false);
        ListView listView = view.findViewById(R.id.cityListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), R.layout.list_item_city, cities);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view1, position, l) -> {
            if (listener != null) {
                String cityName = cities[position];
                listener.onCitySelected(cityName);
            }
        });

        return view;
    }

    public void setOnCitySelectedListener(OnCitySelectedListener listener) {
        this.listener = listener;
    }
}
