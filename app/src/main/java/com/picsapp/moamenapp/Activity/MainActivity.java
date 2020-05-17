package com.picsapp.moamenapp.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.picsapp.moamenapp.Fragment.EbadatFragment;
import com.picsapp.moamenapp.Fragment.HomeFragment;
import com.picsapp.moamenapp.Fragment.ImagesFragment;
import com.picsapp.moamenapp.Fragment.MoreFragment;
import com.picsapp.moamenapp.Fragment.VideosFragment;
import com.picsapp.moamenapp.R;
import java.util.Arrays;
import es.dmoral.toasty.Toasty;

/*
 * This class "MainActivity" for display fragments and more
 */
public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 0;

    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* make the status bar white with black icons */
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        /* make the app support only arabic "Right to left" */
        // even if the language of the device on english or others
        ViewCompat.setLayoutDirection(getWindow().getDecorView(),ViewCompat.LAYOUT_DIRECTION_RTL);

        /* To ask the user get allow the app for storage*/
        requestPermission();

        /* To create and display menu options after Long press on app icon */
        ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
        ShortcutInfo shortcut = new ShortcutInfo.Builder(MainActivity.this, "id1")
                .setShortLabel("بوت المؤمن")
                .setLongLabel("التطبيق على الماسنجر")
                .setIcon(Icon.createWithResource(MainActivity.this, R.drawable.messenger))
                .setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.me/MoamenApp/")))
                .build();
        shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut));

        /* methods to start new fragment */
        // make new object and find the view "BottomNavigationView"
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        // To make the first fragment shows when the app start.
        // We will ignore the "activity_main" and we will make new activity(fragment) called "fragment_home"
        // and we will add all views we want to display them on it.
        // (fragment_layout) it is a fragment have id was defined in "activity_main"
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,
                new HomeFragment()).commit();
        // make Listener to call the fragments on buttons
        // to start new fragment
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    // first fragment "home"
                    case R.id.home_item:
                        selectedFragment = new HomeFragment();
                        break;
                    // second fragment "videos"
                    case R.id.videos_item:
                        selectedFragment = new VideosFragment();
                        break;
                    // third fragment "ebadat"
                    case R.id.ebadat_item:
                        selectedFragment = new EbadatFragment();
                        break;
                    // fourth fragment "images"
                    case R.id.images_item:
                        selectedFragment = new ImagesFragment();
                        break;
                    // fifth fragment "more"
                    case R.id.settings_item:
                        selectedFragment = new MoreFragment();
                        break;
                }
                assert selectedFragment != null;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, selectedFragment).commit();
                return true;
            }

        });
    }

    /* allow the app for storage */
    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toasty.normal(MainActivity.this, "من فضلك قم بالسماح للتطبيق بتخزين الصور. لن يعمل التطبيق بشكل صحيح", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

}
