package com.picsapp.moamenapp.Adapter.Picasso;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.picsapp.moamenapp.Fragment.ImagesFragment;
import com.picsapp.moamenapp.Fragment.ImagesFragmentProject.CategoryImagesFragment;
import com.picsapp.moamenapp.Fragment.ImagesFragmentProject.HomeImagesFragment;
import com.picsapp.moamenapp.Fragment.ImagesFragmentProject.WallpapersImagesFragment;
import com.picsapp.moamenapp.R;


/**
 * {@link ViewpagerImagesAdapter} is a {@link FragmentStatePagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link } objects.
 */
public class ViewpagerImagesAdapter extends FragmentStatePagerAdapter {

    /**
     * Context of the app
     */
    private ImagesFragment mContext;

    /**
     * Create a new {@link ViewpagerImagesAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     */
    public ViewpagerImagesAdapter(ImagesFragment context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            String[] chooseImages = new String[0];
            return new HomeImagesFragment();
        } else if (position == 1) {
            return new CategoryImagesFragment();
        } else {
            return new WallpapersImagesFragment();
        }
    }

    // each tab title
    // to shows the names for each fragment on tab title
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_places);
        } else if (position == 1) {
            return mContext.getString(R.string.category_photos);
        } else {
            return mContext.getString(R.string.category_resturants);
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 3;
    }

}