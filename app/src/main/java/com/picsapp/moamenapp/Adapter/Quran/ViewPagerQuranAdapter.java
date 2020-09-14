package com.picsapp.moamenapp.Adapter.Quran;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.picsapp.moamenapp.Adapter.Picasso.ViewpagerImagesAdapter;
import com.picsapp.moamenapp.Fragment.Quran.QuranListingFragment;
import com.picsapp.moamenapp.Fragment.Quran.QuranSearchFragment;
import com.picsapp.moamenapp.Fragment.QuranFragment;
import com.picsapp.moamenapp.Quran.ui.main.QuranReadingFragment;
import com.picsapp.moamenapp.R;

public class ViewPagerQuranAdapter extends FragmentStatePagerAdapter {

    /**
     * Context of the app
     */
    private QuranFragment mContext;

    /**
     * Create a new {@link ViewpagerImagesAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     */
    public ViewPagerQuranAdapter(QuranFragment context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     *
     * @return
     */
    public Fragment getItem(int position) {
        if (position == 0) {
            return new QuranReadingFragment();
        }

        else if (position == 1) {
            return new QuranListingFragment();

        }

        else {
            return new QuranSearchFragment();
        }
    }

    // each tab title
    // to shows the names for each fragment on tab title
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.reading_quran_tabe);
        }

        else if (position == 1) {
            return mContext.getString(R.string.lesting_quran_tabe);
        }

        else {
            return mContext.getString(R.string.search_quran_tabe);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }


}
