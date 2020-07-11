package com.picsapp.moamenapp.Activity.QuranActivity;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah2 extends AppCompatActivity {

    private int[] mImageIds = new int[]
            {
                    R.drawable.page002, R.drawable.page003,
                    R.drawable.page004, R.drawable.page005, R.drawable.page006,
                    R.drawable.page007, R.drawable.page008, R.drawable.page009,
                    R.drawable.page010, R.drawable.page011, R.drawable.page012,
                    R.drawable.page013, R.drawable.page014, R.drawable.page015,
                    R.drawable.page016, R.drawable.page017, R.drawable.page018,
                    R.drawable.page019, R.drawable.page020, R.drawable.page021,
                    R.drawable.page022, R.drawable.page023, R.drawable.page024,
                    R.drawable.page025, R.drawable.page026, R.drawable.page027,
                    R.drawable.page028, R.drawable.page029, R.drawable.page030,
                    R.drawable.page031, R.drawable.page032, R.drawable.page033,
                    R.drawable.page034, R.drawable.page035, R.drawable.page036,
                    R.drawable.page037, R.drawable.page038, R.drawable.page039,
                    R.drawable.page040, R.drawable.page041, R.drawable.page042,
                    R.drawable.page043, R.drawable.page044, R.drawable.page045,
                    R.drawable.page046, R.drawable.page047, R.drawable.page048,
                    R.drawable.page049
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_1_activity_quran_surah02);

        // Hide status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // make the app support only arabic "Right to left"
        ViewCompat.setLayoutDirection(getWindow().getDecorView(), ViewCompat.LAYOUT_DIRECTION_RTL);

        ViewPager viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, mImageIds);
        viewPager.setAdapter(adapter);
    }
}