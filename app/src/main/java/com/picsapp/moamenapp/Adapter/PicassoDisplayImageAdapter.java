package com.picsapp.moamenapp.Adapter;

import android.Manifest;
import android.app.WallpaperManager;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.ablanco.zoomy.Zoomy;
import com.picsapp.moamenapp.R;
import com.squareup.picasso.Picasso;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import es.dmoral.toasty.Toasty;
import static android.provider.MediaStore.*;
import com.squareup.picasso.Target;

/*
 * This class for display the image when click on it
 * It is get the data from the class have the images "Images in ArrayList"
 */
public class PicassoDisplayImageAdapter extends AppCompatActivity {

    public static final int PERMISSION_WRITE = 0;
    ImageView imageView ;
    Button back_icon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);

        // Hide status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* make the app support only arabic "Right to left" */
        // even if the language of the device on english or others
        ViewCompat.setLayoutDirection(getWindow().getDecorView(), ViewCompat.LAYOUT_DIRECTION_RTL);

        /* back to last activity*/
        back_icon = findViewById(R.id.button_back);
        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        /* Display the data in the ImageView with Picasso "ImageView that insert in he activity" */
        imageView = findViewById(R.id.image_display);
        final Intent intent = getIntent();
        if (intent.hasExtra("imageUrl")) {
            String url = intent.getStringExtra("imageUrl");
            Picasso
                    .with(this)
                    .load(url)
                    .error(R.drawable.error)
                    .into(imageView);
        }

        /* To zoom in photo like instagram */
        Zoomy.Builder builder = new Zoomy.Builder(this).target(imageView);
        builder.register();

        /* button to change the wallpaper on home screen for the device */
        Button wallpaper = findViewById(R.id.button_wallpaper);
        wallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkPermission()) {
                    String url = intent.getStringExtra("imageUrl");
                    Picasso.with(PicassoDisplayImageAdapter.this).load(url).into(new Target(){
                        @Override
                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                            WallpaperManager wallpaperManager = WallpaperManager.getInstance(PicassoDisplayImageAdapter.this);
                            try {
                                wallpaperManager.setBitmap(bitmap);
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            Log.d("TAG", "onBitmapLoaded: ");
                            Toasty.normal(PicassoDisplayImageAdapter.this, "تم تغيير الخلفية بنجاح", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onBitmapFailed(final Drawable errorDrawable) {
                            Log.d("TAG", "FAILED");
                            Toasty.error(PicassoDisplayImageAdapter.this, "فشل تحميل الصورة", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onPrepareLoad(final Drawable placeHolderDrawable) {
                            Log.d("TAG", "Prepare Load");
                            Toasty.normal(PicassoDisplayImageAdapter.this, "جاري التحميل", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        /* item to share image */
        Button share = findViewById(R.id.button_share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkPermission()) {
                    BitmapDrawable bitmapDrawable = ((BitmapDrawable) imageView.getDrawable());
                    Bitmap bitmap = bitmapDrawable.getBitmap();
                    String bitmapPath = Images.Media.insertImage(getContentResolver(), bitmap, "حمل تطبيق المؤمن للمزيد من هذه الصور", null);
                    Uri bitmapUri = Uri.parse(bitmapPath);
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("image/jpeg");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, bitmapUri);
                    startActivity(Intent.createChooser(shareIntent, "شارك الصورة"));
                }
            }
        });

        /* item to download the image */
        Button save = findViewById(R.id.button_download);
        checkPermission();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermission()) {
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
            }
        });

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

    /* method to save image*/
    void saveMyImage (String appName, String imageUrl, String imageName) {

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

    /* runtime storage permission */
    public boolean checkPermission() {
        int READ_EXTERNAL_PERMISSION = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if((READ_EXTERNAL_PERMISSION != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_WRITE);
            return false;
        }
        return true;
    }

    /* Request storage permissions result */
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==PERMISSION_WRITE && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            //do somethings
        }
    }
}
