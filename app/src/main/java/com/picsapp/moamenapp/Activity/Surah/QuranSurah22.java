package com.picsapp.moamenapp.Activity.Surah;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah22 extends AppCompatActivity {

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
                "https://i.ibb.co/WW6D2th/a332.jpg",
                // 2
                "https://i.ibb.co/LxDwcbR/a333.jpg",
                // 3
                "https://i.ibb.co/9yVTR5v/a334.jpg",
                // 4
                "https://i.ibb.co/DVzD9vj/a335.jpg",
                // 5
                "https://i.ibb.co/tJ2YNLb/a336.jpg",
                // 6
                "https://i.ibb.co/RbLdNVM/a337.jpg",
                // 7
                "https://i.ibb.co/0D5JYsN/a338.jpg",
                // 8
                "https://i.ibb.co/HHNMKns/a339.jpg",
                // 9
                "https://i.ibb.co/cvFfJhd/a340.jpg",
                // 10
                "https://i.ibb.co/DQ4DG9W/a341.jpg",
        };
    }

    // ViewPager includes ViewPagerAdapter
    private void ViewPager() {
        viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, ImageIds);
        viewPager.setAdapter(adapter);
    }
}