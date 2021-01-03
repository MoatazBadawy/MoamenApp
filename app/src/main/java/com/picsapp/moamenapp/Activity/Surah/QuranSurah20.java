package com.picsapp.moamenapp.Activity.Surah;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah20 extends AppCompatActivity {

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
                "https://i.ibb.co/0nvqvvm/a312.jpg",
                // 2
                "https://i.ibb.co/G5VZP0B/a313.jpg",
                // 3
                "https://i.ibb.co/jkx5F5y/a314.jpg",
                // 4
                "https://i.ibb.co/QHk2Byb/a315.jpg",
                // 5
                "https://i.ibb.co/FhZsNSG/a316.jpg",
                // 6
                "https://i.ibb.co/Mf5JCWR/a317.jpg",
                // 7
                "https://i.ibb.co/Y8xLFsH/a318.jpg",
                // 8
                "https://i.ibb.co/QkGr5fW/a319.jpg",
                // 9
                "https://i.ibb.co/QbFCdMg/a320.jpg",
                // 10
                "https://i.ibb.co/ZH2zLXB/a321.jpg",
        };
    }

    // ViewPager includes ViewPagerAdapter
    private void ViewPager() {
        viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, ImageIds);
        viewPager.setAdapter(adapter);
    }
}