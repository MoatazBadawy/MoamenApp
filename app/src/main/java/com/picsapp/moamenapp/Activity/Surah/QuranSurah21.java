package com.picsapp.moamenapp.Activity.Surah;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah21 extends AppCompatActivity {

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
                "https://i.ibb.co/2nV99Zs/a322.jpg",
                // 2
                "https://i.ibb.co/jz8KP53/a323.jpg",
                // 3
                "https://i.ibb.co/Kz2dPVn/a324.jpg",
                // 4
                "https://i.ibb.co/1nx7zDG/a325.jpg",
                // 5
                "https://i.ibb.co/bXxntfn/a326.jpg",
                // 6
                "https://i.ibb.co/8z5tPqg/a327.jpg",
                // 7
                "https://i.ibb.co/2n03fgd/a328.jpg",
                // 8
                "https://i.ibb.co/s3yWzY9/a329.jpg",
                // 9
                "https://i.ibb.co/FWzCPmk/a330.jpg",
                // 10
                "https://i.ibb.co/T1YpKr3/a331.jpg",
        };
    }

    // ViewPager includes ViewPagerAdapter
    private void ViewPager() {
        viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, ImageIds);
        viewPager.setAdapter(adapter);
    }
}