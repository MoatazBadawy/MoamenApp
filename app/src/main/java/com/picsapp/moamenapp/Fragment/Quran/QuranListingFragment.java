package com.picsapp.moamenapp.Fragment.Quran;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.picsapp.moamenapp.Activity.Project.MainActivity;
import com.picsapp.moamenapp.Adapter.SongItemMain;
import com.picsapp.moamenapp.Adapter.SongItemMainAdapter;
import com.picsapp.moamenapp.R;

import java.util.ArrayList;

public class QuranListingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_quran_listing, container, false);

        //****** ArrayList for songs list 1 ****//
        ArrayList<SongItemMain> songListDetails = new ArrayList<SongItemMain>();
        songListDetails.add(new SongItemMain(R.drawable.hasbi1, "Mood Booster"));
        songListDetails.add(new SongItemMain(R.drawable.kun1, "Confidence Boost"));
        songListDetails.add(new SongItemMain(R.drawable.insan1, "Happy Beats"));
        songListDetails.add(new SongItemMain(R.drawable.medina1, "Feelin' Myself"));

        // set up the RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.rv_song_list1);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        SongItemMainAdapter adapter = new SongItemMainAdapter(getActivity(), songListDetails);
        recyclerView.setAdapter(adapter);


        //****** ArrayList for songs list 2 ****//
        ArrayList<SongItemMain> songListDetails2 = new ArrayList<SongItemMain>();
        songListDetails2.add(new SongItemMain(R.drawable.ya1, "Happy Mode"));
        songListDetails2.add(new SongItemMain(R.drawable.muhammad1, "Daily Lift"));
        songListDetails2.add(new SongItemMain(R.drawable.ramadan1, "Motivation Mix"));
        songListDetails2.add(new SongItemMain(R.drawable.qamarun1, "Mood Booster"));
        // set up the RecyclerView
        RecyclerView recyclerView2 = rootView.findViewById(R.id.rv_song_list2);
        LinearLayoutManager horizontalLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(horizontalLayoutManager2);
        SongItemMainAdapter adapter2 = new SongItemMainAdapter(getContext(), songListDetails2);
        recyclerView2.setAdapter(adapter2);


        //****** ArrayList for songs list 3 ****//
        ArrayList<SongItemMain> songListDetails3 = new ArrayList<SongItemMain>();
        songListDetails3.add(new SongItemMain(R.drawable.kwater1, "Pumped Pop"));
        songListDetails3.add(new SongItemMain(R.drawable.medina1, "Mega Hit Mix"));
        songListDetails3.add(new SongItemMain(R.drawable.qamarun1, "Sing in teh car"));
        songListDetails3.add(new SongItemMain(R.drawable.kun1, "Lo-Fi Beats"));
        // set up the RecyclerView
        RecyclerView recyclerView3 = rootView.findViewById(R.id.rv_song_list3);
        LinearLayoutManager horizontalLayoutManager3 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(horizontalLayoutManager3);
        SongItemMainAdapter adapter3 = new SongItemMainAdapter(getContext(), songListDetails3);
        recyclerView3.setAdapter(adapter3);


        //****** ArrayList for songs list 4 ****//
        ArrayList<SongItemMain> songListDetails4 = new ArrayList<SongItemMain>();
        songListDetails4.add(new SongItemMain(R.drawable.qamarun1, "Daily Mix1"));
        songListDetails4.add(new SongItemMain(R.drawable.ramadan1, "Top today"));
        songListDetails4.add(new SongItemMain(R.drawable.kwater1, "Release Radar"));
        songListDetails4.add(new SongItemMain(R.drawable.qiyam1, "Discover Weekly"));
        // set up the RecyclerView
        RecyclerView recyclerView4 = rootView.findViewById(R.id.rv_song_list4);
        LinearLayoutManager horizontalLayoutManager4 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView4.setLayoutManager(horizontalLayoutManager4);
        SongItemMainAdapter adapter4 = new SongItemMainAdapter(getContext(), songListDetails4);
        recyclerView4.setAdapter(adapter4);


        //****** ArrayList for songs list 5 ****//
        ArrayList<SongItemMain> songListDetails5 = new ArrayList<SongItemMain>();
        songListDetails5.add(new SongItemMain(R.drawable.insan1, "Today's Top Hits"));
        songListDetails5.add(new SongItemMain(R.drawable.qamarun1, "Islamic song"));
        songListDetails5.add(new SongItemMain(R.drawable.kun1, "Cool Songs"));
        songListDetails5.add(new SongItemMain(R.drawable.hasbi1, "Hit Rewind"));
        // set up the RecyclerView
        RecyclerView recyclerView5 = rootView.findViewById(R.id.rv_song_list5);
        LinearLayoutManager horizontalLayoutManager5 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView5.setLayoutManager(horizontalLayoutManager5);
        SongItemMainAdapter adapter5 = new SongItemMainAdapter(getContext(), songListDetails5);
        recyclerView5.setAdapter(adapter5);


        //****** ArrayList for songs list 6 ****//
        ArrayList<SongItemMain> songListDetails6 = new ArrayList<SongItemMain>();
        songListDetails6.add(new SongItemMain(R.drawable.medina1, "A Perfect Day"));
        songListDetails6.add(new SongItemMain(R.drawable.muhammad1, "Good People"));
        songListDetails6.add(new SongItemMain(R.drawable.qamarun1, "Sunny Day"));
        songListDetails6.add(new SongItemMain(R.drawable.kun1, "Mood Booster"));
        // set up the RecyclerView
        RecyclerView recyclerView6 = rootView.findViewById(R.id.rv_song_list6);
        LinearLayoutManager horizontalLayoutManager6 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView6.setLayoutManager(horizontalLayoutManager6);
        SongItemMainAdapter adapter6 = new SongItemMainAdapter(getContext(), songListDetails6);
        recyclerView6.setAdapter(adapter6);

        // Inflate the layout for this fragment
        return rootView;
    }
}