package com.example.funmusic.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "songs_history_table")
public class Songs {
    @PrimaryKey
    private int trackId;
    private int artistId;
    private int collectionId;
    private String  artistName;
    private String trackName;
    private String collectionName;

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    private String artworkUrl100;

    public Songs(int trackId,
                 String trackName,
                 String artistName,
                 String artworkUrl100) {
        this.trackId = trackId;
        this.artistName = artistName;
        this.trackName = trackName;
        this.artworkUrl100 = artworkUrl100;
    }
    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }


}
