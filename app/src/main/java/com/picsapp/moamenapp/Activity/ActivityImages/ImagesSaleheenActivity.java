package com.picsapp.moamenapp.Activity.ActivityImages;

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
import com.picsapp.moamenapp.Fragment.ImagesFragmentProject.HomeImagesFragment;
import com.picsapp.moamenapp.R;

import java.util.Arrays;
import java.util.Collections;

/*
 * This class for display the Saleheen images
 */
public class ImagesSaleheenActivity extends AppCompatActivity implements Picasso.ItemClickListener {

    String[] SaleheenImages;
    private Picasso adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_saleheen);

        // make the status bar white with black icons
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        // make the app support only arabic "Right to left"
        // even if the language of the device on english or others
        ViewCompat.setLayoutDirection(getWindow().getDecorView(), ViewCompat.LAYOUT_DIRECTION_RTL);

        // back to last activity
        Button back_icon = findViewById(R.id.button_back_saleheen);
        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // ArrayList for Saleheen Images
        SaleheenImages = new String[]{
                // 1
                "https://mlpkhhqlr6vc.i.optimole.com/wFyunBg.nEnB~572a0/w:auto/h:auto/q:55/wm:87978:1:sowe:0:0:0.2/https://www.qallwdall.com/wp-content/uploads/2019/02/9.png",
                // 2
                "https://sportnewsps.com/content/uploads/2020/04/28/20ebf2fc33.jpg",
                // 3
                "https://3.bp.blogspot.com/-l49XMcefjRQ/XMm94lY36RI/AAAAAAAAMp0/ty--eWsSA3obK_zGaO_EpEsbFCyuBoHeQCLcBGAs/s640/%25D8%25A8%25D8%25A7%25D9%2582%25D8%25A9%2B%25D9%2588%25D8%25B1%25D8%25AF%2B%25D8%25B5%25D8%25A8%25D8%25A7%25D8%25AD%2B%25D8%25A7%25D9%2584%25D8%25AE%25D9%258A%25D8%25B13.jpg",
                // 4
                "https://pbs.twimg.com/media/BIWmhEgCAAAZQRu.jpg",
                // 5
                "https://2.bp.blogspot.com/-h_SE9HvurL4/XMm93PMMZbI/AAAAAAAAMpo/JwcCvDhP_bUhazc36vS-VU9annd3l7GCgCLcBGAs/s1600/%25D8%25A8%25D8%25A7%25D9%2582%25D8%25A9%2B%25D9%2588%25D8%25B1%25D8%25AF%2B%25D8%25B5%25D8%25A8%25D8%25A7%25D8%25AD%2B%25D8%25A7%25D9%2584%25D8%25AE%25D9%258A%25D8%25B11.jpg",
                // 6
                "https://i.pinimg.com/originals/68/d7/cd/68d7cdbbdfb2939cfb44eeed6d7e9448.jpg",
                // 7
                "https://pbs.twimg.com/media/BIWmhEgCAAAZQRu.jpg",
                // 8
                "https://i.pinimg.com/736x/71/b5/5d/71b55db26734a7823cf9b4d084af3745.jpg",
                // 9
                "https://www.magltk.com/wp-content/uploads/2017/04/%D9%85%D8%B3%D8%AC%D8%A7%D8%AA-%D8%A7%D9%84%D8%B5%D8%A8%D8%A7%D8%AD-%D9%84%D9%84%D8%AD%D8%A8%D9%8A%D8%A8.jpg",
                // 10
                "https://lh3.googleusercontent.com/MUEvQUy2CRziR0c0hUAxXLEI-H3_Y5krmN92jveg6slyBeq7-2ihGJlSTJth5yCEMUNA",
                // 11
                "https://www.a7lasabah.com/wp-content/uploads/2017/08/doaa%20good%20morning%20(1)-623x623.jpg",
                // 12
                "https://alamphoto.com/wp-content/uploads/2017/12/Good-evening-images-1.jpg",
                // 13
                "https://pbs.twimg.com/media/CuTD3PQXgAQ9qxL.jpg",
                // 14
                "https://pbs.twimg.com/media/EDqmBjNX4AAmR5g.jpg",
                // 15
                "https://upload.3dlat.net/uploads/3dlat.net_21_14_dd8a_59e3ff215f3302642669c5b6877a75c1.jpg",
                // 16
                "https://1.bp.blogspot.com/-EMgvc4mEfF0/WIju4RdQfOI/AAAAAAAAnlw/9pROYtGcbNkWzwFw5c5ARaLoAj5sa5_MQCLcB/s1600/good-evening-pictures4.jpg",
                // 17
                "https://rmze.cc/wp-content/uploads/2018/08/2704.jpg",
                // 18
                "https://pbs.twimg.com/media/DZP1VS0WsAIU6Lg.jpg",
                // 19
                "https://neswan.cc/wp-content/uploads/2018/07/2329.jpg",
                // 20
                "https://pbs.twimg.com/media/CIiBK9QUEAAA8mR.jpg",
                // 21
                "https://whatt.cc/wp-content/uploads/2018/07/3190.jpg",
                // 22
                "https://i.pinimg.com/564x/05/9c/e8/059ce8a558e7242085d49f15b22eb50e.jpg",
                // 23
                "https://www.edarabia.com/ar/wp-content/uploads/2018/09/most-beautiful-61-words-words-sweet-morning.jpg",
                // 24
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSRci1vD4Oz4aclvb_eGqLhE3Nsoie_jLmazxSD3eHtXKuoPIvr&usqp=CAU",
                // 25
                "https://a7sas.net/wp-content/uploads/2019/10/2373.jpg",
                // 26
                "https://picturess.cc/wp-content/uploads/2018/08/1007-6.jpg",
                // 27
                "https://carss.cc/wp-content/uploads/2018/08/3161.jpg",
                // 28
                "https://i.ytimg.com/vi/4z1dB28FIvk/maxresdefault.jpg",
                // 29
                "https://i.ytimg.com/vi/GpObpMlEgf8/maxresdefault.jpg",
                // 30
                "https://4.bp.blogspot.com/-8LbnDS2bJ7g/XMSZ6azeNLI/AAAAAAABkZw/T1Fl7RtyNuMn3PD3rVGqYLf4kebCTiwsgCLcBGAs/s400/3849-7.jpg",
                // 31
                "https://upload.3dlat.com/uploads/3dlat.net_14_17_1569_be7b9c586ad34.jpg",
                // 32
                "https://www.traidnt.net/vb/images/imgcache/2009/08/CbkZgG-11983384-1.jpg",
                // 33
                "https://ddreams.cc/wp-content/uploads/2018/11/6162.jpg",
                // 34
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQu97LGqcLWFX5NKFO5dzSMCZsneQDkiyMV2ftJLstKTM2awi4F&usqp=CAU",
                // 35
                "https://www.muhtwa.com/wp-content/uploads/%D8%B1%D8%B3%D8%A7%D8%A6%D9%84-%D9%88%D9%85%D8%B3%D8%AC%D8%A7%D8%AA-%D8%B5%D8%A8%D8%A7%D8%AD-%D8%A7%D9%84%D8%AE%D9%8A%D8%B14.jpg",
                // 36
                "https://i.pinimg.com/originals/9e/a1/75/9ea175d5ac2e5b4cabc99f944d077013.jpg",
                // 37
                "https://neswan.cc/wp-content/uploads/2020/03/6566.jpg",
                // 38
                "https://i.pinimg.com/originals/1b/3d/73/1b3d7339c33d7f6725a731af5bcc9011.jpg",
                // 39
                "https://i.pinimg.com/originals/55/3d/80/553d80b597241019ab40a7919944694f.jpg",
                // 40
                "https://image.winudf.com/v2/image/Y29tLnBhcmFkaXMua2hhbGZpYXQubWFzc2FhX3NjcmVlbl8yXzE1Mzg0MTUyMjJfMDU5/screen-2.jpg?fakeurl=1&type=.jpg",
                // 41
                "https://i.pinimg.com/originals/08/06/97/0806977903b27a10b21a6da345c5b0d9.jpg",
                // 42
                "https://ladybirdar.com/wp-content/uploads/2020/04/%D8%AE%D9%88%D8%A7%D8%B7%D8%B1-%D9%85%D8%B3%D8%A7%D8%A1-%D8%A7%D9%84%D8%AE%D9%8A%D8%B1-600x380.jpg",
                // 43
                "https://kisss.cc/wp-content/uploads/2018/07/4550.jpg",
                // 44
                "https://ladybirdar.com/wp-content/uploads/2019/06/%D8%AE%D9%88%D8%A7%D8%B7%D8%B1-%D9%85%D8%B3%D8%A7%D8%A1-%D8%A7%D9%84%D8%AE%D9%8A%D8%B1-%D9%84%D9%84%D8%A7%D8%B5%D8%AF%D9%82%D8%A7%D8%A1-600x380.jpg",
                // 45
                "https://na3em.cc/wp-content/uploads/2018/08/3551.jpg",
                // 46
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ2NE-b7IsqWY4JutVr6qnUqOENE6-1mLV7pjxs50g5HT1JFgiD&usqp=CAU",
                // 47
                "https://kisss.cc/wp-content/uploads/2018/06/3324.jpg",
                // 48
                "https://pbs.twimg.com/media/Cs0qQ7wXgAArZTD.jpg",
                // 49
                "https://jlmod.net/upload/items/42941490477932.jpg",
                // 50
                "https://ladybirdar.com/wp-content/uploads/2020/04/%D9%85%D8%B3%D8%A7%D8%A1-%D8%A7%D9%84%D8%AE%D9%8A%D8%B1-%D9%88%D8%A7%D9%84%D9%88%D8%B1%D8%AF-600x380.jpg",
                // 51
                "https://2.bp.blogspot.com/-Vm5N96sV7t8/VO920nfSu_I/AAAAAAAAd10/BZrAPcL27Yo/w600/0c4ace5a6a4c35a9fefa2a57d8ab8cfd.jpg",
                // 52
                "https://m.3bir.net/files/5270d5c165.png",
                // 53
                "https://knoww.cc/wp-content/uploads/2018/08/403.jpg",
                // 54
                "https://www.traidnt.net/vb/images/imgcache/2007/06/bagZ7D-4460225-1.png",
                // 55
                "https://pbs.twimg.com/media/EHYr9euWoAIx7Up.jpg",
                // 56
                "https://i.pinimg.com/736x/71/b5/5d/71b55db26734a7823cf9b4d084af3745.jpg",
                // 57
                "https://live.staticflickr.com/2900/14235300015_b1281e586c_z.jpg",
                // 58
                "https://3.bp.blogspot.com/-5Xz5v70e9Do/WkFQuZ_LIbI/AAAAAAAAJh0/Ehj9DJj-85UhVkeFdW6kldaNHsur7heWACLcBGAs/s1600/%25D9%2585%25D8%25B3%25D8%25A7%25D8%25A1%2B%25D8%25A7%25D9%2584%25D8%25AE%25D9%258A%25D8%25B14.jpg",
                // 59
                "https://pbs.twimg.com/media/C4MnpXzWYAAXbBV.jpg",
                // 60
                "https://www.rjeem.com/wp-content/uploads/2019/06/12d81238e2caca63dda0eb2afd5e67f7.jpg",
        };

        // make new object and find the view "recyclerView"
        RecyclerView recyclerView = findViewById(R.id.recyclerview_image_saleheen);
        // Calculate the items and auto-fit it on the screen
        int mNoOfColumns = HomeImagesFragment.Utility.calculateNoOfColumns(this, 140);
        recyclerView.setLayoutManager(new GridLayoutManager(this, mNoOfColumns));
        adapter = new Picasso(this, SaleheenImages);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        // change the adapter at random
        Collections.shuffle(Arrays.asList(SaleheenImages));

        // Ads methods
        // This call initializes the SDK and calls back a completion listener once
        // initialization is complete (or after a 30-second timeout). Call this method
        // only once and as early as possible, ideally at app launch.
        MobileAds.initialize(this, "ca-app-pub-4010171402649915~5502252008");
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView mAdView = findViewById(R.id.adViewSaleheen);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    // OnClick listener to display the image when click on it
    @Override
    public void onItemClick(View view, int position) {
        // get the image
        String image = SaleheenImages[position];
        Intent intent = new Intent(this, PicassoDisplayOtherImages.class);
        intent.putExtra("imageUrl", image);
        // to not repeat the image when click on it many times
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    // Calculate the items and auto-fit it on the screen
    public static class Utility {
        public static int calculateNoOfColumns(Context context, float columnWidthDp) { // For example columnWidthdp=180
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
            int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
            return noOfColumns;
        }
    }
}
