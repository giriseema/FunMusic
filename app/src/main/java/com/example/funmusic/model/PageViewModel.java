package com.example.funmusic.model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.funmusic.room.Songs;
import com.example.funmusic.room.SongsRepositry;
import com.example.funmusic.utility.ApplicationClass;
import com.example.funmusic.utility.CustomStringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PageViewModel extends AndroidViewModel{
    String BASE_URL = "https://itunes.apple.com/search?term=Michael+jackson&media=musicVideo";
    private MutableLiveData<List<SongBean>> videoSongList;
    private SongsRepositry repository;
    private LiveData<List<Songs>> allSongs;


    public PageViewModel(@NonNull Application application) {
        super(application);
        repository = new SongsRepositry(application);
        allSongs = repository.getAllSongs();
    }

    public void insert(Songs note) {
        repository.insert(note);
    }
    public LiveData<List<Songs>> getAllNotes() {
        return allSongs;
    }

    //we will call this method to get the data
    public LiveData<List<SongBean>> getVideoSongs() {
        //if the list is null
        if (videoSongList == null) {
            videoSongList = new MutableLiveData<List<SongBean>>();
            //we will load it asynchronously from server in this method
            loadVideoSongs();
        }
        //finally we will return the list
        return videoSongList;
    }

    private void loadVideoSongs() {
        CustomStringRequest stringRequest = new CustomStringRequest(BASE_URL,
                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            ArrayList<SongBean>   sourcesModelArrayList = new ArrayList<>();
                            if (response != null) {
                                Log.i("Response",response.toString());
                                JSONArray arrayStr = response.getJSONArray("results");
                                Type songType = new TypeToken<ArrayList<SongBean>>() {
                                }.getType();
                                sourcesModelArrayList = new Gson().fromJson(String.valueOf(arrayStr), songType);
                               // wsResponse.response(sourcesModelArrayList,true);
                               videoSongList.setValue(sourcesModelArrayList);

                            }

                        } catch (Exception timeTableExp) {
                            timeTableExp.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                videoSongList.setValue(null);
            }
        });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(90000, 0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        ApplicationClass.getInstance().addToRequestQueue(stringRequest);
    }
}