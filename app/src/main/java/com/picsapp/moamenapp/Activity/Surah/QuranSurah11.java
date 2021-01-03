package com.picsapp.moamenapp.Activity.Surah;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah11 extends AppCompatActivity {

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
                "https://i.ibb.co/s98M5N0/a221.jpg",
                // 2
                "https://i.ibb.co/9TL1g4c/a222.jpg",
                // 3
                "https://i.ibb.co/TRbQ5x6/a223.jpg",
                // 4
                "https://i.ibb.co/7nNdxSF/a224.jpg",
                // 5
                "https://i.ibb.co/s2vsSnc/a225.jpg",
                // 6
                "https://i.ibb.co/KzGTc5Y/a226.jpg",
                // 7
                "https://i.ibb.co/0VTymg2/a227.jpg",
                // 8
                "https://i.ibb.co/HGfBpxn/a228.jpg",
                // 9
                "https://i.ibb.co/YBCbM3M/a229.jpg",
                // 10
                "https://i.ibb.co/Bt9Sp32/a230.jpg",
                // 11
                "https://i.ibb.co/r5fSMpG/a231.jpg",
                // 12
                "https://i.ibb.co/PWgKdPc/a232.jpg",
                // 13
                "https://i.ibb.co/k9WJnrc/a233.jpg",
                // 14
                "https://i.ibb.co/XpgjcZw/a234.jpg",
                // 15
                "https://i.ibb.co/QDvdy1p/a235.jpg",
        };
    }

    // ViewPager includes ViewPagerAdapter
    private void ViewPager() {
        viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, ImageIds);
        viewPager.setAdapter(adapter);
    }
}