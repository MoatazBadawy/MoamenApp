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
import android.widget.Button;
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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

    final Fragment fragment1 = new HomeFragment();
    final Fragment fragment2 = new VideosFragment();
    final Fragment fragment3 = new MoreFragment();
    final Fragment fragment4 = new QuranFragment();
    final Fragment fragment5 = new ImagesFragment();

    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;

    private Toolbar toolbar;
    private TextView screenText;
    private Button toolBarMessenger;
    private static final int PERMISSION_REQUEST_CODE = 0;

    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();
        setShortcut();
        setScreenText();
        initializeBottomNavigation();
        requestPermission();
    }

    private void initializeView() {
        //make the status bar white with black icons
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        // make the app support only arabic "Right to left", even if the language of the device on english or others
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
    private void initializeBottomNavigation() {
        // first one transaction to add each Fragment
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_layout, fragment5, "5").hide(fragment5);
        ft.add(R.id.fragment_layout, fragment4, "4").hide(fragment4);
        ft.add(R.id.fragment_layout, fragment3, "3").hide(fragment3);
        ft.add(R.id.fragment_layout, fragment2, "2").hide(fragment2);
        ft.add(R.id.fragment_layout, fragment1, "1");
        // commit once! to finish the transaction
        ft.commit();

        // show and hide them when click on BottomNav items
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(item -> {
            // start a new transaction
            FragmentTransaction ft1 = fm.beginTransaction();
            // animations
            switch (item.getItemId()) {
                case R.id.home_item:
                    ft1.hide(active).show(fragment1).commit();
                    toolbar.setVisibility(View.VISIBLE);
                    screenText.setVisibility(View.VISIBLE);
                    toolBarMessenger.setVisibility(View.VISIBLE);
                    active = fragment1;
                    return true;

                case R.id.videos_item:
                    ft1.hide(active).show(fragment2).commit();
                    // invisible toolbar in this frag
                    toolbar.setVisibility(View.INVISIBLE);
                    screenText.setVisibility(View.INVISIBLE);
                    toolBarMessenger.setVisibility(View.INVISIBLE);
                    active = fragment2;
                    return true;

                case R.id.ebadat_item:
                    ft1.hide(active).show(fragment3).commit();
                    // invisible toolbar in this frag
                    toolbar.setVisibility(View.INVISIBLE);
                    screenText.setVisibility(View.INVISIBLE);
                    toolBarMessenger.setVisibility(View.INVISIBLE);
                    active = fragment3;
                    return true;

                case R.id.quran_item:
                    ft1.hide(active).show(fragment4).commit();
                    // invisible toolbar in this frag
                    toolbar.setVisibility(View.INVISIBLE);
                    screenText.setVisibility(View.INVISIBLE);
                    toolBarMessenger.setVisibility(View.INVISIBLE);
                    active = fragment4;
                    return true;

                case R.id.image_item:
                    ft1.hide(active).show(fragment5).commit();
                    // invisible toolbar in this frag
                    toolbar.setVisibility(View.INVISIBLE);
                    screenText.setVisibility(View.INVISIBLE);
                    toolBarMessenger.setVisibility(View.INVISIBLE);
                    active = fragment5;
                    return true;
            }
            return false;
        });

        toolbar = findViewById(R.id.toolbar);
        toolBarMessenger = findViewById(R.id.toolbar_messenger);
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
