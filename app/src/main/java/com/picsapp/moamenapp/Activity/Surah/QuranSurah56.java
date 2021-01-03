package com.picsapp.moamenapp.Activity.Surah;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah56 extends AppCompatActivity {

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
                "https://i.ibb.co/f2pHpys/a187.jpg",
                // 2
                "https://i.ibb.co/100C8fB/a188.jpg",
                // 3
                "https://i.ibb.co/yXD5yry/a189.jpg",
                // 4
                "https://i.ibb.co/cbrXmj6/a190.jpg",
                // 5
                "https://i.ibb.co/f11pbJs/a191.jpg",
                // 6
                "https://i.ibb.co/G0bzrHB/a192.jpg",
                // 7
                "https://i.ibb.co/GC0Bmk9/a193.jpg",
                // 8
                "https://i.ibb.co/W2P0fDX/a194.jpg",
                // 9
                "https://i.ibb.co/VmjCZ4h/a195.jpg",
                // 10
                "https://i.ibb.co/Qpr0bmk/a196.jpg",
                // 11
                "https://i.ibb.co/1rmvcFF/a197.jpg",
                // 12
                "https://i.ibb.co/6nnbWBq/a198.jpg",
                // 13
                "https://i.ibb.co/zGtxcHW/a199.jpg",
                // 14
                "https://i.ibb.co/fvhTJjs/a200.jpg",
                // 15
                "https://i.ibb.co/gSG8zc5/a201.jpg",
                // 16
                "https://i.ibb.co/25LTY0x/a202.jpg",
                // 17
                "https://i.ibb.co/QkKb1C1/a203.jpg",
                // 18
                "https://i.ibb.co/QKyb5tx/a204.jpg",
                // 19
                "https://i.ibb.co/KL2P9KK/a205.jpg",
                // 20
                "https://i.ibb.co/x7K6j6v/a206.jpg",
                // 21
                "https://i.ibb.co/s5y3zcV/a207.jpg",
        };
    }

    // ViewPager includes ViewPagerAdapter
    private void ViewPager() {
        viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, ImageIds);
        viewPager.setAdapter(adapter);
    }
}