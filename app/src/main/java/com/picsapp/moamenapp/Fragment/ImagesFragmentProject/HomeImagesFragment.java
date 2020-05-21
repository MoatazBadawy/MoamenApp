package com.picsapp.moamenapp.Fragment.ImagesFragmentProject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import com.picsapp.moamenapp.ActivityProjects.ActivityDisplayImages.ImagesAqsaActivity;
import com.picsapp.moamenapp.ActivityProjects.ActivityDisplayImages.ImagesMorningActivity;
import com.picsapp.moamenapp.ActivityProjects.ActivityDisplayImages.ImagesOthersActivity;
import com.picsapp.moamenapp.ActivityProjects.ActivityDisplayImages.ImagesRamadanActivity;
import com.picsapp.moamenapp.ActivityProjects.ActivityDisplayImages.ImagesSaleheenActivity;
import com.picsapp.moamenapp.Adapter.PicassoDisplayImageAdapter;
import com.picsapp.moamenapp.Adapter.PicassoImagesAdapter;
import com.picsapp.moamenapp.R;

public class HomeImagesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_images_home, container, false);

        /* set new variables to Button views "the views on top bar that's will open new activity" */
        Button Ramadan, Others, AQSA, Salehen, all;

        /* make the app support only arabic "Right to left" */
        // even if the language of the device on english or others
        ViewCompat.setLayoutDirection(getActivity().getWindow().getDecorView(), ViewCompat.LAYOUT_DIRECTION_RTL);

        /* open new Activity when click in button */
        Ramadan = rootView.findViewById(R.id.button_dowaa_image_category);
        // Set a click listener on that View
        Ramadan.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesRamadanActivity}
                Intent Intent = new Intent(getActivity(), ImagesRamadanActivity.class);
                // Start the new activity
                startActivity(Intent);
            }
        });

        AQSA = rootView.findViewById(R.id.button3_aqsa);
        // Set a click listener on that View
        AQSA.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesAqsaActivity}
                Intent Intent = new Intent(getActivity(), ImagesAqsaActivity.class);
                // Start the new activity
                startActivity(Intent);
            }
        });

        Salehen = rootView.findViewById(R.id.button2_saleheen);
        // Set a click listener on that View
        Salehen.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesSaleheenActivity}
                Intent Intent = new Intent(getActivity(), ImagesSaleheenActivity.class);
                // Start the new activity
                startActivity(Intent);
            }
        });

        Others = rootView.findViewById(R.id.button6_others);
        // Set a click listener on that View
        Others.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesOthersActivity}
                Intent Intent = new Intent(getActivity(), ImagesOthersActivity.class);
                // Start the new activity
                startActivity(Intent);
            }
        });

        all = rootView.findViewById(R.id.button6_morining);
        // Set a click listener on that View
        all.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ImagesDowaaActivity}
                Intent Intent = new Intent(getActivity(), ImagesMorningActivity.class);
                // Start the new activity
                startActivity(Intent);
            }
        });

        /* ArrayList for chooseImages */
        final String[] chooseImages = {
                "https://i1.wp.com/www.newphotodownload.info/wp-content/uploads/2018/12/%D8%A8%D9%88%D8%B3%D8%AA%D8%A7%D8%AA-%D8%AF%D9%8A%D9%86%D9%8A%D8%A9-61-1.jpg",
                "https://quotess.cc/wp-content/uploads/2020/01/4688.jpg",
                "https://whatt.cc/wp-content/uploads/2018/07/4443.jpg",
                "https://i1.wp.com/www.newphotodownload.info/wp-content/uploads/2018/12/%D8%A8%D9%88%D8%B3%D8%AA%D8%A7%D8%AA-%D8%AF%D9%8A%D9%86%D9%8A%D8%A9-61-1.jpg",
                "https://quotess.cc/wp-content/uploads/2020/01/4688.jpg",
                "https://whatt.cc/wp-content/uploads/2018/07/4443.jpg",
                "https://i1.wp.com/www.newphotodownload.info/wp-content/uploads/2018/12/%D8%A8%D9%88%D8%B3%D8%AA%D8%A7%D8%AA-%D8%AF%D9%8A%D9%86%D9%8A%D8%A9-61-1.jpg"
        };

        final String[] starImages = {
                "https://www.muhtwa.com/wp-content/uploads/%D8%A8%D8%B1%D9%88%D9%81%D8%A7%D9%8A%D9%84-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A04.jpg",
                "https://www.mexatk.com/wp-content/uploads/2015/11/%D8%B5%D9%88%D8%B1-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A%D8%A9-%D8%AC%D8%AF%D9%8A%D8%AF%D8%A9-%D9%85%D9%83%D8%AA%D9%88%D8%A8-%D8%B9%D9%84%D9%8A%D9%87%D8%A7-3.jpg",
                "https://i1.wp.com/www.newphotodownload.info/wp-content/uploads/2019/08/%D8%A7%D8%AC%D9%85%D9%84-%D8%B5%D9%88%D8%B1-%D8%AF%D9%8A%D9%86%D9%8A%D8%A9-1.jpg?ssl=1",
                "https://www.muhtwa.com/wp-content/uploads/%D8%A8%D8%B1%D9%88%D9%81%D8%A7%D9%8A%D9%84-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A04.jpg",
                "https://www.mexatk.com/wp-content/uploads/2015/11/%D8%B5%D9%88%D8%B1-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A%D8%A9-%D8%AC%D8%AF%D9%8A%D8%AF%D8%A9-%D9%85%D9%83%D8%AA%D9%88%D8%A8-%D8%B9%D9%84%D9%8A%D9%87%D8%A7-3.jpg",
                "https://www.mexatk.com/wp-content/uploads/2015/11/%D8%B5%D9%88%D8%B1-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A%D8%A9-%D8%AC%D8%AF%D9%8A%D8%AF%D8%A9-%D9%85%D9%83%D8%AA%D9%88%D8%A8-%D8%B9%D9%84%D9%8A%D9%87%D8%A7-3.jpg",
                "https://i1.wp.com/www.newphotodownload.info/wp-content/uploads/2019/08/%D8%A7%D8%AC%D9%85%D9%84-%D8%B5%D9%88%D8%B1-%D8%AF%D9%8A%D9%86%D9%8A%D8%A9-1.jpg?ssl=1"
        };

        final String[] AzkarImages = {
                "https://www.muhtwa.com/wp-content/uploads/%D8%A8%D8%B1%D9%88%D9%81%D8%A7%D9%8A%D9%84-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A04.jpg",
                "https://www.mexatk.com/wp-content/uploads/2015/11/%D8%B5%D9%88%D8%B1-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A%D8%A9-%D8%AC%D8%AF%D9%8A%D8%AF%D8%A9-%D9%85%D9%83%D8%AA%D9%88%D8%A8-%D8%B9%D9%84%D9%8A%D9%87%D8%A7-3.jpg",
                "https://i1.wp.com/www.newphotodownload.info/wp-content/uploads/2019/08/%D8%A7%D8%AC%D9%85%D9%84-%D8%B5%D9%88%D8%B1-%D8%AF%D9%8A%D9%86%D9%8A%D8%A9-1.jpg?ssl=1",
                "https://www.muhtwa.com/wp-content/uploads/%D8%A8%D8%B1%D9%88%D9%81%D8%A7%D9%8A%D9%84-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A04.jpg",
                "https://www.mexatk.com/wp-content/uploads/2015/11/%D8%B5%D9%88%D8%B1-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A%D8%A9-%D8%AC%D8%AF%D9%8A%D8%AF%D8%A9-%D9%85%D9%83%D8%AA%D9%88%D8%A8-%D8%B9%D9%84%D9%8A%D9%87%D8%A7-3.jpg",
                "https://www.mexatk.com/wp-content/uploads/2015/11/%D8%B5%D9%88%D8%B1-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A%D8%A9-%D8%AC%D8%AF%D9%8A%D8%AF%D8%A9-%D9%85%D9%83%D8%AA%D9%88%D8%A8-%D8%B9%D9%84%D9%8A%D9%87%D8%A7-3.jpg",
                "https://i1.wp.com/www.newphotodownload.info/wp-content/uploads/2019/08/%D8%A7%D8%AC%D9%85%D9%84-%D8%B5%D9%88%D8%B1-%D8%AF%D9%8A%D9%86%D9%8A%D8%A9-1.jpg?ssl=1"
        };

        final String[] MaalemImages = {
                "https://www.muhtwa.com/wp-content/uploads/%D8%A8%D8%B1%D9%88%D9%81%D8%A7%D9%8A%D9%84-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A04.jpg",
                "https://www.mexatk.com/wp-content/uploads/2015/11/%D8%B5%D9%88%D8%B1-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A%D8%A9-%D8%AC%D8%AF%D9%8A%D8%AF%D8%A9-%D9%85%D9%83%D8%AA%D9%88%D8%A8-%D8%B9%D9%84%D9%8A%D9%87%D8%A7-3.jpg",
                "https://i1.wp.com/www.newphotodownload.info/wp-content/uploads/2019/08/%D8%A7%D8%AC%D9%85%D9%84-%D8%B5%D9%88%D8%B1-%D8%AF%D9%8A%D9%86%D9%8A%D8%A9-1.jpg?ssl=1",
                "https://www.muhtwa.com/wp-content/uploads/%D8%A8%D8%B1%D9%88%D9%81%D8%A7%D9%8A%D9%84-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A04.jpg",
                "https://www.mexatk.com/wp-content/uploads/2015/11/%D8%B5%D9%88%D8%B1-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A%D8%A9-%D8%AC%D8%AF%D9%8A%D8%AF%D8%A9-%D9%85%D9%83%D8%AA%D9%88%D8%A8-%D8%B9%D9%84%D9%8A%D9%87%D8%A7-3.jpg",
                "https://www.mexatk.com/wp-content/uploads/2015/11/%D8%B5%D9%88%D8%B1-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A%D8%A9-%D8%AC%D8%AF%D9%8A%D8%AF%D8%A9-%D9%85%D9%83%D8%AA%D9%88%D8%A8-%D8%B9%D9%84%D9%8A%D9%87%D8%A7-3.jpg",
                "https://i1.wp.com/www.newphotodownload.info/wp-content/uploads/2019/08/%D8%A7%D8%AC%D9%85%D9%84-%D8%B5%D9%88%D8%B1-%D8%AF%D9%8A%D9%86%D9%8A%D8%A9-1.jpg?ssl=1"
        };

        final String[] DowaaImages = {
                "https://www.muhtwa.com/wp-content/uploads/%D8%A8%D8%B1%D9%88%D9%81%D8%A7%D9%8A%D9%84-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A04.jpg",
                "https://www.mexatk.com/wp-content/uploads/2015/11/%D8%B5%D9%88%D8%B1-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A%D8%A9-%D8%AC%D8%AF%D9%8A%D8%AF%D8%A9-%D9%85%D9%83%D8%AA%D9%88%D8%A8-%D8%B9%D9%84%D9%8A%D9%87%D8%A7-3.jpg",
                "https://i1.wp.com/www.newphotodownload.info/wp-content/uploads/2019/08/%D8%A7%D8%AC%D9%85%D9%84-%D8%B5%D9%88%D8%B1-%D8%AF%D9%8A%D9%86%D9%8A%D8%A9-1.jpg?ssl=1",
                "https://www.muhtwa.com/wp-content/uploads/%D8%A8%D8%B1%D9%88%D9%81%D8%A7%D9%8A%D9%84-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A04.jpg",
                "https://www.mexatk.com/wp-content/uploads/2015/11/%D8%B5%D9%88%D8%B1-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A%D8%A9-%D8%AC%D8%AF%D9%8A%D8%AF%D8%A9-%D9%85%D9%83%D8%AA%D9%88%D8%A8-%D8%B9%D9%84%D9%8A%D9%87%D8%A7-3.jpg",
                "https://www.mexatk.com/wp-content/uploads/2015/11/%D8%B5%D9%88%D8%B1-%D8%A7%D8%B3%D9%84%D8%A7%D9%85%D9%8A%D8%A9-%D8%AC%D8%AF%D9%8A%D8%AF%D8%A9-%D9%85%D9%83%D8%AA%D9%88%D8%A8-%D8%B9%D9%84%D9%8A%D9%87%D8%A7-3.jpg",
                "https://i1.wp.com/www.newphotodownload.info/wp-content/uploads/2019/08/%D8%A7%D8%AC%D9%85%D9%84-%D8%B5%D9%88%D8%B1-%D8%AF%D9%8A%D9%86%D9%8A%D8%A9-1.jpg?ssl=1"
        };

        /* make new object and find the view "GridView" */
        GridView gridview1 = rootView.findViewById(R.id.gridview_image_choose);
        GridView gridview2 = rootView.findViewById(R.id.gridview_image_star);
        GridView gridview3 = rootView.findViewById(R.id.gridview_image_azkar);
        GridView gridview4 = rootView.findViewById(R.id.gridview_image_maalem);
        GridView gridview5 = rootView.findViewById(R.id.gridview_image_dowaa);

        // display all the images from Array on it
        gridview1.setAdapter(new PicassoImagesAdapter(getActivity(), chooseImages));
        gridview2.setAdapter(new PicassoImagesAdapter(getActivity(), starImages));
        gridview3.setAdapter(new PicassoImagesAdapter(getActivity(), AzkarImages));
        gridview4.setAdapter(new PicassoImagesAdapter(getActivity(), MaalemImages));
        gridview5.setAdapter(new PicassoImagesAdapter(getActivity(), DowaaImages));


        /* display the image when click on it */
        // we made a class for this method called "PicassoDisplayImageAdapter"
        gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // get the image
                String image = chooseImages[position];
                Intent intent = new Intent(getActivity(), PicassoDisplayImageAdapter.class);
                intent.putExtra("imageUrl", image);
                getActivity().startActivity(intent);
            }
        });

        gridview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // get the image
                String image = DowaaImages[position];
                Intent intent = new Intent(getActivity(), PicassoDisplayImageAdapter.class);
                intent.putExtra("imageUrl", image);
                getActivity().startActivity(intent);
            }
        });

        gridview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // get the image
                String image = DowaaImages[position];
                Intent intent = new Intent(getActivity(), PicassoDisplayImageAdapter.class);
                intent.putExtra("imageUrl", image);
                getActivity().startActivity(intent);
            }
        });

        gridview4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // get the image
                String image = DowaaImages[position];
                Intent intent = new Intent(getActivity(), PicassoDisplayImageAdapter.class);
                intent.putExtra("imageUrl", image);
                getActivity().startActivity(intent);
            }
        });

        gridview5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // get the image
                String image = DowaaImages[position];
                Intent intent = new Intent(getActivity(), PicassoDisplayImageAdapter.class);
                intent.putExtra("imageUrl", image);
                getActivity().startActivity(intent);
            }
        });

        return rootView;

    }
}
