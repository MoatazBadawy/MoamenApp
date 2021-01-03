package com.picsapp.moamenapp.Activity.Surah;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah8 extends AppCompatActivity {

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
                "https://i.ibb.co/hy8wk61/a177.jpg",
                // 2
                "https://i.ibb.co/6NXV0Xg/a178.jpg",
                // 3
                "https://i.ibb.co/rcrHvnJ/a179.jpg",
                // 4
                "https://i.ibb.co/cCcW8WR/a180.jpg",
                // 5
                "https://i.ibb.co/x5zcr3B/a181.jpg",
                // 6
                "https://i.ibb.co/dQkSTQ5/a182.jpg",
                // 7
                "https://i.ibb.co/YfBHFVW/a183.jpg",
                // 8
                "https://i.ibb.co/CPfQjFt/a184.jpg",
                // 9
                "https://i.ibb.co/YR1ZbT3/a185.jpg",
                // 10
                "https://i.ibb.co/MMVVXLH/a186.jpg",
        };
    }

    // ViewPager includes ViewPagerAdapter
    private void ViewPager() {
        viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, ImageIds);
        viewPager.setAdapter(adapter);
    }
}