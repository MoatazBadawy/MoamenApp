package com.picsapp.moamenapp.Activity.Surah;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah3 extends AppCompatActivity {

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

        ImageIds = new String[]
        {
            // 1
            "https://i.ibb.co/KL1r6WL/a50.jpg",
            // 2
            "https://i.ibb.co/W5QvvLD/a51.jpg",
            // 3
            "https://i.ibb.co/P4NRmrZ/a52.jpg",
            // 4
            "https://i.ibb.co/ZBmWFbs/a53.jpg",
            // 5
            "https://i.ibb.co/L5QpnSX/a54.jpg",
            // 6
            "https://i.ibb.co/mvNcR1m/a55.jpg",
            // 7
            "https://i.ibb.co/F6ftpCW/a56.jpg",
            // 8
            "https://i.ibb.co/bNVNBDD/a57.jpg",
            // 9
            "https://i.ibb.co/N6Cz946/a58.jpg",
            // 10
            "https://i.ibb.co/rK9Tr9S/a59.jpg",
            // 11
            "https://i.ibb.co/zG451nD/a60.jpg",
            // 12
            "https://i.ibb.co/1TLrszV/a61.jpg",
            // 13
            "https://i.ibb.co/X2m1zyH/a62.jpg",
            // 14
            "https://i.ibb.co/P6W0xHt/a63.jpg",
            // 15
            "https://i.ibb.co/JQx88g4/a64.jpg",
            // 16
            "https://i.ibb.co/Xs929bh/a65.jpg",
            // 17
            "https://i.ibb.co/7Sj57Dk/a66.jpg",
            // 18
            "https://i.ibb.co/bsLb5fL/a67.jpg",
            // 19
            "https://i.ibb.co/CbyK6tD/a68.jpg",
            // 20
            "https://i.ibb.co/C6tncrD/a69.jpg",
            // 21
            "https://i.ibb.co/JRqMc3w/a70.jpg",
            // 22
            "https://i.ibb.co/BLmNkMy/a71.jpg",
            // 23
            "https://i.ibb.co/0jRksxv/a72.jpg",
            // 24
            "https://i.ibb.co/YjJ02YR/a73.jpg",
            // 25
            "https://i.ibb.co/j5QydSz/a74.jpg",
            // 26
            "https://i.ibb.co/xXwv2mv/a75.jpg",
            // 27
            "https://i.ibb.co/bRwnwVF/a76.jpg",
        };
    }

    // ViewPager includes ViewPagerAdapter
    private void ViewPager() {
        viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, ImageIds);
        viewPager.setAdapter(adapter);
    }
}