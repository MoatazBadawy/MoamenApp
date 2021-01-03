package com.picsapp.moamenapp.Activity.Surah;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah6 extends AppCompatActivity {

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
                "https://i.ibb.co/1sNV4Yh/a128.jpg",
                // 2
                "https://i.ibb.co/qmm376J/a129.jpg",
                // 3
                "https://i.ibb.co/NsnYX4D/a130.jpg",
                // 4
                "https://i.ibb.co/6rBLdtK/a131.jpg",
                // 5
                "https://i.ibb.co/DbdFtRQ/a132.jpg",
                // 6
                "https://i.ibb.co/2nZrpXH/a133.jpg",
                // 7
                "https://i.ibb.co/h8tqyVT/a134.jpg",
                // 8
                "https://i.ibb.co/HTNr0mT/a135.jpg",
                // 9
                "https://i.ibb.co/BjjSy7x/a136.jpg",
                // 10
                "https://i.ibb.co/HgQhx6j/a137.jpg",
                // 11
                "https://i.ibb.co/jzb1Yn4/a138.jpg",
                // 12
                "https://i.ibb.co/3rSFGNT/a139.jpg",
                // 13
                "https://i.ibb.co/GFTD4kR/a140.jpg",
                // 14
                "https://i.ibb.co/zrvwFcT/a141.jpg",
                // 15
                "https://i.ibb.co/fqJrjCp/a142.jpg",
                // 16
                "https://i.ibb.co/6r3V5cK/a143.jpg",
                // 17
                "https://i.ibb.co/3rwT580/a144.jpg",
                // 18
                "https://i.ibb.co/VSWsx83/a145.jpg",
                // 19
                "https://i.ibb.co/4jqf3NN/a146.jpg",
                // 20
                "https://i.ibb.co/qj4bRrX/a147.jpg",
                // 21
                "https://i.ibb.co/fFGpVTh/a148.jpg",
                // 22
                "https://i.ibb.co/zRhMkXB/a149.jpg",
                // 23
                "https://i.ibb.co/vwCLNXq/a150.jpg",
        };
    }

    // ViewPager includes ViewPagerAdapter
    private void ViewPager() {
        viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, ImageIds);
        viewPager.setAdapter(adapter);
    }
}