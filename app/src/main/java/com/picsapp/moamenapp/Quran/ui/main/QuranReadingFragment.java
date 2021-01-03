package com.picsapp.moamenapp.Quran.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.picsapp.moamenapp.Quran.model.Data;
import com.picsapp.moamenapp.Quran.utils.Resource;
import com.picsapp.moamenapp.R;

import java.util.List;
import java.util.Objects;


public class QuranReadingFragment extends Fragment {

    public static final String SURAH_NUMBER = "surah_number";
    private MainViewModel mainViewModel;
    private SurahAdapter surahAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_quran_reading, container, false);

        // get the reference of RecyclerView
        RecyclerView recyclerView = rootview.findViewById(R.id.recyclerview_quran_reading);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        surahAdapter = new SurahAdapter();
        recyclerView.setAdapter(surahAdapter);

        initViewModel();
        mainViewModel.getSurahList().observe(getActivity(), response -> {
            surahAdapter.submitList(response.data);
        });

        return rootview;
    }

    private void initViewModel() {
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }
}