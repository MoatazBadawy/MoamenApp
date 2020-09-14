package com.picsapp.moamenapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import com.duolingo.open.rtlviewpager.RtlViewPager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.picsapp.moamenapp.Adapter.Others.CheckNetwork;
import com.picsapp.moamenapp.Adapter.Picasso.IOnBackPressed;
import com.picsapp.moamenapp.Adapter.Quran.ViewPagerQuranAdapter;
import com.picsapp.moamenapp.R;

public class QuranFragment extends Fragment implements IOnBackPressed {

    int limitNumberOfPages = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_quran, container, false);

        // make the app support only arabic "Right to left"
        // even if the language of the device on english or others
        ViewCompat.setLayoutDirection(getActivity().getWindow().getDecorView(), ViewCompat.LAYOUT_DIRECTION_RTL);

        // Find the view pager that will allow the user to swipe between fragments
        // "ViewPager with RTL support"
        final RtlViewPager viewPager = rootView.findViewById(R.id.view_pager_quran_fateha);

        // Create an adapter that knows which fragment should be shown on each page
        final ViewPagerQuranAdapter adapter = new ViewPagerQuranAdapter(this, getActivity().getSupportFragmentManager());
        // to make the viewPager not Reload when scroll "see this https://stackoverflow.com/questions/36517035/android-stop-tablayout-reload-refresh-my-fragments"
        viewPager.setOffscreenPageLimit(limitNumberOfPages); //before setAdapter

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = rootView.findViewById(R.id.tabs_quran);

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
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
