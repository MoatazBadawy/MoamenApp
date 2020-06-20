package com.picsapp.moamenapp.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.picsapp.moamenapp.Adapter.IOnBackPressed;
import com.picsapp.moamenapp.R;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;


public class HomeFragment extends Fragment implements IOnBackPressed {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);


        final KonfettiView viewKonfetti = rootView.findViewById(R.id.viewKonfetti);
        Button clcik = rootView.findViewById(R.id.jejek);

        // display celebration papers when click the button :D */
        clcik.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                viewKonfetti.build()
                        .addColors(Color.YELLOW, Color.MAGENTA, Color.RED)
                        .setDirection(0.0, 359.0)
                        .setSpeed(1f, 5f)
                        .setFadeOutEnabled(true)
                        .setTimeToLive(2000L)
                        .addShapes(Shape.RECT, Shape.CIRCLE)
                        .addSizes(new Size(12, 5))
                        .setPosition(-50f, viewKonfetti.getWidth() + 50f, -50f, -50f)
                        .streamFor(200, 5000L);
            }
        });

        return rootView;
    }

    //exit the app when press back
    @Override
    public boolean onBackPressed() {
        //exit the app when press back
        getActivity().moveTaskToBack(true);
        getActivity().finish();
        return true;
    }

}
