package com.picsapp.moamenapp.Activity.Surah;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah24 extends AppCompatActivity {

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
                "https://i.ibb.co/HVv40BP/a350.jpg",
                // 2
                "https://i.ibb.co/5T3H0X4/a351.jpg",
                // 3
                "https://i.ibb.co/89gW9fC/a352.jpg",
                // 4
                "https://i.ibb.co/c6SWgvp/a353.jpg",
                // 5
                "https://i.ibb.co/3MJJHhm/a354.jpg",
                // 6
                "https://i.ibb.co/rM03S5C/a355.jpg",
                // 7
                "https://i.ibb.co/KLpgW5w/a356.jpg",
                // 8
                "https://i.ibb.co/YRTVQdw/a357.jpg",
                // 9
                "https://i.ibb.co/2NKwttQ/a358.jpg",
                // 10
                "https://i.ibb.co/KWBwSZq/a359.jpg",
        };
    }

    // ViewPager includes ViewPagerAdapter
    private void ViewPager() {
        viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, ImageIds);
        viewPager.setAdapter(adapter);
    }
}