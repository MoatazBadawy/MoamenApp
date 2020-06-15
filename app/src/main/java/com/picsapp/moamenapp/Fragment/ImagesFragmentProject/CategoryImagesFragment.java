package com.picsapp.moamenapp.Fragment.ImagesFragmentProject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import com.picsapp.moamenapp.Activity.ActivityImages.ImagesAqsaActivity;
import com.picsapp.moamenapp.Activity.ActivityImages.ImagesDowaaActivity;
import com.picsapp.moamenapp.Activity.ActivityImages.ImagesMoqAlaramActivity;
import com.picsapp.moamenapp.Activity.ActivityImages.ImagesMoqNabaweActivity;
import com.picsapp.moamenapp.Activity.ActivityImages.ImagesMorningActivity;
import com.picsapp.moamenapp.Activity.ActivityImages.ImagesOthersActivity;
import com.picsapp.moamenapp.Activity.ActivityImages.ImagesRamadanActivity;
import com.picsapp.moamenapp.Activity.ActivityImages.ImagesSaleheenActivity;
import com.picsapp.moamenapp.R;

public class CategoryImagesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_images_category, container, false);

        /* make the app support only arabic "Right to left" */
        // even if the language of the device on english or others
        ViewCompat.setLayoutDirection(getActivity().getWindow().getDecorView(), ViewCompat.LAYOUT_DIRECTION_RTL);

        /* open new Activity when click in button */
        Button Morning = rootView.findViewById(R.id.button_morrining_image_category);
        // Set a click listener on that View
        Morning.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesMoqNabaweActivity}
                Intent ImagesMoqAlaramIntent = new Intent(getActivity(), ImagesMorningActivity.class);
                // Start the new activity
                startActivity(ImagesMoqAlaramIntent);
            }
        });

        Button Dowaa = rootView.findViewById(R.id.button_dowaa_image_category);
        // Set a click listener on that View
        Dowaa.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesMoqNabaweActivity}
                Intent ImagesMoqAlaramIntent = new Intent(getActivity(), ImagesDowaaActivity.class);
                // Start the new activity
                startActivity(ImagesMoqAlaramIntent);
            }
        });

        Button Saleheen = rootView.findViewById(R.id.button_saleheen_image_category);
        // Set a click listener on that View
        Saleheen.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesMoqNabaweActivity}
                Intent ImagesMoqAlaramIntent = new Intent(getActivity(), ImagesSaleheenActivity.class);
                // Start the new activity
                startActivity(ImagesMoqAlaramIntent);
            }
        });

        Button Aqsa = rootView.findViewById(R.id.button_aqsa_image_category);
        // Set a click listener on that View
        Aqsa.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesMoqNabaweActivity}
                Intent ImagesMoqAlaramIntent = new Intent(getActivity(), ImagesAqsaActivity.class);
                // Start the new activity
                startActivity(ImagesMoqAlaramIntent);
            }
        });

        Button Others = rootView.findViewById(R.id.button_others_image_category);
        // Set a click listener on that View
        Others.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesMoqNabaweActivity}
                Intent ImagesMoqAlaramIntent = new Intent(getActivity(), ImagesOthersActivity.class);
                // Start the new activity
                startActivity(ImagesMoqAlaramIntent);
            }
        });

        Button Nabawe = rootView.findViewById(R.id.button_nabawe_image_category);
        // Set a click listener on that View
        Nabawe.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesMoqNabaweActivity}
                Intent ImagesMoqAlaramIntent = new Intent(getActivity(), ImagesMoqNabaweActivity.class);
                // Start the new activity
                startActivity(ImagesMoqAlaramIntent);
            }
        });

        Button Haram = rootView.findViewById(R.id.button_haram_image_category);
        // Set a click listener on that View
        Haram.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesMoqAlaramActivity}
                Intent ImagesMoqAlaramIntent = new Intent(getActivity(), ImagesMoqAlaramActivity.class);
                // Start the new activity
                startActivity(ImagesMoqAlaramIntent);
            }
        });

        Button Ramadan = rootView.findViewById(R.id.button_ramadan_image_category);
        // Set a click listener on that View
        Ramadan.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesMoqNabaweActivity}
                Intent ImagesMoqAlaramIntent = new Intent(getActivity(), ImagesRamadanActivity.class);
                // Start the new activity
                startActivity(ImagesMoqAlaramIntent);
            }
        });

        return rootView;
    }
}
