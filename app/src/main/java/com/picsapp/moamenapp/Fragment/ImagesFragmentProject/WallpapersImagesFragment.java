package com.picsapp.moamenapp.Fragment.ImagesFragmentProject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
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

        // make the app support only arabic "Right to left" */
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
                // 16
                "https://i.ibb.co/TLd7Vq0/Friday-d97668b5-8651-4990-83d1-2c74969f5f9b.jpg",
                // 17
                "https://i.ibb.co/T2QWXDk/Hijab-Girl-c46312f6-4a81-4895-b098-3b6048a5a067.jpg",
                // 18
                "https://i.ibb.co/KFCDbQj/Holy-Quran-Kaaba-cb5908f6-1368-4455-b6c9-dc0edd898347.jpg",
                // 19
                "https://i.ibb.co/rcspqgy/Hijab-Muslim-girl-6dd77dc3-99ad-4b2b-bd7e-6f25134c8749.jpg",
                // 20
                "https://i.ibb.co/M52cpq2/Islam-Door-330dd337-6bf4-4c7f-be45-66836e69f783.jpg",
                // 21
                "https://i.ibb.co/YdqYyBT/Islam-4fc4f245-d4f3-4bba-a503-8673af2f200f.jpg",
                // 22
                "https://i.ibb.co/v4ZCWs2/Islam-6be23a85-11f8-4b29-9ffa-c82179a88a56.jpg",
                // 23
                "https://i.ibb.co/nCdsWBG/islam-9a40b4cc-ab98-32f4-8707-9cf7da4b1a21.jpg",
                // 24
                "https://i.ibb.co/ZVpZRQP/Islam-661e37e5-9001-4483-9a4d-00206e04768b.jpg",
                // 25
                "https://i.ibb.co/MpS87dJ/Islam-e51524bf-35d2-414f-8f39-0f8890a1866a.jpg",
                // 26
                "https://i.ibb.co/gjLFkkv/islam-f7103e68-7177-435f-ad3c-40b5beb53a32.jpg",
                // 27
                "https://i.ibb.co/px7kMF0/islamic-kaaba-187f1edf-9f87-47a0-82cc-d0386cfb4d93.jpg",
                // 28
                "https://i.ibb.co/0VXWcCM/islamic-lamps-22f7616b-45b0-3cb4-9438-297a6bedca2e.jpg",
                // 29
                "https://i.ibb.co/8bhVVGC/islamic-Muslim-bfe422c4-348a-4dff-b773-83be738cca37.jpg",
                // 30
                "https://i.ibb.co/pWhtRdd/Islamic-zekr-35d55b9e-bd32-4abb-b4af-7a40540308f9.jpg",
                // 31
                "https://i.ibb.co/jR6YPgL/Islamic-00cc05a8-5fbd-3e28-ab7b-80ff62d3d6ea.jpg",
                // 32
                "https://i.ibb.co/DWjgzfS/Islamic-4482c3aa-fc9b-4e09-827d-2e624525e2ea.jpg",
                // 33
                "https://i.ibb.co/z48dRWm/Islamic-96149b80-d1ff-441e-8ac7-e5388c84ee3a.jpg",
                // 34
                "https://i.ibb.co/8XTTgs6/Kaaba-9736091a-8999-4316-b770-0badbbf210a3.jpg",
                // 35
                "https://i.ibb.co/vztp4bV/Kalimah-484682ae-572a-439d-9260-86c38243f0f9.jpg",
                // 36
                "https://i.ibb.co/M9V7j6f/lantern-4a47fa85-a773-3491-ba56-99d83d401b85.jpg",
                // 37
                "https://i.ibb.co/0sQ84yF/Lost-and-Found-cdd71697-6d05-453a-be20-8fdc90e11853.jpg",
                // 38
                "https://i.ibb.co/PCfvCqJ/Makkah-ef091b33-a8ed-4c29-86ba-6673ae77cbd4.jpg",
                // 39
                "https://i.ibb.co/tXk7RMD/Mecca-Makka-Sharif-067db6de-4c52-43aa-931e-733f3a06660c.jpg",
                // 40
                "https://i.ibb.co/p1t3pc0/mohamed-124f3a68-f555-42fc-91fe-1f257253faf0.jpg",
                // 41
                "https://i.ibb.co/sHyyN4z/Moslim-couple-c71f7843-aabb-4784-bee5-a2141cefdde0.jpg",
                // 42
                "https://i.ibb.co/4tQWWDn/Only-come-from-Allah-9823083e-2ceb-4b21-bb93-51723fd0ae2b.jpg",
                // 43
                "https://i.ibb.co/bzYdmMK/Prayer-Now-Mobile-APP-1eff34c5-5b67-4857-9531-fdb5775fdcba.jpg",
                // 44
                "https://i.ibb.co/7jcdwbd/Prayer-Now-Mobile-App-6ec7fa51-049c-4292-b4aa-fef9e4d02b9e.jpg",
                // 45
                "https://i.ibb.co/jz6DsBg/Prayer-Now-mobile-App-ab92be11-8c6f-406b-8341-089194579f73.jpg",
                // 46
                "https://i.ibb.co/qjQ972r/Prayer-Now-Mobile-App-e9fa2b04-8e9e-4e5e-b3c9-cdb6f1bfd507.jpg",
                // 47
                "https://i.ibb.co/gMV5vDJ/Prayer-Now-3ee14f79-2349-4aac-b62f-95a28d64bead.jpg",
                // 48
                "https://i.ibb.co/WBfBfkz/Prayer-Now-3f7f4360-9deb-4cd5-aca0-86ba34bd584e.jpg",
                // 49
                "https://i.ibb.co/CJT18pS/Prayer-Now-04ea9cef-7c43-4430-a0c2-3fe58a5946e3.jpg",
                // 50
                "https://i.ibb.co/vPMQHh5/prayernow-9e5c4559-6d43-4374-ad9d-57ba7495e141.jpg",
                // 51
                "https://i.ibb.co/vjGhkHW/prayernow-9ff9be2c-5b71-41b1-b9ba-ac56a64671ec.jpg",
                // 52
                "https://i.ibb.co/9w33xSp/Prayer-Now-45bf15a7-b8c4-41de-9873-423b17b0e7cc.jpg",
                // 53
                "https://i.ibb.co/gTzm2xH/Prayer-Now-48bdb013-8c49-4e41-bc49-4cca5958192e.jpg",
                // 54
                "https://i.ibb.co/6P2d1Vg/Prayer-Now-3184892d-f8e7-4c25-996e-f8380596c93c.jpg",
                // 55
                "https://i.ibb.co/KqK0dFh/Prayer-Now-b3ae6764-2c3a-4780-87cf-2337c802144d.jpg",
                // 56
                "https://i.ibb.co/tM7kFn4/Prayer-Now-e6ec9e56-5e3b-458d-9d36-935c17c20a5a.jpg",
                // 57
                "https://i.ibb.co/LvdP5TN/Prophet-Mohamed-ce855441-91ba-4305-9627-4a875cc65ccc.jpg",
                // 58
                "https://i.ibb.co/9ydTFtg/Prophet-mohammad-80caa2ae-3160-4387-a05f-2aa245efa838.jpg",
                // 59
                "https://i.ibb.co/dcFBGXb/Quran-ee5852c0-4558-4669-b418-d098a990081c.jpg",
                // 60
                "https://i.ibb.co/vDPMydN/Quran-Verses-f8d14170-0f3f-46fe-a3a5-fcf23850070f.jpg",
                // 61
                "https://i.ibb.co/pj7RVQm/Quran-2ce9af01-0c9c-4a82-89ce-9dbb78470bdf.jpg",
                // 62
                "https://i.ibb.co/Sn33vp8/Quran-39cc5100-c14d-4c87-82e5-c1c38a3262ec.jpg",
                // 63
                "https://i.ibb.co/yPTNdmF/Quran-89d6719b-6d95-4975-ab59-d36d69474917.jpg",
                // 64
                "https://i.ibb.co/0GSFzFJ/Quran-2440d3f2-87ad-444a-bb3a-efbd5f2308c4.jpg",
                // 65
                "https://i.ibb.co/pWHJyvy/Quran-acff4db1-5574-4424-b5a6-dca111179e2a.jpg",
                // 66
                "https://i.ibb.co/SfGWggj/Quran-c916ad9f-d7f6-4d20-b1f8-15c78b26f3b6.jpg",
                // 67
                "https://i.ibb.co/WFnvSm1/Ramadan-kareem-40f93eea-c061-4513-9a39-04d8fc88b054.jpg",
                // 68
                "https://i.ibb.co/z299P7b/ramadan-kreem-659097cc-640b-4c90-a83d-a4edfe835f55.jpg",
                // 69
                "https://i.ibb.co/FzhTK8Z/Roche-Design-6f8745e8-5539-4f5e-b519-69bdca0a4e25.jpg",
                // 70
                "https://i.ibb.co/100W5Wg/Roche-Design-ae32f91b-522d-42b6-b315-410ca81fff07.jpg",
                // 71
                "https://i.ibb.co/C6xdTh9/Shab-e-barat-724610f8-5702-4261-a29a-5f01548fdf0d.jpg",
                // 72
                "https://i.ibb.co/mb8tRPs/Stay-home-muslim-33e6ea8f-62c4-4cfc-a4ca-c9b380cc83b3.jpg",
                // 73
                "https://i.ibb.co/sb5m8zJ/Subhana-Allah-3a4d3e9f-0688-490f-95c1-08632852b49e.jpg",
                // 74
                "https://i.ibb.co/0jY56Lk/Surah-Al-Ikhlas-2aff1455-00d2-4def-9f4b-8d02eb09299a.jpg",
                // 75
                "https://i.ibb.co/vhMjCX8/Tasbeeh-e9a848cc-e8c2-423d-ba80-cdca5962ad21.jpg",
                // 76
                "https://i.ibb.co/kh4vRzc/The-Prophet-Muhammad-b40984ef-5d91-3249-be36-4a8c0f321769.jpg",
                // 77
                "https://i.ibb.co/kG6bjPF/The-Umbrella-Girl-74b7ad9d-6240-4d5c-8b68-368e65403501.jpg",
                // 78
                "https://i.ibb.co/dG50NwF/Work-Hard-56879b28-f4af-4f45-9c6f-91bc296dc88b.jpg",
                // 79
                "https://i.ibb.co/ZxNt17J/Your-Lord-is-most-kn-ce20cb2e-9503-4562-8354-55b16aed93ae.jpg",
                // 80
                "https://i.ibb.co/KspCFsV/Ramadan-c7a729aa-a885-445a-9e22-f46f051e2def.jpg",
                // 81
                "https://i.ibb.co/fq6mbf5/Ramzan-Mubarik-79241332-2d38-4f32-a72a-aac4a254022d.jpg",
                // 82
                "https://i.ibb.co/bbRVXg8/249-iphone-wallpapers-hd-725x1024.jpg",
        };

        // make new object and find the view "GridView" */
        final RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView_image_wallpapers);
        // Calculate the items and auto-fit it on the screen
        int mNoOfColumns = HomeImagesFragment.Utility.calculateNoOfColumns(getActivity(), 120);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), mNoOfColumns));
        adapter = new Picasso(getActivity(), TopImages);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        // change the adapter at random every specific time{
        Collections.shuffle(Arrays.asList(TopImages));

        // add floating button to go up when click on it
        final FloatingActionButton fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.smoothScrollToPosition(0);
            }
        });

        // floating button Visibility and set time for that
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {

                if (dy > 0) { // scrolling down
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            fab.setVisibility(View.GONE);
                        }
                    }, 2000); // delay of 2 seconds before hiding the fab

                } else if (dy < 0) { // scrolling up

                    fab.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) { // No scrolling
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            fab.setVisibility(View.GONE);
                        }
                    }, 2000); // delay of 2 seconds before hiding the fab
                }

            }
        });

        return rootView;
    }

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
