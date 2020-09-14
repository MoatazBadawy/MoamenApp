package com.picsapp.moamenapp.Quran.ui.main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.picsapp.moamenapp.Quran.model.Data;
import com.picsapp.moamenapp.Quran.ui.quran.QuranActivity;
import com.picsapp.moamenapp.R;

import java.util.List;

import static com.picsapp.moamenapp.Quran.ui.main.QuranReadingFragment.SURAH_NUMBER;


public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.SurahViewHolder> {

    private List<Data> surahList;

    @NonNull
    @Override
    public SurahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SurahViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_quran, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull final SurahViewHolder holder, int position) {
        final Data surah = surahList.get(position);

        holder.surahName.setText(surah.getName());
        holder.RevelationType.setText(surah.getRevelationType());
        holder.SurahNumber.setText(surah.getnumberSurah());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, QuranActivity.class);
                intent.putExtra(SURAH_NUMBER, surah.getPage());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
         return surahList != null ? surahList.size() : 0;
    }

    public void submitList(List<Data> surahList) {
        this.surahList = surahList;
        notifyDataSetChanged();
    }

    static class SurahViewHolder extends RecyclerView.ViewHolder {
        private TextView surahName;
        private TextView RevelationType;
        private TextView SurahNumber;

        public SurahViewHolder(@NonNull View itemView) {
            super(itemView);
            surahName = itemView.findViewById(R.id.surah_name);
            RevelationType = itemView.findViewById(R.id.surah_detail);
            SurahNumber = itemView.findViewById(R.id.surah_number);
        }
    }
}
