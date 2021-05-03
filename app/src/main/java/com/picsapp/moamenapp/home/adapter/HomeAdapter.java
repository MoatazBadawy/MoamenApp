package com.picsapp.moamenapp.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.picsapp.moamenapp.R;
import com.picsapp.moamenapp.home.model.DailyFadelModel;
import com.picsapp.moamenapp.home.model.DailyImageModel;
import com.picsapp.moamenapp.home.model.FirstImageModel;
import com.picsapp.moamenapp.home.model.HomeResponse;
import com.picsapp.moamenapp.home.model.LiveModel;
import com.picsapp.moamenapp.home.model.SaleheenSaidModel;


public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private HomeResponse items = null;

    public void setHomeList(HomeResponse items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == R.id.image_home_firstImage) {
            return new FirstImageViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.item_home_container_firstimage,
                            parent,
                            false
                    )
            );
        } else if (viewType == R.id.image_home_liveImage) {
            return new LiveViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.item_home_container_live,
                            parent,
                            false
                    )
            );
        } else if (viewType == R.id.image_home_dailyImage) {
            return new DailyImageViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.item_home_container_dailyimage,
                            parent,
                            false
                    )
            );
        } else if (viewType == R.id.home_textFadel) {
            return new DailyFadelViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.item_home_container_dailyfadel,
                            parent,
                            false
                    )
            );
        } else if (viewType == R.id.image_home_textSaleheen) {
            return new SaleheenSaidViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.item_home_container_saleheensaid,
                            parent,
                            false
                    )
            );
        } else throw new IllegalArgumentException("unknown view type");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == R.id.image_home_firstImage) {
            FirstImageModel firstImageModel = items.getFirstImage().get(position);
            ((FirstImageViewHolder) holder).setFirstImageData(firstImageModel);

        } else if (getItemViewType(position) == R.id.image_home_liveImage) {
            LiveModel liveModel = items.getLive().get(position - items.getFirstImage().size());
            ((LiveViewHolder) holder).setLiveImageData(liveModel);

        } else if (getItemViewType(position) == R.id.image_home_dailyImage) {
            DailyImageModel dailyImageModel = items.getDailyImage().get(position - (items.getFirstImage().size() + items.getLive().size()));
            ((DailyImageViewHolder) holder).setDailyImageData(dailyImageModel);

        } else if (getItemViewType(position) == R.id.home_textFadel) {
            DailyFadelModel dailyFadelModel = items.getDailyFadel().get(position - (items.getFirstImage().size() + items.getLive().size() + items.getDailyImage().size()));
            ((DailyFadelViewHolder) holder).setDailyFadelData(dailyFadelModel);

        } else if (getItemViewType(position) == R.id.image_home_textSaleheen) {
            SaleheenSaidModel saleheenSaidModel = items.getSaleheenSaid().get(position - (items.getFirstImage().size() + items.getLive().size() + items.getDailyImage().size() + items.getDailyFadel().size()));
            ((SaleheenSaidViewHolder) holder).setSaleheenSaidData(saleheenSaidModel);
        }
    }

    @Override
    public int getItemCount() {
        if (items ==null) return 0;
        return items.getFirstImage().size() + items.getLive().size() + items.getDailyImage().size() + items.getDailyFadel().size() + items.getSaleheenSaid().size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 && position < items.getFirstImage().size()) {
            return R.id.image_home_firstImage;
        } else if (position == items.getFirstImage().size() && position < items.getFirstImage().size()
                + items.getLive().size()) {
            return R.id.image_home_liveImage;
        } else if (position == items.getFirstImage().size() + items.getLive().size() && position < items.getFirstImage().size()
                + items.getLive().size() + items.getDailyImage().size()) {
            return R.id.image_home_dailyImage;
        } else if (position == items.getFirstImage().size() + items.getLive().size() + items.getDailyFadel().size() & position < items.getFirstImage().size()
                + items.getLive().size() + items.getDailyImage().size() + items.getDailyFadel().size()) {
            return R.id.home_textFadel;
        } else if (position == items.getFirstImage().size() + items.getLive().size() + items.getDailyFadel().size() + items.getSaleheenSaid().size() & position < items.getFirstImage().size()
                + items.getLive().size() + items.getDailyImage().size() + items.getDailyFadel().size() + items.getSaleheenSaid().size()) {
            return R.id.image_home_textSaleheen;
        }
        return R.id.image_home_firstImage;
    }

    /*
        @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == R.id.image_home_firstImage) {
            FirstImageModel firstImageModel = items.getFirstImage().get(position);
            ((FirstImageViewHolder) holder).setFirstImageData(firstImageModel);

        } else if (getItemViewType(position) == R.id.image_home_dailyImage) {
            DailyImageModel liveModel = items.getDailyImage().get(position - items.getFirstImage().size());
            ((DailyImageViewHolder) holder).setDailyImageData(liveModel);

        } else if (getItemViewType(position) == R.id.image_home_liveImage) {
            LiveModel dailyImageModel = items.getLive().get(position - (items.getFirstImage().size() + items.getDailyImage().size()));
            ((LiveViewHolder) holder).set(dailyImageModel);
        }
    }

    @Override
    public int getItemCount() {
        if (items ==null) return 0;
        return items.getFirstImage().size() + items.getDailyImage().size() + items.getLive().size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 && position < items.getFirstImage().size()) {
            return R.id.image_home_firstImage;
        } else if (position == items.getFirstImage().size() && position < items.getFirstImage().size() + items.getDailyImage().size()) {
            return R.id.image_home_dailyImage;
        } else if (position == items.getFirstImage().size()
                + items.getDailyImage().size() && position < items.getFirstImage().size()
                + items.getDailyImage().size()
                + items.getLive().size()) {
            return R.id.image_home_liveImage;
        }
     */

    /* firstImage Adapter */
    static class FirstImageViewHolder extends RecyclerView.ViewHolder {
        private final ImageView firstImage;

        FirstImageViewHolder(@NonNull View itemView) {
            super(itemView);
            firstImage = itemView.findViewById(R.id.image_home_firstImage);
        }

        void setFirstImageData(FirstImageModel firstImageModel) {
            Glide.with(itemView.getContext())
                    .load(firstImageModel.getFirstImageUrl())
                    .into(firstImage);
        }
    }

    /* Live Adapter */
    static class LiveViewHolder extends RecyclerView.ViewHolder {
        private final ImageView liveImage;

        LiveViewHolder(@NonNull View itemView) {
            super(itemView);
            liveImage = itemView.findViewById(R.id.image_home_liveImage);
        }

        void setLiveImageData(LiveModel liveModel) {
            Glide.with(itemView.getContext())
                    .load(liveModel.getImageLiveInfoUrl())
                    .into(liveImage);
        }
    }

    /* DailyImage Adapter */
    static class DailyImageViewHolder extends RecyclerView.ViewHolder {
        private final ImageView dailyImage;

        DailyImageViewHolder(@NonNull View itemView) {
            super(itemView);
            dailyImage = itemView.findViewById(R.id.image_home_dailyImage);
        }

        void setDailyImageData(DailyImageModel dailyImageModel) {
            Glide.with(itemView.getContext())
                    .load(dailyImageModel.getDailyImageUrl())
                    .into(dailyImage);
        }
    }

    /* DailyFadel Adapter */
    static class DailyFadelViewHolder extends RecyclerView.ViewHolder {
        private final TextView dailyFadel;

        DailyFadelViewHolder(@NonNull View itemView) {
            super(itemView);
            dailyFadel = itemView.findViewById(R.id.home_textFadel);
        }

        void setDailyFadelData(DailyFadelModel dailyFadelModel) {
            dailyFadel.setText(dailyFadelModel.getDailyFadelText());
        }
    }

    /* SaleheenSaid Adapter */
    static class SaleheenSaidViewHolder extends RecyclerView.ViewHolder {
        private final TextView saleheenSaidText;

        SaleheenSaidViewHolder(@NonNull View itemView) {
            super(itemView);
            saleheenSaidText = itemView.findViewById(R.id.image_home_textSaleheen);
        }

        void setSaleheenSaidData(SaleheenSaidModel saleheenSaidModel) {
            saleheenSaidText.setText(saleheenSaidModel.getSaleheenText());
        }
    }
}
