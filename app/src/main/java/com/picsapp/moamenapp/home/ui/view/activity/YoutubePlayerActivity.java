package com.picsapp.moamenapp.home.ui.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.picsapp.moamenapp.databinding.ActivityYoutubePlayerBinding;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;

import org.jetbrains.annotations.NotNull;

public class YoutubePlayerActivity extends AppCompatActivity {

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
        // hide Status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void playYoutubeVideo() {
        binding.youtubePlayerViewHome.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = getIntent().getExtras().getString("url");
                youTubePlayer.loadVideo(videoId,0);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding.youtubePlayerViewHome.release();
    }
}