package com.example.funmusic.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.funmusic.MainActivity;
import com.example.funmusic.R;
import com.example.funmusic.model.DataObject;
import com.example.funmusic.model.PageViewModel;
import com.example.funmusic.model.SongBean;
import com.example.funmusic.room.Songs;
import com.example.funmusic.view.adapter.HistorySongAdapter;
import com.example.funmusic.view.adapter.VideoSongAdapter;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment implements VideoSongAdapter.AddHistory {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private VideoSongAdapter songAdapter;
    private PageViewModel pageViewModel;
    private RecyclerView songRecyclerView;
    private MainActivity _this;


    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _this= (MainActivity) getActivity();
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);

        pageViewModel.getVideoSongs().observe(this, new Observer<List<SongBean>>() {
            @Override
            public void onChanged(@Nullable List<SongBean> songBeanList) {
                if(songBeanList!=null)
                    songAdapter.setSongList(songBeanList);
                else
                    Toast.makeText(_this,getString(R.string.no_result_found),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        songRecyclerView = root.findViewById(R.id.song_recycler_view);
        songRecyclerView.setHasFixedSize(true);
        songRecyclerView.setLayoutManager(new LinearLayoutManager(_this));
        songAdapter  = new VideoSongAdapter(_this);
        songAdapter.setInstance(this);
        songRecyclerView.setAdapter(songAdapter);

        return root;
    }

    @Override
    public void addSongsHistory(SongBean songs) {
        Songs note = new Songs(Integer.parseInt(songs.getTrackId()),
                songs.getTrackName(),songs.getArtistName(),
                songs.getArtworkUrl100());

        pageViewModel.insert(note);
    }
}