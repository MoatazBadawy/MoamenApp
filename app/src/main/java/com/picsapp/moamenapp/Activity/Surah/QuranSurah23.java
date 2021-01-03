package com.picsapp.moamenapp.Activity.Surah;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah23 extends AppCompatActivity {

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
                // 0
                "https://i.ibb.co/rkvwpRZ/a342.jpg",
                // 1
                "https://i.ibb.co/5rptgZq/a343.jpg",
                // 2
                "https://i.ibb.co/RTQd8my/a344.jpg",
                // 3
                "https://i.ibb.co/87dtCLX/a345.jpg",
                // 4
                "https://i.ibb.co/QJFj4pw/a346.jpg",
                // 5
                "https://i.ibb.co/R72n20J/a347.jpg",
                // 6
                "https://i.ibb.co/7JSvM86/a348.jpg",
                // 7
                "https://i.ibb.co/km5DzD0/a349.jpg",
        };
    }

    // ViewPager includes ViewPagerAdapter
    private void ViewPager() {
        viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, ImageIds);
        viewPager.setAdapter(adapter);
    }
}