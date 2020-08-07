package com.picsapp.moamenapp.Activity.ImagesActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.picsapp.moamenapp.Adapter.Picasso.Picasso;
import com.picsapp.moamenapp.Adapter.Picasso.PicassoDisplayOtherImages;
import com.picsapp.moamenapp.Adapter.Picasso.PicassoDisplayWallpaperImage;
import com.picsapp.moamenapp.Fragment.ImagesFragmentProject.HomeImagesFragment;
import com.picsapp.moamenapp.R;
import com.r0adkll.slidr.Slidr;

import java.util.Arrays;
import java.util.Collections;

public class ImagesErtugleActivity extends AppCompatActivity implements Picasso.ItemClickListener {

    String[] ErtugleImages;
    private Picasso adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_ertugle);

        // make the status bar white with black icons
        CoustomStateBar();

        // make the app support only arabic "Right to left"
        SupportArabic();

        // back to last activity
        BackToLastActivity();

        // ArrayList for the images
        ArrayListImages();

        // make new object and find the view "recyclerView"
        RecyclerView recyclerView = findViewById(R.id.recyclerview_image_Ertugle);
        // Calculate the items and auto-fit it on the screen
        // please note: make the columnWidthDp like what you have in list_image.xml "the image width", to make good fill in all screen sizes
        int mNoOfColumns = HomeImagesFragment.Utility.calculateNoOfColumns(this, 120);
        recyclerView.setLayoutManager(new GridLayoutManager(this, mNoOfColumns));
        adapter = new Picasso(this, ErtugleImages);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        // change the adapter at random
        Collections.shuffle(Arrays.asList(ErtugleImages));

        // slider the activity
        Slider();

        // Ads
        Ads();
    }

    // make the status bar white with black icons
    public void CoustomStateBar() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    // make the app support only arabic "Right to left"
    public void SupportArabic() {
        // even if the language of the device on english or others
        ViewCompat.setLayoutDirection(getWindow().getDecorView(), ViewCompat.LAYOUT_DIRECTION_RTL);
    }

    // back to last activity
    public void BackToLastActivity() {
        Button back_icon = findViewById(R.id.button_back_Ertugle);
        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    // ArrayList that's have the images
    public void ArrayListImages() {
        // ArrayList for Ertugle Images
        ErtugleImages = new String[]{
                // 1
                "https://i.ibb.co/jL4MFzS/1.jpg",
                // 2
                "https://i.ibb.co/qx57w1L/2.jpg",
                // 3
                "https://i.ibb.co/CJQsgnM/3.jpg",
                // 4
                "https://i.ibb.co/p4rq3gR/4.jpg",
                // 5
                "https://i.ibb.co/m5Jr0jm/5.jpg",
                // 6
                "https://i.ibb.co/10D3chx/6.png",
                // 7
                "https://i.ibb.co/D47NW6h/7.jpg",
                // 8
                "https://i.ibb.co/PNHxp27/8.jpg",
                // 9
                "https://i.ibb.co/tMvtNQh/9.jpg",
                // 10
                "https://i.ibb.co/MD0c8NC/10.jpg",
                // 11
                "https://i.ibb.co/GQs8fnr/11.jpg",
                // 12
                "https://i.ibb.co/KXWcB6y/12.jpg",
                // 13
                "https://i.ibb.co/QKgc4Md/13.jpg",
                // 14
                "https://i.ibb.co/Fz5nN4t/14.jpg",
                // 15
                "https://i.ibb.co/fFk5TVW/15.jpg",
                // 16
                "https://i.ibb.co/DGhRxVH/16.jpg",
                // 17
                "https://i.ibb.co/YB0fyg7/17.jpg",
                // 18
                "https://i.ibb.co/9Zx5rhS/41.jpg",
                // 19
                "https://i.ibb.co/H2Y880w/19.jpg",
                // 20
                "https://i.ibb.co/Db3mnKv/20.jpg",
                // 21
                "https://i.ibb.co/BygQxXJ/21.jpg",
                // 22
                "https://i.ibb.co/5rdGT2t/22.jpg",
                // 23
                "https://i.ibb.co/ncSb9D0/23.jpg",
                // 24
                "https://i.ibb.co/P52zwKq/24.jpg",
                // 25
                "https://i.ibb.co/dWH3CLz/25.jpg",
                // 26
                "https://i.ibb.co/wd5SyGZ/26.jpg",
                // 27
                "https://i.ibb.co/72PKN8Q/27.jpg",
                // 28
                "https://i.ibb.co/m037JXQ/28.jpg",
                // 29
                "https://i.ibb.co/8Nvtgxr/29.png",
                // 30
                "https://i.ibb.co/4JKrhPr/30.jpg",
                // 31
                "https://i.ibb.co/LkPZx1m/31.jpg",
                // 32
                "https://i.ibb.co/KLRrBGH/32.jpg",
                // 33
                "https://i.ibb.co/CsMvSHJ/33.jpg",
                // 34
                "https://i.ibb.co/wc22N55/34.jpg",
                // 35
                "https://i.ibb.co/w4dxvyZ/35.jpg",
                // 36
                "https://i.ibb.co/34D5S9G/36.jpg",
                // 37
                "https://i.ibb.co/1Xzd3Yd/38.jpg",
                // 38
                "https://i.ibb.co/hfcdkHq/39.jpg",
                // 39
                "https://i.ibb.co/NZWCdV4/40.jpg",
        };
    }

    // Make slider on the Activity
    public void Slider() {
        Slidr.attach(this);
    }

    // OnClick listener to display the image when click on it
    @Override
    public void onItemClick(View view, int position) {
        // get the image
        String image = ErtugleImages[position];
        Intent intent = new Intent(this, PicassoDisplayWallpaperImage.class);
        intent.putExtra("imageUrl", image);
        // to not repeat the image when click on it many times
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    // Ads method
    public void Ads() {

        // Ads method
        // This call initializes the SDK and calls back a completion listener once
        // initialization is complete (or after a 30-second timeout). Call this method
        // only once and as early as possible, ideally at app launch.
        MobileAds.initialize(this, "ca-app-pub-4010171402649915~5502252008");
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView mAdView = findViewById(R.id.adViewErtugle);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    // Calculate the items and auto-fit it on the screen
    public static class Utility {
        public static int calculateNoOfColumns(Context context, float columnWidthDp) { // For example columnWidthdp=180
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
            return (int) (screenWidthDp / columnWidthDp + 0.5);
        }
    }
}