package com.example.funmusic.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.funmusic.MainActivity;
import com.example.funmusic.R;
import com.example.funmusic.model.PageViewModel;
import com.example.funmusic.model.SongBean;
import com.example.funmusic.room.Songs;
import com.example.funmusic.view.adapter.HistorySongAdapter;
import com.example.funmusic.view.adapter.VideoSongAdapter;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class HistoryFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private HistorySongAdapter songAdapter;
    private RecyclerView songRecyclerView;
    private MainActivity _this;


    public static HistoryFragment newInstance(int index) {
        HistoryFragment fragment = new HistoryFragment();
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
        pageViewModel.getAllNotes().observe(this, new Observer<List<Songs>>() {
            @Override
            public void onChanged(@Nullable List<Songs> notes) {
                //update RecyclerView
              //  Toast.makeText(_this, "onChanged", Toast.LENGTH_SHORT).show();
                if(notes!=null&&notes.size()>0)
                songAdapter.setHistorySongs(notes);
               // else
              //   Toast.makeText(_this, getString(R.string.no_result_found), Toast.LENGTH_SHORT).show();

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
        songAdapter  = new HistorySongAdapter(_this);
        songRecyclerView.setAdapter(songAdapter);

        return root;
    }
}