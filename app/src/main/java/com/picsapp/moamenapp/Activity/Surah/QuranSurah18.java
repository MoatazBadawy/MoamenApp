package com.picsapp.moamenapp.Activity.Surah;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah18 extends AppCompatActivity {

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
                "https://i.ibb.co/LYGt9dP/a293.jpg",
                // 2
                "https://i.ibb.co/dgNyqRz/a294.jpg",
                // 3
                "https://i.ibb.co/hfQKWbb/a295.jpg",
                // 4
                "https://i.ibb.co/RzSnfvX/a296.jpg",
                // 5
                "https://i.ibb.co/Ns3vtsc/a297.jpg",
                // 6
                "https://i.ibb.co/vYqK4f1/a298.jpg",
                // 7
                "https://i.ibb.co/Q9gMm67/a299.jpg",
                // 8
                "https://i.ibb.co/16tpfh4/a300.jpg",
                // 9
                "https://i.ibb.co/X49WHBB/a301.jpg",
                // 10
                "https://i.ibb.co/tDKvrDD/a302.jpg",
                // 11
                "https://i.ibb.co/7zjgRC8/a303.jpg",
                // 12
                "https://i.ibb.co/FWT53Z2/a304.jpg",
        };
    }

    // ViewPager includes ViewPagerAdapter
    private void ViewPager() {
        viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, ImageIds);
        viewPager.setAdapter(adapter);
    }
}