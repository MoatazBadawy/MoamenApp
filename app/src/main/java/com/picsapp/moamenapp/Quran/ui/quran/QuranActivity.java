package com.picsapp.moamenapp.Quran.ui.quran;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.R;

import java.util.ArrayList;
import java.util.List;

import static com.picsapp.moamenapp.Quran.ui.main.QuranReadingFragment.SURAH_NUMBER;

public class QuranActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran_display);

        // Hide status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // make the app support only arabic "Right to left"
        ViewCompat.setLayoutDirection(getWindow().getDecorView(), ViewCompat.LAYOUT_DIRECTION_RTL);

        initViewPager();
        getSurahPageNumber();
    }

    private void initViewPager() {

        viewPager = findViewById(R.id.view_pager_quran);
        QuranPagesAdapter pagesAdapter = new QuranPagesAdapter(this, getPagesList());
        viewPager.setAdapter(pagesAdapter);
    }

    private List<Integer> getPagesList() {
        List<Integer> pagesList = new ArrayList<>();
        for (int i = 1; i <= 604; i++) {
            int image = getResources().getIdentifier("a" + i, "drawable", getPackageName());
            pagesList.add(image);
        }
        return pagesList;
    }

    private void getSurahPageNumber() {
        int surahNumber = getIntent().getIntExtra(SURAH_NUMBER, 1);
        viewPager.setCurrentItem(surahNumber - 1);
    }
}