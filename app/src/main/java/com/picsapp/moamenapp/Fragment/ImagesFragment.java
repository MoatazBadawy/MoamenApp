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
import com.picsapp.moamenapp.Adapter.Picasso.ViewpagerImagesAdapter;
import com.picsapp.moamenapp.R;

/*
 * This class for display images section in Fragment
 */
public class ImagesFragment extends Fragment implements IOnBackPressed {

    View rootView ;
    RtlViewPager viewPager;
    TabLayout tabLayout ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_images, container, false);

        // make the app support only arabic "Right to left"
        supportArabic();
        // display BottomSheet if there's no internet
        checkInternet();

        // Find the view pager that will allow the user to swipe between fragments
        // "ViewPager with RTL support"
        ViewPagerAdapetr();
        // Connect the tab layout with the view pager. This will
        tabLayoutAdapter();

        return rootView;
    }

    public void supportArabic () {

        // make the app support only arabic "Right to left"
        // even if the language of the device on english or others
        ViewCompat.setLayoutDirection(getActivity().getWindow().getDecorView(), ViewCompat.LAYOUT_DIRECTION_RTL);
    }

    public void ViewPagerAdapetr () {

        // Find the view pager that will allow the user to swipe between fragments
        // "ViewPager with RTL support"
        viewPager = rootView.findViewById(R.id.view_pager);

        // Create an adapter that knows which fragment should be shown on each page
        final ViewpagerImagesAdapter adapter = new ViewpagerImagesAdapter(this, getActivity().getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);
    }

    public void tabLayoutAdapter() {
        // Find the tab layout that shows the tabs
        tabLayout = rootView.findViewById(R.id.tabs);

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager);
    }

    public void checkInternet() {

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
    }

    @Override
    //back to first fragment when press back
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
