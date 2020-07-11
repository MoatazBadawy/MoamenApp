package com.picsapp.moamenapp.Fragment.Quran;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

import com.picsapp.moamenapp.R;

public class QuranSearchFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_quran_search, container, false);

        // display WebView "Quran Search"
        final WebView mWebView = rootView.findViewById(R.id.web_view_quran);
        mWebView.loadUrl("https://lookquran.com/?fbclid=IwAR2-na0YxAK2ZmkTBesGyo_kNr07CZGnInt1OLJr-TKXqu-k642_hbSbI5w");
        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // To close WebView when go back
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (url.endsWith("#closeWebview")) {
                    mWebView.setVisibility(View.GONE);
                }
            }
        });

        // Inflate the layout for this fragment
        return rootView;

    }
}