package com.picsapp.moamenapp.Fragment.ImagesFragmentProject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import com.picsapp.moamenapp.Adapter.Picasso.Picasso;
import com.picsapp.moamenapp.Adapter.Picasso.PicassoDisplayWallpaperImage;
import com.picsapp.moamenapp.R;

public class CategoryImagesFragment extends Fragment implements Picasso.ItemClickListener {

    String[] TopImages;
    private Picasso adapter;

    @Override
    public void onItemClick(View view, int position) {
        // get the image
        String image = TopImages[position];
        Intent intent = new Intent(getActivity(), PicassoDisplayWallpaperImage.class);
        intent.putExtra("imageUrl", image);
        // to not repeat the image when click on it many times
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        getActivity().startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_images_category, container, false);

        // make the app support only arabic "Right to left"
        // even if the language of the device on english or others
        ViewCompat.setLayoutDirection(getActivity().getWindow().getDecorView(), ViewCompat.LAYOUT_DIRECTION_RTL);

        // ArrayList for TopImages
        TopImages = new String[]{
                // 1
                "https://i.ibb.co/GWRmtzt/AL-RZAK-0bb3940f-bd1a-458d-8377-d92fbc7aa7df.jpg",
                // 2
                "https://i.ibb.co/Cb4b46W/Allah-Call-upon-me-b680792f-3870-406c-9430-014fa3ced1f2.jpg",
                // 3
                "https://i.ibb.co/WGY5Rtb/Allah-Muhammad-8ac1439d-6295-4082-9748-1a33b1008424.jpg",
                // 4
                "https://i.ibb.co/h2CgG7F/Allah-see-you-ba3e2286-20b1-46f5-9c28-af5bb0f779e6.jpg",
                // 5
                "https://i.ibb.co/Jk1rFGC/Allah-with-us-dfaab425-e523-4f7e-b627-faacf3fc9f75.jpg",
                // 6
                "https://i.ibb.co/Xpqw6Dk/Allah-4da1f1b0-a6d7-4355-a24d-f950ea43381d.jpg",
                // 7
                "https://i.ibb.co/pWDx1rJ/Allah-62d14d57-d8c9-4bb5-8d13-fd040560d351.jpg",
                // 8
                "https://i.ibb.co/wL7R1MJ/allah-a4e67acb-0093-4456-ad96-6a240295dbe8.jpg",
                // 9
                "https://i.ibb.co/vwk3zS4/Allah-Bestof-Planners-b1cdf261-00a4-4875-9adb-f6ddab693aa8.jpg",
                // 10
                "https://i.ibb.co/F0f5vR6/allah-f7c22f58-a233-456a-81c4-ab3a669dcd80.jpg",
                // 11
                "https://i.ibb.co/NL3jYJS/an-Arabic-Quran-eba4e901-891a-4ebe-a0ae-4b9cfaa07fdd.jpg",
                // 12
                "https://i.ibb.co/j4gGqdf/DUA-d4bfc6a5-8a12-46f1-a04c-17bc8c4b90fe.jpg",
                // 13
                "https://i.ibb.co/pw1VxhM/Esteghfar-fe47ace6-f368-4467-804c-4e0f2730a71f.jpg",
                // 14
                "https://i.ibb.co/hKfdgdg/For-you-Allah-06c2460f-99c0-4e45-9e86-de0a148e8ea3.jpg",
                // 15
                "https://i.ibb.co/HTbv5fB/forgiveness-86660daf-f67f-4805-b66e-c30ac0e35ed7.jpg",
        };


        return rootView;
    }
}
