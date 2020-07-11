package com.picsapp.moamenapp.Activity.QuranActivity;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah53 extends AppCompatActivity {

    private int[] ImageIds = new int[]{
            R.drawable.ic_arrow_back, R.drawable.icon, R.drawable.aqsa_image, R.drawable.aqsa_image_full, R.drawable.ramadan_image
    };
    private int[] mImageIds = new int[]{R.drawable.others_images_full, R.drawable.nabawe_image_full, R.drawable.haram_image_full};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_1_activity_quran_surah53);

        // Hide status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // make the app support only arabic "Right to left"
        ViewCompat.setLayoutDirection(getWindow().getDecorView(), ViewCompat.LAYOUT_DIRECTION_RTL);

        ViewPager viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, mImageIds);
        viewPager.setAdapter(adapter);
    }
}