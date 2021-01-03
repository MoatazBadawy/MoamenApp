package com.picsapp.moamenapp.Activity.Surah;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import com.picsapp.moamenapp.Adapter.Quran.ViewPagerSurahAdapter;
import com.picsapp.moamenapp.R;

public class QuranSurah2 extends AppCompatActivity {

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

        ImageIds = new String[]
        {
            // 1
            "https://i.ibb.co/ZVCwq0r/a2.jpg",
            // 2
            "https://i.ibb.co/kqLyvDz/a3.jpg",
            // 3
            "https://i.ibb.co/mrpn6YZ/a4.jpg",
            // 4
            "https://i.ibb.co/Z2qX47k/a5.jpg",
            // 5
            "https://i.ibb.co/mq7rPhJ/a6.jpg",
            // 6
            "https://i.ibb.co/y5cn89y/a7.jpg",
            // 7
            "https://i.ibb.co/9g05Mc1/a8.jpg",
            // 8
            "https://i.ibb.co/p2V1vxp/a9.jpg",
            // 9
            "https://i.ibb.co/N77f8vz/a10.jpg",
            // 10
            "https://i.ibb.co/p14nqv3/a11.jpg",
            // 11
            "https://i.ibb.co/JxLhWz1/a12.jpg",
            // 12
            "https://i.ibb.co/9gcgR54/a13.jpg",
            // 13
            "https://i.ibb.co/9VHDMms/a14.jpg",
            // 14
            "https://i.ibb.co/52hMw35/a15.jpg",
            // 15
            "https://i.ibb.co/2qVNfJf/a16.jpg",
            // 16
            "https://i.ibb.co/sRHvV01/a17.jpg",
            // 17
            "https://i.ibb.co/M7PCnnD/a18.jpg",
            // 18
            "https://i.ibb.co/dpNCR60/a19.jpg",
            // 19
            "https://i.ibb.co/qWD5Lyc/a20.jpg",
            // 20
            "https://i.ibb.co/bbKbcvm/a21.jpg",
            // 21
            "https://i.ibb.co/WxrZhLQ/a22.jpg",
            // 22
            "https://i.ibb.co/d5ypkWj/a23.jpg",
            // 23
            "https://i.ibb.co/kXyCtyP/a24.jpg",
            // 24
            "https://i.ibb.co/XJW3hjV/a25.jpg",
            // 25
            "https://i.ibb.co/yBNXCLJ/a26.jpg",
            // 26
            "https://i.ibb.co/ncC8wBG/a27.jpg",
            // 27
            "https://i.ibb.co/S08s0hK/a28.jpg",
            // 28
            "https://i.ibb.co/cLkf52T/a29.jpg",
            // 29
            "https://i.ibb.co/HpFwRZW/a30.jpg",
            // 30
            "https://i.ibb.co/vkbhkM4/a31.jpg",
            // 31
            "https://i.ibb.co/7vkrRYh/a32.jpg",
            // 32
            "https://i.ibb.co/nfvc8Pw/a33.jpg",
            // 33
            "https://i.ibb.co/vLjjzXR/a34.jpg",
            // 34
            "https://i.ibb.co/XFQLVmF/a35.jpg",
            // 35
            "https://i.ibb.co/RDgkjZF/a36.jpg",
            // 36
            "https://i.ibb.co/PjSfm7j/a37.jpg",
            // 37
            "https://i.ibb.co/Jxr02G2/a38.jpg",
            // 38
            "https://i.ibb.co/gFGD6BJ/a39.jpg",
            // 39
            "https://i.ibb.co/LxbBXhf/a40.jpg",
            // 40
            "https://i.ibb.co/s9HM7Nq/a41.jpg",
            // 41
            "https://i.ibb.co/JsjDW7P/a42.jpg",
            // 42
            "https://i.ibb.co/6W5dSMG/a43.jpg",
            // 43
            "https://i.ibb.co/GcbLkvH/a44.jpg",
            // 44
            "https://i.ibb.co/sQ3J92k/a45.jpg",
            // 45
            "https://i.ibb.co/30xW1g7/a46.jpg",
            // 46
            "https://i.ibb.co/m5Q8Wj9/a47.jpg",
            // 47
            "https://i.ibb.co/h9hJ4nn/a48.jpg",
            // 48
            "https://i.ibb.co/QcdjYB7/a49.jpg",
        };
    }

    // ViewPager includes ViewPagerAdapter
    private void ViewPager() {
        viewPager = findViewById(R.id.view_pager_quran_fateha);
        ViewPagerSurahAdapter adapter = new ViewPagerSurahAdapter(this, ImageIds);
        viewPager.setAdapter(adapter);
    }
}