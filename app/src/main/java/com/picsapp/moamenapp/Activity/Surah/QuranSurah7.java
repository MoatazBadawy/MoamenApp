package com.picsapp.moamenapp.Activity.Surah;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah7 extends AppCompatActivity {

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
                "https://i.ibb.co/vhmdTcN/a151.jpg",
                // 2
                "https://i.ibb.co/H4pgkp3/a152.jpg",
                // 3
                "https://i.ibb.co/yX58pdR/a153.jpg",
                // 4
                "https://i.ibb.co/k88XW6W/a154.jpg",
                // 5
                "https://i.ibb.co/QJ4KbZT/a155.jpg",
                // 6
                "https://i.ibb.co/ZVzZzcc/a156.jpg",
                // 7
                "https://i.ibb.co/M1Pmnpn/a157.jpg",
                // 8
                "https://i.ibb.co/tQSF5B6/a158.jpg",
                // 9
                "https://i.ibb.co/9y3KNXz/a159.jpg",
                // 10
                "https://i.ibb.co/dQqqLzm/a160.jpg",
                // 11
                "https://i.ibb.co/hLhqPNJ/a161.jpg",
                // 12
                "https://i.ibb.co/Q93KZLY/a162.jpg",
                // 13
                "https://i.ibb.co/9qjxL5y/a163.jpg",
                // 14
                "https://i.ibb.co/S0n1CFN/a164.jpg",
                // 15
                "https://i.ibb.co/BLbkC0g/a165.jpg",
                // 16
                "https://i.ibb.co/jkgMKFv/a166.jpg",
                // 17
                "https://i.ibb.co/Ct0wx1B/a167.jpg",
                // 18
                "https://i.ibb.co/zmf4Lh0/a168.jpg",
                // 19
                "https://i.ibb.co/wdxBLwK/a169.jpg",
                // 20
                "https://i.ibb.co/dgxMpBL/a170.jpg",
                // 21
                "https://i.ibb.co/h9QHrK9/a171.jpg",
                // 22
                "https://i.ibb.co/4FJ2Wxh/a172.jpg",
                // 23
                "https://i.ibb.co/1mgdhC8/a173.jpg",
                // 24
                "https://i.ibb.co/BtKGgC9/a174.jpg",
                // 25
                "https://i.ibb.co/FB2hrr4/a175.jpg",
                // 26
                "https://i.ibb.co/rZbny7v/a176.jpg",
        };
    }

    // ViewPager includes ViewPagerAdapter
    private void ViewPager() {
        viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, ImageIds);
        viewPager.setAdapter(adapter);
    }
}