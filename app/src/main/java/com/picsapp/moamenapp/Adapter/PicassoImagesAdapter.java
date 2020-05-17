package com.picsapp.moamenapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.picsapp.moamenapp.R;
import com.squareup.picasso.Picasso;

/*
 * This class for display the images
 * we set the url and methods that's will be get the images
 * from the server "URL" and display them.
 * Note: Picasso safe the images in the memory so the user don't need
 * to connect to the internet again to load the images
 */
public class PicassoImagesAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;

    private String[] imageUrls;
    private ImageView ImageBanner;

    public PicassoImagesAdapter(Context context, String[] imageUrls) {
        super(context, R.layout.list_images, imageUrls);

        this.context = context;
        this.imageUrls = imageUrls;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.list_images, parent, false);
        }

        Picasso
                .with(context)
                .load(imageUrls[position])
                .fit() // to resize the image to imageView
                .transform(new PicassoRoundedTransformation(20, 0)) // Add radius to the images
                .noFade()
                .error(R.drawable.error)
                .into((ImageView) convertView.findViewById(R.id.list_image));

        return convertView;
    }
}