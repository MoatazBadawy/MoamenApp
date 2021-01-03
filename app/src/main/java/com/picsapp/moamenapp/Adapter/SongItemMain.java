package com.picsapp.moamenapp.Adapter;

public class SongItemMain {

    // Drawable resource ID for song image
    private int mImageSongResourceId;

    // Name of the song
    private String mSongName;


    /*
     * Create a new SongDetail object.
     * @param vSongName is the name of the song
     * @param vSongSinger is the singer name
     * @param imageSongResourceId is drawable reference ID that corresponds to the Android version
     * */
    public SongItemMain(int imageSongResourceId, String vSongName) {
        mImageSongResourceId = imageSongResourceId;
        mSongName = vSongName;
    }


    // get image of the song resource id
    public int getImageSongResourceId() {
        return mImageSongResourceId;
    }

    // get the name of the song
    public String getSongName() {
        return mSongName;
    }
}
