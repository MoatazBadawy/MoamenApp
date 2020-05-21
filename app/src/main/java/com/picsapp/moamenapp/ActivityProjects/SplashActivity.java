package com.picsapp.moamenapp.ActivityProjects;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.picsapp.moamenapp.Activity.MainActivity;
import com.picsapp.moamenapp.R;

/*
 * This class for display Splash screen
 */
public class SplashActivity extends AppCompatActivity {

    /* make variable to set times */
    // time of display
    int SPLASH_TIME = 600; //This is 0.6 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);

        /* make the status bar white with black icons */
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        /* code to start timer and take action after the timer ends */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // do any action here.
                // now we are moving to next page
                Intent mySuperIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mySuperIntent);

                // this 'finish()' is for exiting the app when back button pressed from Home page which is MainActivity
                finish();
            }
        }, SPLASH_TIME);
    }
}