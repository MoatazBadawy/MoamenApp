package com.picsapp.moamenapp.Adapter.Quran;

public class QuranListDetail {

    // Name of surah
    private String mSurahName;

    // Surah Detail
    private String mSurahDetail;

    // Surah Nuumber
    private String mSurahNumber;


    /*
     * Create a new SongDetail object.
     * @param vSurahName is the name of the song
     * @param vSongSinger is the singer name
     * @param imageSongResourceId is drawable reference ID that corresponds to the Android version
     * @param imageMenuResourceId is drawable reference ID that corresponds to the Android version
     * */
    public QuranListDetail(String vSurahName, String vSurahDetail, String vSurahNumber) {
        mSurahName = vSurahName;
        mSurahDetail = vSurahDetail;
        mSurahNumber = vSurahNumber;
    }


    // get Name of surah
    public String getSurahName() {
        return mSurahName;
    }

    // get the Surah Detail
    public String getSurahDetail() {
        return mSurahDetail;
    }

    // get Surah Number
    public String getSurahNumber() {
        return mSurahNumber;
    }
}
