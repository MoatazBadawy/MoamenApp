package com.picsapp.moamenapp.Adapter.Quran;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.picsapp.moamenapp.Activity.QuranActivity.*;
import com.picsapp.moamenapp.R;

import java.util.ArrayList;


public class RecyclerViewQuran extends RecyclerView.Adapter<RecyclerViewQuran.ViewHolder> {

    private ArrayList<QuranListDetail> item;

    public RecyclerViewQuran(FragmentActivity activity, ArrayList<QuranListDetail> items) {
        this.item = items;
    }

    @Override
    public RecyclerViewQuran.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_quran, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewQuran.ViewHolder holder, final int position) {
        holder.itemTitle.setText(item.get(position).getSurahName());
        holder.itemDetail.setText(item.get(position).getSurahDetail());
        holder.itemNumber.setText(item.get(position).getSurahNumber());

        // click listener to open new activity "shurah"
        holder.itemClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                // surah 1
                if (position == 0) {
                    Intent intent = new Intent(context, QuranSurah1.class);
                    context.startActivity(intent);
                }
                // surah 2
                else if (position == 1) {
                    Intent intent = new Intent(context, QuranSurah2.class);
                    context.startActivity(intent);
                }
                // surah 3
                else if (position == 2) {
                    Intent intent = new Intent(context, QuranSurah3.class);
                    context.startActivity(intent);
                }
                // surah 4
                else if (position == 3) {
                    Intent intent = new Intent(context, QuranSurah4.class);
                    context.startActivity(intent);
                }
                // surah 5
                else if (position == 4) {
                    Intent intent = new Intent(context, QuranSurah5.class);
                    context.startActivity(intent);
                }
                // surah 6
                else if (position == 5) {
                    Intent intent = new Intent(context, QuranSurah6.class);
                    context.startActivity(intent);
                }
                // surah 7
                else if (position == 6) {
                    Intent intent = new Intent(context, QuranSurah7.class);
                    context.startActivity(intent);
                }
                // surah 8
                else if (position == 7) {
                    Intent intent = new Intent(context, QuranSurah8.class);
                    context.startActivity(intent);
                }
                // surah 9
                else if (position == 8) {
                    Intent intent = new Intent(context, QuranSurah9.class);
                    context.startActivity(intent);
                }
                // surah 10
                else if (position == 9) {
                    Intent intent = new Intent(context, QuranSurah10.class);
                    context.startActivity(intent);
                }
                // surah 11
                else if (position == 10) {
                    Intent intent = new Intent(context, QuranSurah11.class);
                    context.startActivity(intent);
                }
                // surah 12
                else if (position == 11) {
                    Intent intent = new Intent(context, QuranSurah12.class);
                    context.startActivity(intent);
                }
                // surah 13
                else if (position == 12) {
                    Intent intent = new Intent(context, QuranSurah13.class);
                    context.startActivity(intent);
                }
                // surah 14
                else if (position == 13) {
                    Intent intent = new Intent(context, QuranSurah14.class);
                    context.startActivity(intent);
                }
                // surah 15
                else if (position == 14) {
                    Intent intent = new Intent(context, QuranSurah15.class);
                    context.startActivity(intent);
                }
                // surah 16
                else if (position == 15) {
                    Intent intent = new Intent(context, QuranSurah16.class);
                    context.startActivity(intent);
                }
                // surah 17
                else if (position == 16) {
                    Intent intent = new Intent(context, QuranSurah17.class);
                    context.startActivity(intent);
                }
                // surah 18
                else if (position == 17) {
                    Intent intent = new Intent(context, QuranSurah18.class);
                    context.startActivity(intent);
                }
                // surah 19
                else if (position == 18) {
                    Intent intent = new Intent(context, QuranSurah19.class);
                    context.startActivity(intent);
                }
                // surah 20
                else if (position == 19) {
                    Intent intent = new Intent(context, QuranSurah20.class);
                    context.startActivity(intent);
                }
                // surah 21
                else if (position == 20) {
                    Intent intent = new Intent(context, QuranSurah21.class);
                    context.startActivity(intent);
                }
                // surah 22
                else if (position == 21) {
                    Intent intent = new Intent(context, QuranSurah22.class);
                    context.startActivity(intent);
                }
                // surah 23
                else if (position == 22) {
                    Intent intent = new Intent(context, QuranSurah23.class);
                    context.startActivity(intent);
                }
                // surah 24
                else if (position == 23) {
                    Intent intent = new Intent(context, QuranSurah24.class);
                    context.startActivity(intent);
                }
                // surah 25
                else if (position == 24) {
                    Intent intent = new Intent(context, QuranSurah25.class);
                    context.startActivity(intent);
                }
                // surah 26
                else if (position == 25) {
                    Intent intent = new Intent(context, QuranSurah26.class);
                    context.startActivity(intent);
                }
                // surah 27
                else if (position == 26) {
                    Intent intent = new Intent(context, QuranSurah27.class);
                    context.startActivity(intent);
                }
                // surah 28
                else if (position == 27) {
                    Intent intent = new Intent(context, QuranSurah28.class);
                    context.startActivity(intent);
                }
                // surah 29
                else if (position == 28) {
                    Intent intent = new Intent(context, QuranSurah29.class);
                    context.startActivity(intent);
                }
                // surah 30
                else if (position == 29) {
                    Intent intent = new Intent(context, QuranSurah30.class);
                    context.startActivity(intent);
                }
                // surah 31
                else if (position == 30) {
                    Intent intent = new Intent(context, QuranSurah31.class);
                    context.startActivity(intent);
                }
                // surah 32
                else if (position == 31) {
                    Intent intent = new Intent(context, QuranSurah32.class);
                    context.startActivity(intent);
                }
                // surah 33
                else if (position == 32) {
                    Intent intent = new Intent(context, QuranSurah33.class);
                    context.startActivity(intent);
                }
                // surah 34
                else if (position == 33) {
                    Intent intent = new Intent(context, QuranSurah34.class);
                    context.startActivity(intent);
                }
                // surah 35
                else if (position == 34) {
                    Intent intent = new Intent(context, QuranSurah35.class);
                    context.startActivity(intent);
                }
                // surah 36
                else if (position == 35) {
                    Intent intent = new Intent(context, QuranSurah36.class);
                    context.startActivity(intent);
                }
                // surah 37
                else if (position == 36) {
                    Intent intent = new Intent(context, QuranSurah37.class);
                    context.startActivity(intent);
                }
                // surah 38
                else if (position == 37) {
                    Intent intent = new Intent(context, QuranSurah38.class);
                    context.startActivity(intent);
                }
                // surah 39
                else if (position == 38) {
                    Intent intent = new Intent(context, QuranSurah39.class);
                    context.startActivity(intent);
                }
                // surah 40
                else if (position == 39) {
                    Intent intent = new Intent(context, QuranSurah40.class);
                    context.startActivity(intent);
                }
                // surah 41
                else if (position == 40) {
                    Intent intent = new Intent(context, QuranSurah41.class);
                    context.startActivity(intent);
                }
                // surah 42
                else if (position == 41) {
                    Intent intent = new Intent(context, QuranSurah42.class);
                    context.startActivity(intent);
                }

                // surah 43
                else if (position == 42) {
                    Intent intent = new Intent(context, QuranSurah43.class);
                    context.startActivity(intent);
                }
                // surah 44
                else if (position == 43) {
                    Intent intent = new Intent(context, QuranSurah44.class);
                    context.startActivity(intent);
                }
                // surah 45
                else if (position == 44) {
                    Intent intent = new Intent(context, QuranSurah45.class);
                    context.startActivity(intent);
                }
                // surah 46
                else if (position == 45) {
                    Intent intent = new Intent(context, QuranSurah46.class);
                    context.startActivity(intent);
                }
                // surah 47
                else if (position == 46) {
                    Intent intent = new Intent(context, QuranSurah47.class);
                    context.startActivity(intent);
                }
                // surah 48
                else if (position == 47) {
                    Intent intent = new Intent(context, QuranSurah48.class);
                    context.startActivity(intent);
                }
                // surah 49
                else if (position == 48) {
                    Intent intent = new Intent(context, QuranSurah49.class);
                    context.startActivity(intent);
                }
                // surah 50
                else if (position == 49) {
                    Intent intent = new Intent(context, QuranSurah50.class);
                    context.startActivity(intent);
                }

                // surah 51
                else if (position == 50) {
                    Intent intent = new Intent(context, QuranSurah51.class);
                    context.startActivity(intent);
                }
                // surah 52
                else if (position == 51) {
                    Intent intent = new Intent(context, QuranSurah52.class);
                    context.startActivity(intent);
                }
                // surah 53
                else if (position == 52) {
                    Intent intent = new Intent(context, QuranSurah53.class);
                    context.startActivity(intent);
                }
                // surah 54
                else if (position == 53) {
                    Intent intent = new Intent(context, QuranSurah54.class);
                    context.startActivity(intent);
                }
                // surah 55
                else if (position == 54) {
                    Intent intent = new Intent(context, QuranSurah55.class);
                    context.startActivity(intent);
                }
                // surah 56
                else if (position == 55) {
                    Intent intent = new Intent(context, QuranSurah56.class);
                    context.startActivity(intent);
                }
                // surah 57
                else if (position == 56) {
                    Intent intent = new Intent(context, QuranSurah57.class);
                    context.startActivity(intent);
                }
                // surah 58
                else if (position == 57) {
                    Intent intent = new Intent(context, QuranSurah58.class);
                    context.startActivity(intent);
                }
                // surah 59
                else if (position == 58) {
                    Intent intent = new Intent(context, QuranSurah59.class);
                    context.startActivity(intent);
                }
                // surah 60
                else if (position == 59) {
                    Intent intent = new Intent(context, QuranSurah60.class);
                    context.startActivity(intent);
                }
                // surah 61
                else if (position == 60) {
                    Intent intent = new Intent(context, QuranSurah61.class);
                    context.startActivity(intent);
                }
                // surah 62
                else if (position == 61) {
                    Intent intent = new Intent(context, QuranSurah62.class);
                    context.startActivity(intent);
                }
                // surah 63
                else if (position == 62) {
                    Intent intent = new Intent(context, QuranSurah63.class);
                    context.startActivity(intent);
                }
                // surah 64
                else if (position == 63) {
                    Intent intent = new Intent(context, QuranSurah64.class);
                    context.startActivity(intent);
                }
                // surah 65
                else if (position == 64) {
                    Intent intent = new Intent(context, QuranSurah65.class);
                    context.startActivity(intent);
                }
                // surah 66
                else if (position == 65) {
                    Intent intent = new Intent(context, QuranSurah66.class);
                    context.startActivity(intent);
                }
                // surah 67
                else if (position == 66) {
                    Intent intent = new Intent(context, QuranSurah67.class);
                    context.startActivity(intent);
                }
                // surah 68
                else if (position == 67) {
                    Intent intent = new Intent(context, QuranSurah68.class);
                    context.startActivity(intent);
                }
                // surah 69
                else if (position == 68) {
                    Intent intent = new Intent(context, QuranSurah69.class);
                    context.startActivity(intent);
                }
                // surah 70
                else if (position == 69) {
                    Intent intent = new Intent(context, QuranSurah70.class);
                    context.startActivity(intent);
                }
                // surah 71
                else if (position == 70) {
                    Intent intent = new Intent(context, QuranSurah71.class);
                    context.startActivity(intent);
                }
                // surah 72
                else if (position == 71) {
                    Intent intent = new Intent(context, QuranSurah72.class);
                    context.startActivity(intent);
                }
                // surah 73
                else if (position == 72) {
                    Intent intent = new Intent(context, QuranSurah73.class);
                    context.startActivity(intent);
                }
                // surah 74
                else if (position == 73) {
                    Intent intent = new Intent(context, QuranSurah74.class);
                    context.startActivity(intent);
                }
                // surah 75
                else if (position == 74) {
                    Intent intent = new Intent(context, QuranSurah75.class);
                    context.startActivity(intent);
                }
                // surah 76
                else if (position == 75) {
                    Intent intent = new Intent(context, QuranSurah76.class);
                    context.startActivity(intent);
                }
                // surah 77
                else if (position == 76) {
                    Intent intent = new Intent(context, QuranSurah77.class);
                    context.startActivity(intent);
                }
                // surah 78
                else if (position == 77) {
                    Intent intent = new Intent(context, QuranSurah78.class);
                    context.startActivity(intent);
                }
                // surah 79
                else if (position == 78) {
                    Intent intent = new Intent(context, QuranSurah79.class);
                    context.startActivity(intent);
                }
                // surah 80
                else if (position == 79) {
                    Intent intent = new Intent(context, QuranSurah80.class);
                    context.startActivity(intent);
                }
                // surah 81
                else if (position == 80) {
                    Intent intent = new Intent(context, QuranSurah81.class);
                    context.startActivity(intent);
                }
                // surah 82
                else if (position == 81) {
                    Intent intent = new Intent(context, QuranSurah82.class);
                    context.startActivity(intent);
                }
                // surah 83
                else if (position == 82) {
                    Intent intent = new Intent(context, QuranSurah83.class);
                    context.startActivity(intent);
                }
                // surah 84
                else if (position == 83) {
                    Intent intent = new Intent(context, QuranSurah84.class);
                    context.startActivity(intent);
                }
                // surah 85
                else if (position == 84) {
                    Intent intent = new Intent(context, QuranSurah85.class);
                    context.startActivity(intent);
                }
                // surah 86
                else if (position == 85) {
                    Intent intent = new Intent(context, QuranSurah86.class);
                    context.startActivity(intent);
                }
                // surah 87
                else if (position == 86) {
                    Intent intent = new Intent(context, QuranSurah87.class);
                    context.startActivity(intent);
                }
                // surah 88
                else if (position == 87) {
                    Intent intent = new Intent(context, QuranSurah88.class);
                    context.startActivity(intent);
                }
                // surah 89
                else if (position == 88) {
                    Intent intent = new Intent(context, QuranSurah89.class);
                    context.startActivity(intent);
                }
                // surah 90
                else if (position == 89) {
                    Intent intent = new Intent(context, QuranSurah90.class);
                    context.startActivity(intent);
                }
                // surah 91
                else if (position == 90) {
                    Intent intent = new Intent(context, QuranSurah91.class);
                    context.startActivity(intent);
                }
                // surah 92
                else if (position == 91) {
                    Intent intent = new Intent(context, QuranSurah92.class);
                    context.startActivity(intent);
                }
                // surah 93
                else if (position == 92) {
                    Intent intent = new Intent(context, QuranSurah93.class);
                    context.startActivity(intent);
                }
                // surah 94
                else if (position == 93) {
                    Intent intent = new Intent(context, QuranSurah94.class);
                    context.startActivity(intent);
                }
                // surah 95
                else if (position == 94) {
                    Intent intent = new Intent(context, QuranSurah95.class);
                    context.startActivity(intent);
                }
                // surah 96
                else if (position == 95) {
                    Intent intent = new Intent(context, QuranSurah96.class);
                    context.startActivity(intent);
                }
                // surah 97
                else if (position == 96) {
                    Intent intent = new Intent(context, QuranSurah97.class);
                    context.startActivity(intent);
                }
                // surah 98
                else if (position == 97) {
                    Intent intent = new Intent(context, QuranSurah98.class);
                    context.startActivity(intent);
                }
                // surah 99
                else if (position == 98) {
                    Intent intent = new Intent(context, QuranSurah99.class);
                    context.startActivity(intent);
                }
                // surah 100
                else if (position == 99) {
                    Intent intent = new Intent(context, QuranSurah100.class);
                    context.startActivity(intent);
                }
                // surah 101
                else if (position == 100) {
                    Intent intent = new Intent(context, QuranSurah101.class);
                    context.startActivity(intent);
                }
                // surah 102
                else if (position == 101) {
                    Intent intent = new Intent(context, QuranSurah102.class);
                    context.startActivity(intent);
                }
                // surah 103
                else if (position == 102) {
                    Intent intent = new Intent(context, QuranSurah103.class);
                    context.startActivity(intent);
                }
                // surah 104
                else if (position == 103) {
                    Intent intent = new Intent(context, QuranSurah104.class);
                    context.startActivity(intent);
                }
                // surah 105
                else if (position == 104) {
                    Intent intent = new Intent(context, QuranSurah105.class);
                    context.startActivity(intent);
                }
                // surah 106
                else if (position == 105) {
                    Intent intent = new Intent(context, QuranSurah106.class);
                    context.startActivity(intent);
                }
                // surah 107
                else if (position == 106) {
                    Intent intent = new Intent(context, QuranSurah107.class);
                    context.startActivity(intent);
                }
                // surah 108
                else if (position == 107) {
                    Intent intent = new Intent(context, QuranSurah108.class);
                    context.startActivity(intent);
                }
                // surah 109
                else if (position == 108) {
                    Intent intent = new Intent(context, QuranSurah109.class);
                    context.startActivity(intent);
                }
                // surah 110
                else if (position == 109) {
                    Intent intent = new Intent(context, QuranSurah110.class);
                    context.startActivity(intent);
                }
                // surah 111
                else if (position == 110) {
                    Intent intent = new Intent(context, QuranSurah111.class);
                    context.startActivity(intent);
                }
                // surah 112
                else if (position == 111) {
                    Intent intent = new Intent(context, QuranSurah112.class);
                    context.startActivity(intent);
                }
                // surah 113
                else if (position == 112) {
                    Intent intent = new Intent(context, QuranSurah113.class);
                    context.startActivity(intent);
                }
                // surah 114
                else if (position == 113) {
                    Intent intent = new Intent(context, QuranSurah114.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return item.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTitle;
        private TextView itemDetail;
        private TextView itemNumber;
        private View itemClick;

        public ViewHolder(View view) {
            super(view);
            itemTitle = view.findViewById(R.id.surah_name);
            itemDetail = view.findViewById(R.id.surah_detail);
            itemNumber = view.findViewById(R.id.surah_number);
            itemClick = view.findViewById(R.id.item_click);
        }
    }
}
