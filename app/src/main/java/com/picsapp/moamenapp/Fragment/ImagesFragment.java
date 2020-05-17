package com.picsapp.moamenapp.Fragment;

import android.os.Bundle;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.duolingo.open.rtlviewpager.RtlViewPager;
import com.google.android.material.tabs.TabLayout;
import com.picsapp.moamenapp.Adapter.ViewpagerImagesAdapter;
import com.picsapp.moamenapp.R;

/*
 * This class for display images section in Fragment
 */
public class ImagesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /* Inflate the layout for this fragment */
        View rootView = inflater.inflate(R.layout.fragment_images, container, false);

        /* make the app support only arabic "Right to left" */
        // even if the language of the device on english or others
        ViewCompat.setLayoutDirection(getActivity().getWindow().getDecorView(),ViewCompat.LAYOUT_DIRECTION_RTL);

        // Find the view pager that will allow the user to swipe between fragments
        // "ViewPager with RTL support"
        RtlViewPager viewPager = rootView.findViewById(R.id.view_pager);

        // Create an adapter that knows which fragment should be shown on each page
        ViewpagerImagesAdapter adapter = new ViewpagerImagesAdapter(this, getActivity().getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = rootView.findViewById(R.id.tabs);

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager);

        return rootView;
    }
}
