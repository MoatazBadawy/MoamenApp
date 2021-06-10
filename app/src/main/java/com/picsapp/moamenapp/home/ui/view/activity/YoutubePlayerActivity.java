package com.picsapp.moamenapp.home.ui.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.picsapp.moamenapp.databinding.ActivityYoutubePlayerBinding;
import com.picsapp.moamenapp.home.data.request.APIYoutubeKey;


import es.dmoral.toasty.Toasty;

public class YoutubePlayerActivity extends YouTubeBaseActivity {

    private ActivityYoutubePlayerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityYoutubePlayerBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        playYoutubeVideo();
        initializeViews();
    }

    private void initializeViews() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); // hide Status bar
    }

    private void playYoutubeVideo() {
        binding.youtubePlayerViewHome.initialize(
                APIYoutubeKey.API_YOUTUBE_KEY,
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(
                            YouTubePlayer.Provider provider,
                            YouTubePlayer youTubePlayer, boolean b) {
                        String videoId = getIntent().getExtras().getString("url");
                        youTubePlayer.loadVideo(videoId, 0);
                        youTubePlayer.setFullscreen(true);
                        youTubePlayer.play();
                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                        Toasty.normal(getApplicationContext(), "خطأ في التشغيل، يرجى إعادة المحاولة", Toast.LENGTH_SHORT).show();

                    }
                });
    }
}