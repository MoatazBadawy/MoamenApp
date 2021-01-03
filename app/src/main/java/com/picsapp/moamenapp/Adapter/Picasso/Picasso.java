package com.picsapp.moamenapp.Adapter.Picasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.picsapp.moamenapp.R;

public class Picasso extends RecyclerView.Adapter<Picasso.ViewHolder> {

    private String[] mData;
    private Context context;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public Picasso(Context context, String[] data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_images, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        com.squareup.picasso.Picasso
                .with(context)
                .load(mData[position])
                .fit() // to resize the image to imageView
                .placeholder(R.drawable.folder_loading_image) // load image
                .transform(new PicassoRoundedTransformation(20, 0)) // Add radius to the images
                .noFade()
                .into(holder.mimageView);
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return mData.length;
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return mData[id];
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView mimageView;

        ViewHolder(View itemView) {
            super(itemView);
            mimageView = itemView.findViewById(R.id.list_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}
