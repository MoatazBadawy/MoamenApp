package com.picsapp.moamenapp.Activity.Surah;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah4 extends AppCompatActivity {

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
                "https://i.ibb.co/Cv5G0sm/a77.jpg",
                // 2
                "https://i.ibb.co/bj0CbLw/a78.jpg",
                // 3
                "https://i.ibb.co/BCzhvLL/a79.jpg",
                // 4
                "https://i.ibb.co/gWLy4rV/a80.jpg",
                // 5
                "https://i.ibb.co/k6JRhHP/a81.jpg",
                // 6
                "https://i.ibb.co/SQjb0kw/a82.jpg",
                // 7
                "https://i.ibb.co/D7TJYJY/a83.jpg",
                // 8
                "https://i.ibb.co/qsKPYY9/a84.jpg",
                // 9
                "https://i.ibb.co/3YysHd8/a85.jpg",
                // 10
                "https://i.ibb.co/gPWFw0b/a86.jpg",
                // 11
                "https://i.ibb.co/kJdtJ8C/a87.jpg",
                // 12
                "https://i.ibb.co/b7X2Xfv/a88.jpg",
                // 13
                "https://i.ibb.co/dpWNjCY/a89.jpg",
                // 14
                "https://i.ibb.co/8rRSP2y/a90.jpg",
                // 15
                "https://i.ibb.co/B4HHqTj/a91.jpg",
                // 16
                "https://i.ibb.co/Njg8zdW/a92.jpg",
                // 17
                "https://i.ibb.co/6tqyjKF/a93.jpg",
                // 18
                "https://i.ibb.co/cFF2vJM/a94.jpg",
                // 19
                "https://i.ibb.co/99rRsyS/a95.jpg",
                // 20
                "https://i.ibb.co/vDGD0Q9/a96.jpg",
                // 21
                "https://i.ibb.co/xzYSwkt/a97.jpg",
                // 22
                "https://i.ibb.co/Lrr49Dp/a98.jpg",
                // 23
                "https://i.ibb.co/wKpY7GL/a99.jpg",
                // 24
                "https://i.ibb.co/48FpmP1/a100.jpg",
                // 25
                "https://i.ibb.co/kS4t6NM/a101.jpg",
                // 26
                "https://i.ibb.co/cKBrSWx/a102.jpg",
                // 27
                "https://i.ibb.co/j5R7Nd9/a103.jpg",
                // 28
                "https://i.ibb.co/09RtR1L/a104.jpg",
                // 29
                "https://i.ibb.co/85BXNxF/a105.jpg",
                // 30
                "https://i.ibb.co/x2zgqYn/a106.jpg",
        };
    }

    // ViewPager includes ViewPagerAdapter
    private void ViewPager() {
        viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, ImageIds);
        viewPager.setAdapter(adapter);
    }
}