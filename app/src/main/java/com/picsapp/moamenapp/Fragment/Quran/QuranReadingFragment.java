package com.picsapp.moamenapp.Fragment.Quran;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.picsapp.moamenapp.Adapter.Quran.QuranListDetail;
import com.picsapp.moamenapp.Adapter.Quran.RecyclerViewQuran;
import com.picsapp.moamenapp.R;

import java.util.ArrayList;


public class QuranReadingFragment extends Fragment {

    ArrayList<QuranListDetail> QuranListDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_quran_reading, container, false);

        // ArrayList for Quran
        ArrayListQuran();
        // get the reference of RecyclerView
        RecyclerView recyclerView = rootview.findViewById(R.id.recyclerview_quran_reading);
        // set a LinearLayoutManager with default orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView
        RecyclerViewQuran adapter = new RecyclerViewQuran(getActivity(), QuranListDetails);
        recyclerView.setAdapter(adapter);

        return rootview;

    }

    // ArrayList for Quran
    public void ArrayListQuran() {
        // ArrayList for Surah name
        QuranListDetails = new ArrayList<QuranListDetail>();
        // 1
        QuranListDetails.add(new QuranListDetail("سورة الفاتحة", "مكية - ٧ آيات", "١"));
        // 2
        QuranListDetails.add(new QuranListDetail("سورة البقرة", "مدنية - ٢٨٦ آية", "٢"));
        // 3
        QuranListDetails.add(new QuranListDetail("سورة آل عمران", "مدنية - ٢٠٠ آية", "٣"));
        // 4
        QuranListDetails.add(new QuranListDetail("سورة النساء", "مدنية - ١٧٦ آية", "٤"));
        // 5
        QuranListDetails.add(new QuranListDetail("سورة المائدة", "مدنية - ١٢٠ آية", "٥"));
        // 6
        QuranListDetails.add(new QuranListDetail("سورة الأنعام", "مكية - ١٦٥ آية", "٦"));
        // 7
        QuranListDetails.add(new QuranListDetail("سورة الأعراف", "مكية - ٢٠٦ آية", "٧"));
        // 8
        QuranListDetails.add(new QuranListDetail("سورة الأنفال", "مدنية - ٧٥ آية", "٨"));
        // 9
        QuranListDetails.add(new QuranListDetail("سورة التوبة", "مدنية - ١٢٩ آية", "٩"));
        // 10
        QuranListDetails.add(new QuranListDetail("سورة يونس", "مكية - ١٠٩ آية", "١٠"));
        // 11
        QuranListDetails.add(new QuranListDetail("سورة هود", "مكية - ١٢٣ آية", "١١"));
        // 12
        QuranListDetails.add(new QuranListDetail("سورة يوسف", "مكية - ١١١ آية", "١٢"));
        // 13
        QuranListDetails.add(new QuranListDetail("سورة الرعد", "مدنية - ٤٣ آية", "١٣"));
        // 14
        QuranListDetails.add(new QuranListDetail("سورة إبراهيم", "مكية - ٥٢ آية", "١٤"));
        // 15
        QuranListDetails.add(new QuranListDetail("سورة الحجر", "مكية - ٩٩ آية", "١٥"));
        // 16
        QuranListDetails.add(new QuranListDetail("سورة النحل", "مكية - ١٢٨ آية", "١٦"));
        // 17
        QuranListDetails.add(new QuranListDetail("سورة الإسراء", "مكية - ١١١ آية", "١٧"));
        // 18
        QuranListDetails.add(new QuranListDetail("سورة الكهف", "مكية - ١١٠ آية", "١٨"));
        // 19
        QuranListDetails.add(new QuranListDetail("سورة مريم", "مكية - ٩٨ آية", "١٩"));
        // 20
        QuranListDetails.add(new QuranListDetail("سورة طه", "مكية - ١٣٥ آية", "٢٠"));
        // 21
        QuranListDetails.add(new QuranListDetail("سورة الأنبياء", "مكية - ١١٢ آية", "٢١"));
        // 22
        QuranListDetails.add(new QuranListDetail("سورة الحج", "مدنية - ٧٨ آية", "٢٢"));
        // 23
        QuranListDetails.add(new QuranListDetail("سورة المؤمنون", "مكية - ١١٨ آية", "٢٣"));
        // 24
        QuranListDetails.add(new QuranListDetail("سورة النور", "مدنية - ٦٤ آية", "٢٤"));
        // 25
        QuranListDetails.add(new QuranListDetail("سورة الفرقان", "مكية - ٧٧ آية", "٢٥"));
        // 26
        QuranListDetails.add(new QuranListDetail("سورة الشعراء", "مكية - ٢٢٧ آية", "٢٦"));
        // 27
        QuranListDetails.add(new QuranListDetail("سورة النمل", "مكية - ٩٣ آية", "٢٧"));
        // 28
        QuranListDetails.add(new QuranListDetail("سورة القصص", "مكية - ٨٨ آية", "٢٨"));
        // 29
        QuranListDetails.add(new QuranListDetail("سورة العنكبوت", "مكية - ٦٩ آية", "٢٩"));
        // 30
        QuranListDetails.add(new QuranListDetail("سورة الروم", "مكية - ٦٠ آية", "٣٠"));

        // 31
        QuranListDetails.add(new QuranListDetail("سورة لقمان", "مكية - ٣٤ آية", "٣١"));
        // 32
        QuranListDetails.add(new QuranListDetail("سورة السجدة", "مكية - ٣٠ آية", "٣٢"));
        // 33
        QuranListDetails.add(new QuranListDetail("سورة الأحزاب", "مدنية - ٧٣ آية", "٣٣"));
        // 34
        QuranListDetails.add(new QuranListDetail("سورة سبأ", "مكية - ٥٤ آية", "٣٤"));
        // 35
        QuranListDetails.add(new QuranListDetail("سورة فاطر", "مكية - ٤٥ آية", "٣٥"));
        // 36
        QuranListDetails.add(new QuranListDetail("سورة يس", "مكية - ٨٣ آية", "٣٦"));
        // 37
        QuranListDetails.add(new QuranListDetail("سورة الصافات", "مكية - ١٨٢ آية", "٣٧"));
        // 38
        QuranListDetails.add(new QuranListDetail("سورة ص", "مكية - ٨٨ آية", "٣٨"));
        // 39
        QuranListDetails.add(new QuranListDetail("سورة الزمر", "مكية - ٧٥ آية", "٣٩"));
        // 40
        QuranListDetails.add(new QuranListDetail("سورة غافر", "مكية - ٨٥ آية", "٤٠"));
        // 41
        QuranListDetails.add(new QuranListDetail("سورة فصلت", "مكية - ٥٤ آية", "٤١"));
        // 42
        QuranListDetails.add(new QuranListDetail("سورة الشورى", "مكية - ٥٣ آية", "٤٢"));
        // 43
        QuranListDetails.add(new QuranListDetail("سورة الزخرف", "مكية - ٨٩ آية", "٤٣"));
        // 44
        QuranListDetails.add(new QuranListDetail("سورة الدخان", "مكية - ٥٩ آية", "٤٤"));
        // 45
        QuranListDetails.add(new QuranListDetail("سورة الجاثية", "مكية - ٣٧ آية", "٤٥"));
        // 46
        QuranListDetails.add(new QuranListDetail("سورة الأحقاف", "مكية - ٣٥ آية", "٤٦"));
        // 47
        QuranListDetails.add(new QuranListDetail("سورة محمد", "مدنية - ٣٨ آية", "٤٧"));
        // 48
        QuranListDetails.add(new QuranListDetail("سورة الفتح", "مدنية - ٢٩ آية", "٤٨"));
        // 49
        QuranListDetails.add(new QuranListDetail("سورة الحجرات", "مدنية - ١٨ آية", "٤٩"));
        // 50
        QuranListDetails.add(new QuranListDetail("سورة ق", "مكية - ٤٥ آية", "٥٠"));
        // 51
        QuranListDetails.add(new QuranListDetail("سورة الذاريات", "مكية - ٦٠ آية", "٥١"));
        // 52
        QuranListDetails.add(new QuranListDetail("سورة الطور", "مكية - ٤٩ آية", "٥٢"));
        // 53
        QuranListDetails.add(new QuranListDetail("سورة النجم", "مكية - ٦٢ آية", "٥٣"));
        // 54
        QuranListDetails.add(new QuranListDetail("سورة القمر", "مكية - ٥٥ آية", "٥٤"));
        // 55
        QuranListDetails.add(new QuranListDetail("سورة الرحمن", "مدنية - ٧٨ آية", "٥٥"));
        // 56
        QuranListDetails.add(new QuranListDetail("سورة الواقعة", "مكية - ٩٦ آية", "٥٦"));
        // 57
        QuranListDetails.add(new QuranListDetail("سورة الحديد", "مدنية - ٢٩ آية", "٥٧"));
        // 58
        QuranListDetails.add(new QuranListDetail("سورة المجادلة", "مدنية - ٢٢ آية", "٥٨"));
        // 59
        QuranListDetails.add(new QuranListDetail("سورة الحشر", "مدنية - ٢٤ آية", "٥٩"));
        // 60
        QuranListDetails.add(new QuranListDetail("سورة الممتحنة", "مدنية - ١٣ آية", "٦٠"));

        // 61
        QuranListDetails.add(new QuranListDetail("سورة الصف", "مدنية - ١٤ آية", "٦١"));
        // 62
        QuranListDetails.add(new QuranListDetail("سورة الجمعة", "مدنية - ١١ آية", "٦٢"));
        // 63
        QuranListDetails.add(new QuranListDetail("سورة المنافقون", "مدنية - ١١ آية", "٦٣"));
        // 64
        QuranListDetails.add(new QuranListDetail("سورة التغابن", "مدنية - ١٨ آية", "٦٤"));
        // 65
        QuranListDetails.add(new QuranListDetail("سورة الطلاق", "مدنية - ١٢ آية", "٦٥"));
        // 66
        QuranListDetails.add(new QuranListDetail("سورة التحريم", "مدنية - ١٢ آية", "٦٦"));
        // 67
        QuranListDetails.add(new QuranListDetail("سورة الملك", "مكية - ٣٠ آية", "٦٧"));
        // 68
        QuranListDetails.add(new QuranListDetail("سورة القلم", "مكية - ٥٢ آية", "٦٨"));
        // 69
        QuranListDetails.add(new QuranListDetail("سورة الحاقة", "مكية - ٥٢ آية ", "٦٩"));
        // 70
        QuranListDetails.add(new QuranListDetail("سورة المعارج", "مكية - ٤٤ آية", "٧٠"));
        // 71
        QuranListDetails.add(new QuranListDetail("سورة نوح", "مكية - ٢٨ آية", "٧١"));
        // 72
        QuranListDetails.add(new QuranListDetail("سورة الجن", "مكية - ٢٨ آية", "٧٢"));
        // 73
        QuranListDetails.add(new QuranListDetail("سورة المزمل", "مكية - ٢٠ آية", "٧٣"));
        // 74
        QuranListDetails.add(new QuranListDetail("سورة المدثر", "مكية - ٥٦ آية", "٧٤"));
        // 75
        QuranListDetails.add(new QuranListDetail("سورة القيامة", "مكية - ٤٠ آية", "٧٥"));
        // 76
        QuranListDetails.add(new QuranListDetail("سورة الإنسان", "مدنية - ٣١ آية", "٧٦"));
        // 77
        QuranListDetails.add(new QuranListDetail("سورة المرسلات", "مكية - ٥٠ آية", "٧٧"));
        // 78
        QuranListDetails.add(new QuranListDetail("سورة النبأ", "مكية - ٤٠ آية", "٧٨"));
        // 79
        QuranListDetails.add(new QuranListDetail("سورة النازعات", "مكية - ٤٦ آية", "٧٩"));
        // 80
        QuranListDetails.add(new QuranListDetail("سورة عبس", "مكية - ٤٢ آية", "٨٠"));
        // 81
        QuranListDetails.add(new QuranListDetail("سورة التكوير", "مكية - ٢٩ آية", "٨١"));
        // 82
        QuranListDetails.add(new QuranListDetail("سورة الإنفطار", "مكية - ١٩ آية", "٨٢"));
        // 83
        QuranListDetails.add(new QuranListDetail("سورة المطففين", "مكية - ٣٦ آية", "٨٣"));
        // 84
        QuranListDetails.add(new QuranListDetail("سورة الإنشقاق", "مكية - ٢٥ آية", "٨٤"));
        // 85
        QuranListDetails.add(new QuranListDetail("سورة البروج", "مكية - ٢٢ آية", "٨٥"));
        // 86
        QuranListDetails.add(new QuranListDetail("سورة الطارق", "مكية - ١٧ آية", "٨٦"));
        // 87
        QuranListDetails.add(new QuranListDetail("سورة الأعلى", "مكية - ١٩ آية", "٨٧"));
        // 88
        QuranListDetails.add(new QuranListDetail("سورة الغاشية", "مكية - ٢٦ آية", "٨٨"));
        // 89
        QuranListDetails.add(new QuranListDetail("سورة الفجر", "مكية - ٣٠ آية", "٨٩"));
        // 90
        QuranListDetails.add(new QuranListDetail("سورة البلد", "مكية - ٢٠ آية", "٩٠"));
        // 91
        QuranListDetails.add(new QuranListDetail("سورة الشمس", "مكية - ١٥ آية", "٩١"));
        // 92
        QuranListDetails.add(new QuranListDetail("سورة الليل", "مكية - ٢١ آية", "٩٢"));
        // 93
        QuranListDetails.add(new QuranListDetail("سورة الضحى", "مكية - ١١ آية", "٩٣"));
        // 94
        QuranListDetails.add(new QuranListDetail("سورة الشرح", "مكية - ٨ آيات", "٩٤"));
        // 95
        QuranListDetails.add(new QuranListDetail("سورة التين", "مكية - ٨ آيات", "٩٥"));
        // 96
        QuranListDetails.add(new QuranListDetail("سورة العلق", "مكية - ١٩ آية", "٩٦"));
        // 97
        QuranListDetails.add(new QuranListDetail("سورة القدر", "مكية - ٥ آيات", "٩٧"));
        // 98
        QuranListDetails.add(new QuranListDetail("سورة البينة", "مدنية - ٨ آيات", "٩٨"));
        // 99
        QuranListDetails.add(new QuranListDetail("سورة الزلزلة", "مدنية - ٨ آيات", "٩٩"));
        // 100
        QuranListDetails.add(new QuranListDetail("سورة العاديات", "مكية - ١١ آية", "١٠٠"));
        // 101
        QuranListDetails.add(new QuranListDetail("سورة القارعة", "مكية - ١١ آية", "١٠١"));
        // 102
        QuranListDetails.add(new QuranListDetail("سورة التكاثر", "مكية - ٨ آيات", "١٠٢"));
        // 103
        QuranListDetails.add(new QuranListDetail("سورة العصر", "مكية - ٣ آيات", "١٠٣"));
        // 104
        QuranListDetails.add(new QuranListDetail("سورة الهمزة", "مكية - ٩ آيات", "١٠٤"));
        // 105
        QuranListDetails.add(new QuranListDetail("سورة الفيل", "مكية - ٥ آيات", "١٠٥"));
        // 106
        QuranListDetails.add(new QuranListDetail("سورة قريش", "مكية - ٤ آيات", "١٠٦"));
        // 107
        QuranListDetails.add(new QuranListDetail("سورة الماعون", "مكية - ٧ آيات", "١٠٧"));
        // 108
        QuranListDetails.add(new QuranListDetail("سورة الكوثر", "مكية - ٣ آيات", "١٠٨"));
        // 109
        QuranListDetails.add(new QuranListDetail("سورة الكافرون", "مكية - ٦ آيات", "١٠٩"));
        // 110
        QuranListDetails.add(new QuranListDetail("سورة النصر", "مدنية - ٣ آيات", "١١٠"));
        // 111
        QuranListDetails.add(new QuranListDetail("سورة المسد", "مكية - ٥ آيات", "١١١"));
        // 112
        QuranListDetails.add(new QuranListDetail("سورة الإخلاص", "مكية - ٤ آيات", "١١٢"));
        // 113
        QuranListDetails.add(new QuranListDetail("سورة الفلق", "مكية - ٥ آيات", "١١٣"));
        // 114
        QuranListDetails.add(new QuranListDetail("سورة الناس", "مكية - ٦ آيات", "١١٤"));
    }
}