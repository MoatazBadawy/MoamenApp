package com.picsapp.moamenapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.picsapp.moamenapp.Adapter.IOnBackPressed;
import com.picsapp.moamenapp.R;

public class EbadatFragment extends Fragment implements IOnBackPressed {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ebadat, container, false);
    }

    //back to first fragment when press back
    @Override
    public boolean onBackPressed() {
        //do what you want
        HomeFragment nextFrag = new HomeFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout, nextFrag, "findThisFragment")
                .addToBackStack(null)
                .commit();

        return true;
    }
}
