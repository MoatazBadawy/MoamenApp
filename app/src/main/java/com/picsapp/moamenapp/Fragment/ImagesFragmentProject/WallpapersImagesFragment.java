package com.picsapp.moamenapp.Fragment.ImagesFragmentProject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.picsapp.moamenapp.Adapter.Picasso.Picasso;
import com.picsapp.moamenapp.Adapter.Picasso.PicassoDisplayWallpaperImage;
import com.picsapp.moamenapp.R;

import java.util.Arrays;
import java.util.Collections;

public class WallpapersImagesFragment extends Fragment implements Picasso.ItemClickListener {

    String[] TopImages;
    private Picasso adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_images_wallpapers, container, false);

        /* make the app support only arabic "Right to left" */
        // even if the language of the device on english or others
        ViewCompat.setLayoutDirection(getActivity().getWindow().getDecorView(), ViewCompat.LAYOUT_DIRECTION_RTL);

        /* ArrayList for TopImages */
        TopImages = new String[]{
                "https://i.ibb.co/QbJdyJj/allah-a4e67acb-0093-4456-ad96-6a240295dbe8.jpg",
                "https://i.ibb.co/YB62QG5/Allah-Bestof-Planners-b1cdf261-00a4-4875-9adb-f6ddab693aa8.jpg",
                "https://i.ibb.co/XZGFF8X/allah-f7c22f58-a233-456a-81c4-ab3a669dcd80.jpg",
                "https://i.ibb.co/6nSDMDN/an-Arabic-Quran-eba4e901-891a-4ebe-a0ae-4b9cfaa07fdd.jpg",
                "https://i.ibb.co/8YSKDjT/barka-36dba8a5-23e9-488f-bd4e-cc1dcd78e165.jpg",
                "https://i.ibb.co/zHj3P94/DUA-d4bfc6a5-8a12-46f1-a04c-17bc8c4b90fe.jpg",
                "https://i.ibb.co/4RLZXZg/Allah-Call-upon-me-b680792f-3870-406c-9430-014fa3ced1f2.jpg",
                "https://fsa.zobj.net/crop.php?r=Sp8RZwckKmrOm4Hg9veqXk-fJ0ekQ6j0B-ZG8Rlwv1dtCNEQWjFD8PV5XMRFWQvogobXX7D6c5lumZUhdIyV4j3RyhpKL32ZI41eznDkqDL6UjrTSxBjWtIzEHvE5nZSNKuivFrhMVjkNUBT",
                "https://fsa.zobj.net/crop.php?r=ZoP8ij-Swc9U_1A9sSW7Ryp1gs1hpIDZn2oqhqVPTORpz3A6HvPe0pximtFEF-7Rr228USn9hfyhuM5prOcmN8I1yHHcjg-e8EW2uwqbJpUC6JgKnJkfc8cVfY3RSS2_NeXL0oAohoxTI6n1",
                "https://fsb.zobj.net/crop.php?r=o0ntsmbAh4Wr92wcsqH7ChdNOfCnlucNaN4L2304D3kjAlZtGVGkqBVOcb4HWn_va61F3wx5Qo0UV0Z3UtjFjLposjXVcGSHDQaW8kbXd5TvU3fL831TUhYnQCVN9GKPWTMqtwgcz32a35Vy",
                "https://fsb.zobj.net/crop.php?r=4Qw5182l0hhMHjqkDI-FRUGKoGiunXQysWb47997wVdo_OxwnCiJy7GWxeF7R900II5Zv2zA9fDUvOVBpa3uMfYbPQt3NkBGM5IA7jtoLxOTo-Sdg9Q0BM_xR8CyZqLHncbWp06RgW54pi72",
                "https://fsb.zobj.net/crop.php?r=xR2ykQ4LW2MCVhk-utKHWi7wi5AdaW-DvV2i8KAuC1m5Aagl22Y4ra0jxFyk4sxlKBZ3-Pp6Pbm985a-8y_a17j_GdlcNJONfyZee70rghgGuCWwxAfpitePt2fHeESkjPcamUreJslD2b6X",
                "https://fsa.zobj.net/crop.php?r=53r1nOzlL43Kn96VsOhCkFrUrVlmsTkP0GyyxVAw6-74DVvRFnLXPSbWiFV3efBt0uf4qcu7RY4Qel8Y0yA7fJki4DohTtYG5bISjOT5Vx9qVqDs5X0qonVHXD4UZqu_rl4QYkVY5RYjQ3KI",
                "https://fsa.zobj.net/crop.php?r=rvJNkGG98N4c4IkPZKYOu7Qa6wFlGxWFKU19rgCevhTDKlpV_5LxGQJkepHinTHMhWPFMm9Ox8nb2sb3jjlNSOwTiNgtzIN81qMQXO8fqp2N4S2Id0iy1fcoquWIDIoGMYIwIO-uXLFDElFg",
                "https://fsa.zobj.net/crop.php?r=O_PPVScwaKYBwukBnWmNUE6pfDvPKugVSXEvDRyNVSTTa3oXbSCnrbL-3f0EVSG0UJ6P8WrOHfq-GuZh6ojV0JogBqPx_CX6EK1WZv4EbqfB-ZcAaQEjO8Ta728E82YnzXuejn-SGEvSrwjq",
                "https://i.ibb.co/PC0w7WB/AL-RZAK-0bb3940f-bd1a-458d-8377-d92fbc7aa7df.jpg",
                "https://i.ibb.co/xYj6q1b/Allah-Muhammad-8ac1439d-6295-4082-9748-1a33b1008424.jpg",
                "https://i.ibb.co/xYj6q1b/Allah-Muhammad-8ac1439d-6295-4082-9748-1a33b1008424.jpg",
                "https://i.ibb.co/8zJ2F13/Allah-see-you-ba3e2286-20b1-46f5-9c28-af5bb0f779e6.jpg",
                "https://i.ibb.co/V3qr5YQ/Allah-with-us-dfaab425-e523-4f7e-b627-faacf3fc9f75.jpg",
                "https://i.ibb.co/x5zWd6G/Allah-4da1f1b0-a6d7-4355-a24d-f950ea43381d.jpg",
        };

        /* make new object and find the view "GridView" */
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView_image_wallpapers);
        // Calculate the items and auto-fit it on the screen
        int mNoOfColumns = HomeImagesFragment.Utility.calculateNoOfColumns(getActivity(), 140);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), mNoOfColumns));
        adapter = new Picasso(getActivity(), TopImages);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        // change the adapter at random every specific time{
        Collections.shuffle(Arrays.asList(TopImages));


        return rootView;
    }

    @Override
    public void onItemClick(View view, int position) {
        // get the image
        String image = TopImages[position];
        Intent intent = new Intent(getActivity(), PicassoDisplayWallpaperImage.class);
        intent.putExtra("imageUrl", image);
        getActivity().startActivity(intent);
    }

    // Calculate the items and auto-fit it on the screen
    public static class Utility {
        public static int calculateNoOfColumns(Context context, float columnWidthDp) { // For example columnWidthdp=180
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
            int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
            return noOfColumns;
        }
    }
}
