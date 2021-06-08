package com.picsapp.moamenapp.home.ui.view.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.picsapp.moamenapp.Adapter.Picasso.IOnBackPressed;
import com.picsapp.moamenapp.databinding.FragmentHomeBinding;
import com.picsapp.moamenapp.home.ui.adapter.HomeAdapter;
import com.picsapp.moamenapp.home.ui.viewmodel.HomeViewModel;
import org.jetbrains.annotations.NotNull;

public class HomeFragment extends Fragment implements IOnBackPressed {

    private HomeAdapter adapter;
    private HomeViewModel viewModel;
    private FragmentHomeBinding binding;
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        initializeView();
        getHomeList();
        initializeViewModel();
        return view;
    }

    private void initializeView() {
        adapter = new HomeAdapter();
        binding.recyclerViewHome.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerViewHome.setHasFixedSize(true);
        binding.recyclerViewHome.setAdapter(adapter);
        requireActivity().setTitle("");
    }

    private void getHomeList() {
        viewModel.makeApiCallHome().observe(requireActivity(), response -> {
            switch (response.status){
                case ERROR: {
                    binding.errorBold.setVisibility(View.VISIBLE);
                    binding.errorMessage1.setVisibility(View.VISIBLE);
                    binding.errorMessage2.setVisibility(View.VISIBLE);
                    binding.progressBarHome.setVisibility(View.GONE);
                    break;
                }
                case LOADING: {
                    binding.progressBarHome.setVisibility(View.VISIBLE);
                    break;
                }
                case SUCCESS:{
                    binding.progressBarHome.setVisibility(View.GONE);
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
        requireActivity().moveTaskToBack(true); //exit the app when press back
        requireActivity().finish();
        return true;
    }
}