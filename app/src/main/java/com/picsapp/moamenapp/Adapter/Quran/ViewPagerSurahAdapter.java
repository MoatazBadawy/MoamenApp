package com.picsapp.moamenapp.Adapter.Quran;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.github.chrisbanes.photoview.PhotoView;
import com.picsapp.moamenapp.R;
import com.squareup.picasso.Picasso;
import org.jetbrains.annotations.NotNull;


public class ViewPagerSurahAdapter extends PagerAdapter {
    private final Context context;
    private final String[] imageUrls;

    public ViewPagerSurahAdapter(Context context, String[] imageUrls) {
        this.context = context;
        this.imageUrls = imageUrls;
    }

    @Override
    public int getCount() {
        return imageUrls.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NotNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // PhotoView to zoom in the image "Instaded of ImageView"
        PhotoView imageView = new PhotoView (context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        Picasso.with(context)
                .load(imageUrls[position])
                .placeholder(R.drawable.folder_loading_display_image) // load image
                .into(imageView);
        container.addView(imageView,0);

        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
