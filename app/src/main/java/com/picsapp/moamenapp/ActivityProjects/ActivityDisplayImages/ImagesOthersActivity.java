package com.picsapp.moamenapp.ActivityProjects.ActivityDisplayImages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.picsapp.moamenapp.Adapter.PicassoDisplayImageAdapter;
import com.picsapp.moamenapp.Adapter.PicassoImagesAdapter;
import com.picsapp.moamenapp.R;

/*
 * This class for display Others images
 */
public class ImagesOthersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_images_others);

        /* make the status bar white with black icons */
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        /* make the app support only arabic "Right to left" */
        // even if the language of the device on english or others
        ViewCompat.setLayoutDirection(getWindow().getDecorView(),ViewCompat.LAYOUT_DIRECTION_RTL);

        /* back to last activity*/
        Button back_icon = findViewById(R.id.button_back4);
        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        /* Show the ProgressBar and then it disappears */
        final ProgressBar
                progressBar_images = findViewById(R.id.loading_indicator2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                progressBar_images.setVisibility(View.INVISIBLE);
            }
        }, 0700); // This 0.7 second

        /* ArrayList for RamadanImages */
        final String[] OthersImages = {
                "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg",
                "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg",
                "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg",
                "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg",
                "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg",
                "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg",
                "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg",
                "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg",
                "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg",
        };

        /* make new object and find the view "GridView" */
        GridView gridView = findViewById(R.id.gridview_image_others);
        // display all the images from Array on it
        gridView.setAdapter(new PicassoImagesAdapter(ImagesOthersActivity.this, OthersImages));

        /* display the image when click on it */
        // we made a class for this method called "PicassoDisplayImageAdapter"
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // get the image
                String image = OthersImages[position];
                Intent intent = new Intent(ImagesOthersActivity.this, PicassoDisplayImageAdapter.class);
                intent.putExtra("imageUrl", image);
                ImagesOthersActivity.this.startActivity(intent);
            }
        });

        /* Ads methods */
        // This call initializes the SDK and calls back a completion listener once
        // initialization is complete (or after a 30-second timeout). Call this method
        // only once and as early as possible, ideally at app launch.
        MobileAds.initialize(this, "ca-app-pub-4010171402649915~5502252008");
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
