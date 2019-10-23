package com.example.funmusic.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SongBean implements Parcelable {
    String wrapperType;
    String kind;
    String artistId;
    String collectionId;
    String trackId;
    String artistName;
    String collectionName;
    String trackName;
    String collectionCensoredName;
    String trackCensoredName;
    String artistViewUrl;
    String collectionViewUrl;
    String previewUrl;
    String artworkUrl100;
    String artworkUrl60;
    String artworkUrl30;
    String collectionPrice;
    String trackPrice;
    String collectionExplicitness;
    String trackExplicitness;
    String releaseDate;
    String discCount;
    String discNumber;
    String trackTimeMillis;
    String country;
    String currency;
    String primaryGenreName;


    protected SongBean(Parcel in) {
        wrapperType = in.readString();
        kind = in.readString();
        artistId = in.readString();
        collectionId = in.readString();
        trackId = in.readString();
        artistName = in.readString();
        collectionName = in.readString();
        trackName = in.readString();
        collectionCensoredName = in.readString();
        trackCensoredName = in.readString();
        artistViewUrl = in.readString();
        collectionViewUrl = in.readString();
        previewUrl = in.readString();
        artworkUrl100 = in.readString();
        artworkUrl60 = in.readString();
        artworkUrl30 = in.readString();
        collectionPrice = in.readString();
        trackPrice = in.readString();
        collectionExplicitness = in.readString();
        trackExplicitness = in.readString();
        releaseDate = in.readString();
        discCount = in.readString();
        discNumber = in.readString();
        trackTimeMillis = in.readString();
        country = in.readString();
        currency = in.readString();
        primaryGenreName = in.readString();
    }

    public static final Creator<SongBean> CREATOR = new Creator<SongBean>() {
        @Override
        public SongBean createFromParcel(Parcel in) {
            return new SongBean(in);
        }

        @Override
        public SongBean[] newArray(int size) {
            return new SongBean[size];
        }
    };

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    public String getCollectionPrice() {
        return collectionPrice;
    }

    public void setCollectionPrice(String collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    public String getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(String trackPrice) {
        this.trackPrice = trackPrice;
    }

    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    public String getTrackExplicitness() {
        return trackExplicitness;
    }

    public void setTrackExplicitness(String trackExplicitness) {
        this.trackExplicitness = trackExplicitness;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDiscCount() {
        return discCount;
    }

    public void setDiscCount(String discCount) {
        this.discCount = discCount;
    }

    public String getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(String discNumber) {
        this.discNumber = discNumber;
    }

    public String getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public void setTrackTimeMillis(String trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }


    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(wrapperType);
        parcel.writeString(kind);
        parcel.writeString(artistId);
        parcel.writeString(collectionId);
        parcel.writeString(trackId);
        parcel.writeString(artistName);
        parcel.writeString(collectionName);
        parcel.writeString(trackName);
        parcel.writeString(collectionCensoredName);
        parcel.writeString(trackCensoredName);
        parcel.writeString(artistViewUrl);
        parcel.writeString(collectionViewUrl);
        parcel.writeString(previewUrl);
        parcel.writeString(artworkUrl100);
        parcel.writeString(artworkUrl60);
        parcel.writeString(artworkUrl30);
        parcel.writeString(collectionPrice);
        parcel.writeString(trackPrice);
        parcel.writeString(collectionExplicitness);
        parcel.writeString(trackExplicitness);
        parcel.writeString(releaseDate);
        parcel.writeString(discCount);
        parcel.writeString(discNumber);
        parcel.writeString(trackTimeMillis);
        parcel.writeString(country);
        parcel.writeString(currency);
        parcel.writeString(primaryGenreName);
    }
}
