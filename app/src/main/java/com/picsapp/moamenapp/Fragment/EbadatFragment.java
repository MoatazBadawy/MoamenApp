package com.picsapp.moamenapp.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.picsapp.moamenapp.Adapter.CheckNetwork;
import com.picsapp.moamenapp.Adapter.IOnBackPressed;
import com.picsapp.moamenapp.R;

public class EbadatFragment extends Fragment implements IOnBackPressed {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ebadat, container, false);

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

        // Show the ProgressBar and then it disappears
        final ProgressBar
                progressBar = rootView.findViewById(R.id.loading_indicator1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.INVISIBLE);
            }
        }, 0700); // This 0.7 second

        if (CheckNetwork.isInternetAvailable(getActivity())) {  //returns true if internet available

        } else {
            BottomSheetBehavior mBottomSheetBehavior;
            ConstraintLayout mBottomsheet;
            // BottomSheetBehavior to make sheet bar
            mBottomsheet = rootView.findViewById(R.id.bottom_sheet_no_internet);
            mBottomSheetBehavior = BottomSheetBehavior.from(mBottomsheet);

            if (mBottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        }

        // Inflate the layout for this fragment
        return rootView;

    }

    //back to first fragment when press back
    @Override
    public boolean onBackPressed() {
        //do what you want
        HomeFragment nextFrag = new HomeFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout, nextFrag, "findThisFragment")
                .addToBackStack(null)
                .commit();

        return true;
    }
}
