package com.example.funmusic.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.funmusic.R;
import com.example.funmusic.room.Songs;

import java.util.ArrayList;
import java.util.List;

public class HistorySongAdapter extends RecyclerView.Adapter<HistorySongAdapter.HistorySongHolder>{
    List<Songs> historySongs=new ArrayList<>();
    Context context;
    public HistorySongAdapter(Context context){
        this.context=context;
    }
    @NonNull
    @Override
    public HistorySongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_song_item, parent, false);
        return new HistorySongHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HistorySongHolder holder, int position) {
        final Songs currentNote = historySongs.get(position);
        holder.songName.setText(currentNote.getTrackName());
        Glide.with(context).load(currentNote.getArtworkUrl100()).into(holder.songThumbnail);
    }

    @Override
    public int getItemCount() {
        return historySongs.size();
    }
    public void setHistorySongs(List<Songs> songBeanList) {
        historySongs = songBeanList;
        notifyDataSetChanged();
    }
    class HistorySongHolder extends RecyclerView.ViewHolder {
        private TextView songName;
        private ImageView songThumbnail;
        private LinearLayout rowContainer;

        public HistorySongHolder(View itemView) {
            super(itemView);
            songName = itemView.findViewById(R.id.song_name);
            songThumbnail = itemView.findViewById(R.id.song_thumbnail);
            rowContainer = itemView.findViewById(R.id.item_row);
        }
    }
}
