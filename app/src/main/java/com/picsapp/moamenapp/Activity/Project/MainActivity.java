package com.picsapp.moamenapp.Activity.Project;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.picsapp.moamenapp.Adapter.Picasso.IOnBackPressed;
import com.picsapp.moamenapp.Fragment.ImagesFragment;
import com.picsapp.moamenapp.Fragment.MoreFragment;
import com.picsapp.moamenapp.Fragment.QuranFragment;
import com.picsapp.moamenapp.Fragment.VideosFragment;
import com.picsapp.moamenapp.R;
import com.picsapp.moamenapp.home.ui.fragment.HomeFragment;

import java.util.Calendar;
import java.util.Collections;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView screenText;
    private static final int PERMISSION_REQUEST_CODE = 0;

    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTools();
        setShortcut();
        setScreenText();
        displayBottomNavigation();
        requestPermission();
    }

    private void setTools() {
        //make the status bar white with black icons
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        // make the app support only arabic "Right to left"
        // even if the language of the device on english or others
        ViewCompat.setLayoutDirection(getWindow().getDecorView(), ViewCompat.LAYOUT_DIRECTION_RTL);
    }

    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    private void setShortcut() {
        /* To create and display menu options after Long press on app icon */
        ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
        ShortcutInfo shortcut = new ShortcutInfo.Builder(MainActivity.this, "id1")
                .setShortLabel("بوت المؤمن")
                .setLongLabel("مليون مشترك")
                .setIcon(Icon.createWithResource(MainActivity.this, R.drawable.telegram))
                .setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.me/MoamenApp/")))
                .build();
        shortcutManager.setDynamicShortcuts(Collections.singletonList(shortcut));
    }

    private void setScreenText() {
        screenText = findViewById(R.id.screen_text);
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if(timeOfDay >= 7 && timeOfDay < 12){
            screenText.setText("لا تنسى أذكار الصباح");
        }
        else if(timeOfDay >= 12 && timeOfDay < 14){
            screenText.setText("سبحان الله وبحمده");
        }
        else if(timeOfDay >= 14 && timeOfDay < 16){
            screenText.setText("صلاتك حياتك");
        }
        else if(timeOfDay >= 16 && timeOfDay < 21){
            screenText.setText("لا تنسى أذكار المساء");
        }
        else if(timeOfDay >= 21){
            screenText.setText("لا تنسى قيام الليل");
        }
        else if(timeOfDay >= 4 && timeOfDay < 7){
            screenText.setText("لا تنسى صلاة الضحى");
        }
    }

    @SuppressLint("NonConstantResourceId")
    private void displayBottomNavigation() {
        // methods to start new fragment
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
        navigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            toolbar.setVisibility(View.VISIBLE);
            screenText.setVisibility(View.VISIBLE);
            switch (item.getItemId()) {
                // first fragment "home"
                case R.id.home_item:
                    selectedFragment = new HomeFragment();
                    break;
                // second fragment "videos"
                case R.id.videos_item:
                    // invisible toolbar in this frag
                    toolbar.setVisibility(View.INVISIBLE);
                    screenText.setVisibility(View.INVISIBLE);
                    selectedFragment = new VideosFragment();
                    break;
                // third fragment "ebadat"
                case R.id.ebadat_item:
                    // invisible toolbar in this frag
                    toolbar.setVisibility(View.INVISIBLE);
                    screenText.setVisibility(View.INVISIBLE);
                    selectedFragment = new MoreFragment();
                    break;
                // fourth fragment "images"
                case R.id.quran_item:
                    // invisible toolbar in this frag
                    toolbar.setVisibility(View.INVISIBLE);
                    screenText.setVisibility(View.INVISIBLE);
                    selectedFragment = new QuranFragment();
                    break;
                // fifth fragment "more"
                case R.id.image_item:
                    // invisible toolbar in this frag
                    toolbar.setVisibility(View.INVISIBLE);
                    screenText.setVisibility(View.INVISIBLE);
                    selectedFragment = new ImagesFragment();
                    break;
            }
            assert selectedFragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, selectedFragment).commit();

            return true;
        });

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        //NavigationView navigationView2 = findViewById(R.id.nav_view);
        //navigationView2.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        //drawer.openDrawer(Gravity.LEFT);
        toggle.syncState();
        // Change burger icon
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
    }

    private void requestPermission() {
        // allow the app for storage
        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toasty.normal(MainActivity.this, "من فضلك قم بالسماح للتطبيق بتخزين الصور. لن يعمل التطبيق بشكل صحيح", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    public static void setHomeItemBack(Activity activity) {
        //to select the right bottom navigation when press back
        BottomNavigationView bottomNavigationView = activity.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home_item);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed(); delete this line
        // and start your fragment:
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_layout);
        if (!(fragment instanceof IOnBackPressed)) {
            super.onBackPressed();
        }

        //to select the right bottom navigation when press back
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        int seletedItemId = bottomNavigationView.getSelectedItemId();
        if (R.id.home_item != seletedItemId) {
            setHomeItemBack(MainActivity.this);
        } else {
            super.onBackPressed();
        }
    }

}
