package com.picsapp.moamenapp.home.ui.view.fragment;

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
import com.picsapp.moamenapp.home.ui.adapter.HomeAdapter;
import com.picsapp.moamenapp.home.ui.viewmodel.HomeViewModel;
import com.picsapp.moamenapp.R;

import static com.picsapp.moamenapp.home.utils.Status.ERROR;
import static com.picsapp.moamenapp.home.utils.Status.LOADING;
import static com.picsapp.moamenapp.home.utils.Status.SUCCESS;

public class HomeFragment extends Fragment implements IOnBackPressed {

    View rootView;
    RecyclerView recyclerView;
    private HomeAdapter adapter;
    ProgressBar progressBar;
    HomeViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        requireActivity().setTitle("");
        initializeViews();
        initializeViewModel();
        getHomeList();
        return rootView;
    }

    private void initializeViews() {
        adapter = new HomeAdapter();
        progressBar = rootView.findViewById(R.id.progress_bar_home);
        recyclerView = rootView.findViewById(R.id.recyclerView_home);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    private void getHomeList() {
        viewModel.makeApiCallHome().observe(requireActivity(), response -> {
            switch (response.status){
                case ERROR:
                case LOADING: {
                    progressBar.setVisibility(View.VISIBLE);
                    break;
                }
                case SUCCESS:{
                    progressBar.setVisibility(View.GONE);
                    adapter.setHomeList(response.data);
                    break;
                }
            }
        });
    }

    private void initializeViewModel() {
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    }

    @Override
    public boolean onBackPressed() {
        //exit the app when press back
        requireActivity().moveTaskToBack(true);
        requireActivity().finish();
        return true;
    }
}