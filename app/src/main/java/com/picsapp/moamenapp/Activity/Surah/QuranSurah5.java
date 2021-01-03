package com.picsapp.moamenapp.Activity.Surah;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah5 extends AppCompatActivity {

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
                "https://i.ibb.co/x2zgqYn/a106.jpg",
                // 2
                "https://i.ibb.co/bgXCJBb/a107.jpg",
                // 3
                "https://i.ibb.co/hWKtfWD/a108.jpg",
                // 4
                "https://i.ibb.co/LPcjnsH/a109.jpg",
                // 5
                "https://i.ibb.co/Jxrdvt0/a110.jpg",
                // 6
                "https://i.ibb.co/SdSKPPG/a111.jpg",
                // 7
                "https://i.ibb.co/3rkXPw8/a112.jpg",
                // 8
                "https://i.ibb.co/6sbCm8G/a113.jpg",
                // 9
                "https://i.ibb.co/BVzb10R/a114.jpg",
                // 10
                "https://i.ibb.co/7VGPGkx/a115.jpg",
                // 11
                "https://i.ibb.co/d5YTMhT/a116.jpg",
                // 12
                "https://i.ibb.co/sbXXHtb/a117.jpg",
                // 13
                "https://i.ibb.co/pwZJDk5/a118.jpg",
                // 14
                "https://i.ibb.co/9vmr9JR/a119.jpg",
                // 15
                "https://i.ibb.co/Lt6QS7Y/a120.jpg",
                // 16
                "https://i.ibb.co/8sDLcXK/a121.jpg",
                // 17
                "https://i.ibb.co/rfnh2Gc/a122.jpg",
                // 18
                "https://i.ibb.co/BtMfdFt/a123.jpg",
                // 19
                "https://i.ibb.co/nPY6gV8/a124.jpg",
                // 20
                "https://i.ibb.co/K2JPm9C/a125.jpg",
                // 21
                "https://i.ibb.co/LZCyYv0/a126.jpg",
                // 22
                "https://i.ibb.co/zb9qLf8/a127.jpg",
        };
    }

    // ViewPager includes ViewPagerAdapter
    private void ViewPager() {
        viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, ImageIds);
        viewPager.setAdapter(adapter);
    }
}