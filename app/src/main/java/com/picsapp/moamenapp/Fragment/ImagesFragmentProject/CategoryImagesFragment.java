package com.picsapp.moamenapp.Fragment.ImagesFragmentProject;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.picsapp.moamenapp.ActivityProjects.ActivityDisplayImages.ImagesMoqAlaramActivity;
import com.picsapp.moamenapp.ActivityProjects.ActivityDisplayImages.ImagesMoqNabaweActivity;
import com.picsapp.moamenapp.R;

public class CategoryImagesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_images_category, container, false);

        /* make the app support only arabic "Right to left" */
        // even if the language of the device on english or others
        ViewCompat.setLayoutDirection(getActivity().getWindow().getDecorView(),ViewCompat.LAYOUT_DIRECTION_RTL);

        /* open new Activity when click in button */
        Button Nabawe = rootView.findViewById(R.id.button_nabawe);
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

        /* open new Activity when click in button */
        Button Haram = rootView.findViewById(R.id.button_kawbaaa);
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

        return rootView;
    }
}
