package com.picsapp.moamenapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.duolingo.open.rtlviewpager.RtlViewPager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.picsapp.moamenapp.Adapter.Others.CheckNetwork;
import com.picsapp.moamenapp.Adapter.Picasso.IOnBackPressed;
import com.picsapp.moamenapp.Adapter.Quran.ViewPagerQuranAdapter;
import com.picsapp.moamenapp.R;

import java.util.Objects;

public class QuranFragment extends Fragment implements IOnBackPressed {

    private RtlViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_quran, container, false);

        viewPager = rootView.findViewById(R.id.view_pager_quran_fateha);
        final ViewPagerQuranAdapter adapter = new ViewPagerQuranAdapter(this, getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        // make the viewPager not update the data when swipe
        viewPager.setOffscreenPageLimit(2);
        TabLayout tabLayout = rootView.findViewById(R.id.tabs_quran);
        tabLayout.setupWithViewPager(viewPager);


        if (CheckNetwork.isInternetAvailable(getActivity())) {  //returns true if internet available

        } else {
            BottomSheetBehavior mBottomSheetBehavior;
            ConstraintLayout mBottomsheet;
            // BottomSheetBehavior to make sheet bar
            mBottomsheet = rootView.findViewById(R.id.bottom_sheet_no_internet);
            mBottomSheetBehavior = BottomSheetBehavior.from(mBottomsheet);

            if (mBottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        }

        // Inflate the layout for this fragment
        return rootView;

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
