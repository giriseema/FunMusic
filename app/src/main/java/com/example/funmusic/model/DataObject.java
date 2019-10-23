package com.example.funmusic.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class DataObject implements Parcelable {
    int resultCount;
    List<SongBean> results;

    protected DataObject(Parcel in) {
        resultCount = in.readInt();
    }

    public static final Creator<DataObject> CREATOR = new Creator<DataObject>() {
        @Override
        public DataObject createFromParcel(Parcel in) {
            return new DataObject(in);
        }

        @Override
        public DataObject[] newArray(int size) {
            return new DataObject[size];
        }
    };

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<SongBean> getResults() {
        return results;
    }

    public void setResults(List<SongBean> results) {
        this.results = results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(resultCount);
    }
}

