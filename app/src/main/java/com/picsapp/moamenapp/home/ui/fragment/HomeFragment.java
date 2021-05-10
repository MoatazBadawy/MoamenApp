package com.picsapp.moamenapp.home.ui.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.picsapp.moamenapp.Adapter.Picasso.IOnBackPressed;
import com.picsapp.moamenapp.home.adapter.HomeAdapter;
import com.picsapp.moamenapp.home.viewmodel.HomeViewModel;
import com.picsapp.moamenapp.R;

public class HomeFragment extends Fragment implements IOnBackPressed {

    View rootView;
    RecyclerView recyclerView;
    private HomeAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        requireActivity().setTitle("");
        initializeContent();
        initializeViewModel();
        return rootView;
    }

    private void initializeContent() {
        adapter = new HomeAdapter();
        recyclerView = rootView.findViewById(R.id.recyclerView_home);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    private void initializeViewModel() {
        ProgressBar progressBar = rootView.findViewById(R.id.progress_bar_home);
        HomeViewModel viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        viewModel.makeApiCallHome().observe(requireActivity(), homeResponses -> {
            if (homeResponses != null) {
                progressBar.setVisibility(View.GONE);
                adapter.setHomeList(homeResponses);
            }
        });
    }

    @Override
    public boolean onBackPressed() {
        //exit the app when press back
        requireActivity().moveTaskToBack(true);
        requireActivity().finish();
        return true;
    }
}