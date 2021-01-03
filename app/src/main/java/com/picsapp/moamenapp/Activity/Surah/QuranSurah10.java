package com.picsapp.moamenapp.Activity.Surah;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah10 extends AppCompatActivity {

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
                "https://i.ibb.co/yWwBKbh/a208.jpg",
                // 2
                "https://i.ibb.co/6bSq9Jw/a209.jpg",
                // 3
                "https://i.ibb.co/BLhnG6s/a210.jpg",
                // 4
                "https://i.ibb.co/Xfn5pNm/a211.jpg",
                // 5
                "https://i.ibb.co/mSmhFyt/a212.jpg",
                // 6
                "https://i.ibb.co/0jS8LK8/a213.jpg",
                // 7
                "https://i.ibb.co/z4jfTcv/a214.jpg",
                // 8
                "https://i.ibb.co/pP5YMW3/a215.jpg",
                // 9
                "https://i.ibb.co/47TqNrJ/a216.jpg",
                // 10
                "https://i.ibb.co/WBM94Bc/a217.jpg",
                // 11
                "https://i.ibb.co/P5NjbdC/a218.jpg",
                // 12
                "https://i.ibb.co/rGnHGGG/a219.jpg",
                // 13
                "https://i.ibb.co/RDZtdCx/a220.jpg",
                // 14
                "https://i.ibb.co/s98M5N0/a221.jpg",
        };
    }

    // ViewPager includes ViewPagerAdapter
    private void ViewPager() {
        viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, ImageIds);
        viewPager.setAdapter(adapter);
    }
}