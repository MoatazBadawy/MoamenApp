package com.picsapp.moamenapp.Activity.Surah;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah12 extends AppCompatActivity {

    private String[] ImageIds;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran_display_shurah);

        LayoutDirectionRTL();
        HideStatusBar();
        ArrayIDImages();
        ViewPager();
    }

    // Make the app support only arabic "Right to left"
    private void LayoutDirectionRTL() {
        ViewCompat.setLayoutDirection(getWindow().getDecorView(), ViewCompat.LAYOUT_DIRECTION_RTL);
    }

    // Hide status bar
    private void HideStatusBar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    // Array that's have the images
    private void ArrayIDImages() {

        ImageIds = new String[] {
                // 1
                "https://i.ibb.co/QDvdy1p/a235.jpg",
                // 2
                "https://i.ibb.co/hdBq7gy/a236.jpg",
                // 3
                "https://i.ibb.co/dMc5bk6/a237.jpg",
                // 4
                "https://i.ibb.co/QNwWkw3/a238.jpg",
                // 5
                "https://i.ibb.co/BHhkgDQ/a239.jpg",
                // 6
                "https://i.ibb.co/DW7nQt3/a240.jpg",
                // 7
                "https://i.ibb.co/Ms75g8x/a241.jpg",
                // 8
                "https://i.ibb.co/y5ZFrdt/a242.jpg",
                // 9
                "https://i.ibb.co/gyRVSrb/a243.jpg",
                // 10
                "https://i.ibb.co/HGf3SjM/a244.jpg",
                // 11
                "https://i.ibb.co/YNYj9px/a245.jpg",
                // 12
                "https://i.ibb.co/s97JXdD/a246.jpg",
                // 13
                "https://i.ibb.co/NZBjH91/a247.jpg",
                // 14
                "https://i.ibb.co/hmJv56W/a248.jpg",
        };
    }

    // ViewPager includes ViewPagerAdapter
    private void ViewPager() {
        viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, ImageIds);
        viewPager.setAdapter(adapter);
    }
}