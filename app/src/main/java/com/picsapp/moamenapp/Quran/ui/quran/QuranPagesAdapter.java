package com.picsapp.moamenapp.Quran.ui.quran;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.github.chrisbanes.photoview.PhotoView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class QuranPagesAdapter extends PagerAdapter {

    private List<Integer> mQuranPagesList;
    private Context mContext;

    public QuranPagesAdapter(Context context, List<Integer> quranPagesList){
        mContext = context;
        mQuranPagesList = quranPagesList;
    }

    @Override
    public int getCount() {
        return mQuranPagesList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NotNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Integer image = mQuranPagesList.get(position);

        PhotoView imageView = new PhotoView (mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(image);
        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }
}
