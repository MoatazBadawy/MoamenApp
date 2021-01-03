package com.picsapp.moamenapp.Activity.Surah;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah16 extends AppCompatActivity {

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
                "https://i.ibb.co/4M2yY8k/a267.jpg",
                // 2
                "https://i.ibb.co/n1Q0NqR/a268.jpg",
                // 3
                "https://i.ibb.co/nM5j7Zk/a269.jpg",
                // 4
                "https://i.ibb.co/ZHFN8nQ/a270.jpg",
                // 5
                "https://i.ibb.co/HC2P1wT/a271.jpg",
                // 6
                "https://i.ibb.co/RYswzHd/a272.jpg",
                // 7
                "https://i.ibb.co/mFBqvyV/a273.jpg",
                // 8
                "https://i.ibb.co/t8bd0Rp/a274.jpg",
                // 9
                "https://i.ibb.co/cJFk6Lq/a275.jpg",
                // 10
                "https://i.ibb.co/gW8kKFR/a276.jpg",
                // 11
                "https://i.ibb.co/gwghYjg/a277.jpg",
                // 12
                "https://i.ibb.co/fnYkvY1/a278.jpg",
                // 13
                "https://i.ibb.co/wzp8pWh/a279.jpg",
                // 14
                "https://i.ibb.co/ZX171FW/a280.jpg",
                // 15
                "https://i.ibb.co/WvC9Sm7/a281.jpg",
        };
    }

    // ViewPager includes ViewPagerAdapter
    private void ViewPager() {
        viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, ImageIds);
        viewPager.setAdapter(adapter);
    }
}