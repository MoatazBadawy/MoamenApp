package com.picsapp.moamenapp.Fragment.Images;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.picsapp.moamenapp.Activity.Category.ImagesAqsaActivity;
import com.picsapp.moamenapp.Activity.Category.ImagesDowaaActivity;
import com.picsapp.moamenapp.Activity.Category.ImagesErtugleActivity;
import com.picsapp.moamenapp.Activity.Category.ImagesIslamActivity;
import com.picsapp.moamenapp.Activity.Category.ImagesMoqNabaweActivity;
import com.picsapp.moamenapp.Activity.Category.ImagesMorningActivity;
import com.picsapp.moamenapp.Activity.Category.ImagesOthersActivity;
import com.picsapp.moamenapp.Activity.Category.ImagesRamadanActivity;
import com.picsapp.moamenapp.Activity.Category.ImagesSaleheenActivity;
import com.picsapp.moamenapp.Activity.Category.ImagesZahrahActivity;
import com.picsapp.moamenapp.R;

public class CategoryImagesFragment extends Fragment {

    View rootView;
    Button Ertgrul, Islam, Saleheen, Others, Morning, Dowaa, Aqsa, Nabawe, Zahraa, Ramadan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_images_category, container, false);

        // buttons click "Open new Activity"
        ButtonClick();

        return rootView;
    }

    // buttons click "Open new Activity"
    public void ButtonClick () {

        Ertgrul = rootView.findViewById(R.id.button_ertugrel_category);
        Ertgrul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesDowaaActivity}
                Intent Intent = new Intent(getActivity(), ImagesErtugleActivity.class);
                // Start the new activity
                startActivity(Intent);
            }
        });

        Islam = rootView.findViewById(R.id.button_islam_category);
        Islam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesDowaaActivity}
                Intent Intent = new Intent(getActivity(), ImagesIslamActivity.class);
                // Start the new activity
                startActivity(Intent);
            }
        });

        Saleheen = rootView.findViewById(R.id.button_saleheen_category);
        Saleheen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesDowaaActivity}
                Intent Intent = new Intent(getActivity(), ImagesSaleheenActivity.class);
                // Start the new activity
                startActivity(Intent);
            }
        });

        Others = rootView.findViewById(R.id.button_others_category);
        Others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesDowaaActivity}
                    Intent Intent = new Intent(getActivity(), ImagesOthersActivity.class);
                // Start the new activity
                startActivity(Intent);
            }
        });

        Morning = rootView.findViewById(R.id.button_morning_category);
        Morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesDowaaActivity}
                Intent Intent = new Intent(getActivity(), ImagesMorningActivity.class);
                // Start the new activity
                startActivity(Intent);
            }
        });

        Dowaa = rootView.findViewById(R.id.button_dowaa_category);
        Dowaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesDowaaActivity}
                Intent Intent = new Intent(getActivity(), ImagesDowaaActivity.class);
                // Start the new activity
                startActivity(Intent);
            }
        });

        Aqsa = rootView.findViewById(R.id.button_aqsa_category);
        Aqsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesDowaaActivity}
                Intent Intent = new Intent(getActivity(), ImagesAqsaActivity.class);
                // Start the new activity
                startActivity(Intent);
            }
        });

        Nabawe = rootView.findViewById(R.id.button_nabawe_category);
        Nabawe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesDowaaActivity}
                Intent Intent = new Intent(getActivity(), ImagesMoqNabaweActivity.class);
                // Start the new activity
                startActivity(Intent);
            }
        });

        Zahraa = rootView.findViewById(R.id.button_zahrah_category);
        Zahraa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesDowaaActivity}
                Intent Intent = new Intent(getActivity(), ImagesZahrahActivity.class);
                // Start the new activity
                startActivity(Intent);
            }
        });

        Ramadan = rootView.findViewById(R.id.button_ramadan_category);
        Ramadan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesDowaaActivity}
                Intent Intent = new Intent(getActivity(), ImagesRamadanActivity.class);
                // Start the new activity
                startActivity(Intent);
            }
        });
    }

}
