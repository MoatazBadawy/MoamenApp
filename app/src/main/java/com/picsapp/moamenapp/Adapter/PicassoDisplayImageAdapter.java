package com.picsapp.moamenapp.Adapter;

import android.Manifest;
import android.app.WallpaperManager;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

import com.ablanco.zoomy.Zoomy;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.picsapp.moamenapp.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import es.dmoral.toasty.Toasty;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

import static android.provider.MediaStore.Images;

/*
 * This class for display the image when click on it
 * It is get the data from the class have the images "Images in ArrayList"
 */
public class PicassoDisplayImageAdapter extends AppCompatActivity {

    ImageView imageView;
    Button back_icon, save, share, wallpaper, download_view,
            item_home_image, item_lock_image, item_both_image;
    ConstraintLayout mBottomsheet;
    BottomSheetBehavior mBottomSheetBehavior;
    public static final int PERMISSION_WRITE = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);

        // Hide status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // make the app support only arabic "Right to left"
        ViewCompat.setLayoutDirection(getWindow().getDecorView(), ViewCompat.LAYOUT_DIRECTION_RTL);

        // back to last activity
        back_icon = findViewById(R.id.button_back_dowaa);
        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Display the data in the ImageView with Picasso "ImageView that insert in the activity"
        imageView = findViewById(R.id.image_display);
        Intent intent = getIntent();
        if (intent.hasExtra("imageUrl")) {
            String url = intent.getStringExtra("imageUrl");
            Picasso
                    .with(this)
                    .load(url)
                    .error(R.drawable.error)
                    .into(imageView);
        }

        // BottomSheetBehavior to make sheet bar
         mBottomsheet = findViewById(R.id.bottom_sheet);
         mBottomSheetBehavior = BottomSheetBehavior.from(mBottomsheet);
        wallpaper = findViewById(R.id.button_wallpaper);
        wallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        // BottomSheetBehavior items
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {

                        // first item
                        item_home_image = findViewById(R.id.item_home_image);
                        item_home_image.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (checkPermission()) {
                                    setHomeWallpaper();
                                }
                            }
                        });

                        // second item
                        item_lock_image = findViewById(R.id.item_lock_image);
                        item_lock_image.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (checkPermission()) {
                                    setLockWallpaper ();
                                }
                            }
                        });

                        // third item
                        item_both_image = findViewById(R.id.item_both_image);
                        item_both_image.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                setBothWallpaper();
                            }
                        });
                    }
                    break;

                    case
                            BottomSheetBehavior.STATE_COLLAPSED: {}
                         break;
                    case
                            BottomSheetBehavior.STATE_DRAGGING:
                         break;
                    case
                            BottomSheetBehavior.STATE_SETTLING:
                        break;
                    case
                            BottomSheetBehavior.STATE_HALF_EXPANDED:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {}

        });

        // Button to share image
        share = findViewById(R.id.button_share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkPermission()) {
                    setShareImage();
                }
            }
        });

        // Button to download the image
        save = findViewById(R.id.button_download);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermission()) {
                    setDownloadImage();
                }
            }
        });

        // zoom in photo like Instagram
        Zoomy.Builder builder = new Zoomy.Builder(this).target(imageView);
        builder.register();

        // MaterialShowcaseView "intro"
        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(500); // half second between each showcase view
        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this, "intro_card");
        sequence.setConfig(config);
        download_view = findViewById(R.id.download_view);
        sequence.addSequenceItem(download_view,
                "قم بحفظ الصورة", "التالي");
        sequence.addSequenceItem(wallpaper,
                "يمكنك تعيين الصورة كخلفية لجهازك", "التالي");
        sequence.addSequenceItem(share,
                "شارك الصورة مع أصدقائك حتى بدون تحميل", "إبدأ");
        sequence.start();
    }

    // load Bitmap to method save image
    private static Bitmap loadBitmap(String url) {
        try {
            InputStream in = new java.net.URL(url).openStream();
            return BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Download the image "it is called in Oncreate"
    public void setDownloadImage() {
        Intent intent = getIntent();
        String URL = intent.getStringExtra("imageUrl");
        /* to get image name from url */
        URI uri = null;
        try {
            uri = new URI(URL);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        URL videoUrl = null;
        try {
            videoUrl = uri.toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        File tempFile = new File(videoUrl.getFile());
        String fileName = tempFile.getName();
        saveMyImage("تطبيق المؤمن", URL, fileName);
    }

    // Share the image "it is called in Oncreate"
    public void setShareImage () {
        BitmapDrawable bitmapDrawable = ((BitmapDrawable) imageView.getDrawable());
        Bitmap bitmap = bitmapDrawable.getBitmap();
        String bitmapPath = Images.Media.insertImage(getContentResolver(), bitmap, "حمل تطبيق المؤمن للمزيد من هذه الصور", null);
        Uri bitmapUri = Uri.parse(bitmapPath);
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/jpeg");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "حمل تطبيق المؤمن للمزيد من الصور");
        shareIntent.putExtra(Intent.EXTRA_STREAM, bitmapUri);
        startActivity(Intent.createChooser(shareIntent, ""));
    }

    // Set Home wallpaper the image "it is called in Oncreate" at sheetBar
    public void setHomeWallpaper () {
        final Intent intent = getIntent();
        String url = intent.getStringExtra("imageUrl");
        Picasso.with(PicassoDisplayImageAdapter.this).load(url).into(new Target() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(PicassoDisplayImageAdapter.this);
                try {
                    wallpaperManager.setBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toasty.normal(PicassoDisplayImageAdapter.this, "تم تغيير الخلفية بنجاح", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBitmapFailed(final Drawable errorDrawable) {
                Toasty.error(PicassoDisplayImageAdapter.this, "فشل تحميل الصورة", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPrepareLoad(final Drawable placeHolderDrawable) {
                Toasty.normal(PicassoDisplayImageAdapter.this, "جاري التحميل", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Set lock wallpaper the image "it is called in Oncreate" at sheetBar
    public void setLockWallpaper () {
        final Intent intent = getIntent();
        String url = intent.getStringExtra("imageUrl");
        Picasso.with(PicassoDisplayImageAdapter.this).load(url).into(new Target() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(PicassoDisplayImageAdapter.this);
                try {
                    wallpaperManager.setBitmap(bitmap, null, false, WallpaperManager.FLAG_LOCK);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                Toasty.normal(PicassoDisplayImageAdapter.this, "تم تغيير الخلفية بنجاح", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBitmapFailed(final Drawable errorDrawable) {
                Toasty.error(PicassoDisplayImageAdapter.this, "فشل تحميل الصورة", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPrepareLoad(final Drawable placeHolderDrawable) {
                Toasty.normal(PicassoDisplayImageAdapter.this, "جاري التحميل", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Set both (Home and lock screen) wallpaper the image "it is called in Oncreate" at sheetBar
    public void setBothWallpaper () {
        if (checkPermission()) {
            final Intent intent = getIntent();
            String url = intent.getStringExtra("imageUrl");
            Picasso.with(PicassoDisplayImageAdapter.this).load(url).into(new Target() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    WallpaperManager wallpaperManager = WallpaperManager.getInstance(PicassoDisplayImageAdapter.this);
                    try {
                        wallpaperManager.setBitmap(bitmap);
                        wallpaperManager.setBitmap(bitmap, null, false, WallpaperManager.FLAG_LOCK);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    Toasty.normal(PicassoDisplayImageAdapter.this, "تم تغيير الخلفية بنجاح", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onBitmapFailed(final Drawable errorDrawable) {
                    Toasty.error(PicassoDisplayImageAdapter.this, "فشل تحميل الصورة", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onPrepareLoad(final Drawable placeHolderDrawable) {
                    Toasty.normal(PicassoDisplayImageAdapter.this, "جاري التحميل", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    // hide bottom sheet when click outside
    public boolean dispatchTouchEvent(MotionEvent event){
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (mBottomSheetBehavior.getState()==BottomSheetBehavior.STATE_EXPANDED) {

                Rect outRect = new Rect();
                mBottomsheet.getGlobalVisibleRect(outRect);

                if(!outRect.contains((int)event.getRawX(), (int)event.getRawY()))
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        }

        return super.dispatchTouchEvent(event);
    }

    // method to save image
    void saveMyImage(String appName, String imageUrl, String imageName) {

        Bitmap bmImg = loadBitmap(imageUrl);
        File filename;
        try {
            String path1 = Environment.getExternalStorageDirectory()
                    .toString();
            File file = new File(path1 + "/" + appName);
            if (!file.exists())
                file.mkdirs();
            filename = new File(file.getAbsolutePath() + "/" + imageName
                    + ".jpg");
            FileOutputStream out = new FileOutputStream(filename);
            bmImg.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
            ContentValues image = new ContentValues();
            image.put(Images.Media.TITLE, appName);
            image.put(Images.Media.DISPLAY_NAME, imageName);
            image.put(Images.Media.DESCRIPTION, "App Image");
            image.put(Images.Media.DATE_ADDED, System.currentTimeMillis());
            image.put(Images.Media.MIME_TYPE, "image/jpg");
            image.put(Images.Media.ORIENTATION, 0);
            File parent = filename.getParentFile();
            image.put(Images.ImageColumns.BUCKET_ID, parent.toString()
                    .toLowerCase().hashCode());
            image.put(Images.ImageColumns.BUCKET_DISPLAY_NAME, parent.getName()
                    .toLowerCase());
            image.put(Images.Media.SIZE, filename.length());
            image.put(Images.Media.DATA, filename.getAbsolutePath());
            Uri result = getContentResolver().insert(
                    Images.Media.EXTERNAL_CONTENT_URI, image);
            Toasty.normal(getApplicationContext(), "تم حفظ الصورة في مجلد تطبيق المؤمن", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // runtime storage permission
    public boolean checkPermission() {
        int READ_EXTERNAL_PERMISSION = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if ((READ_EXTERNAL_PERMISSION != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_WRITE);
            return false;
        }
        return true;
    }

    // Request storage permissions result
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_WRITE && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            //do somethings
        }
    }
}
