package com.picsapp.moamenapp.Activity.Surah;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah17 extends AppCompatActivity {

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
                "https://i.ibb.co/mbRp59g/a282.jpg",
                // 2
                "https://i.ibb.co/cNsByp2/a283.jpg",
                // 3
                "https://i.ibb.co/X3xm5YL/a284.jpg",
                // 4
                "https://i.ibb.co/TPt8RC9/a285.jpg",
                // 5
                "https://i.ibb.co/jhgzn8d/a286.jpg",
                // 6
                "https://i.ibb.co/g9t2HjB/a287.jpg",
                // 7
                "https://i.ibb.co/txt6H6v/a288.jpg",
                // 8
                "https://i.ibb.co/VpbhrtZ/a289.jpg",
                // 9
                "https://i.ibb.co/wyzMMQQ/a290.jpg",
                // 10
                "https://i.ibb.co/ZSFkSMF/a291.jpg",
                // 11
                "https://i.ibb.co/dgznNSR/a292.jpg",
                // 12
                "https://i.ibb.co/LYGt9dP/a293.jpg",
        };
    }

    // ViewPager includes ViewPagerAdapter
    private void ViewPager() {
        viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, ImageIds);
        viewPager.setAdapter(adapter);
    }
}