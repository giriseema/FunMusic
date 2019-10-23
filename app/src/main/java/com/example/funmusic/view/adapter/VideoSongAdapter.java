package com.example.funmusic.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.funmusic.MainActivity;
import com.example.funmusic.R;
import com.example.funmusic.SongDetailActivity;
import com.example.funmusic.model.SongBean;
import com.example.funmusic.room.Songs;

import java.util.ArrayList;
import java.util.List;

public class VideoSongAdapter extends RecyclerView.Adapter<VideoSongAdapter.VideoSongHolder> {
    private List<SongBean> songBeans = new ArrayList<>();
    private Context context;
    AddHistory addHistory;

    public VideoSongAdapter(Context context){
        this.context=context;
    }

    @NonNull
    @Override
    public VideoSongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_song_item, parent, false);
        return new VideoSongHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoSongHolder holder, int position) {
        final SongBean currentNote = songBeans.get(position);
        holder.songName.setText(currentNote.getTrackName());
        Glide.with(context).load(currentNote.getArtworkUrl100()).into(holder.songThumbnail);
        holder.rowContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SongDetailActivity.class);
               // Bundle bundle=new Bundle();
              //  bundle.putParcelable("KEY",currentNote);
                intent.putExtra("KEY",currentNote);
                addHistory.addSongsHistory(currentNote);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return songBeans.size();
    }

    public void setSongList(List<SongBean> songBeanList) {
        songBeans = songBeanList;
        notifyDataSetChanged();
    }

    public void setInstance(AddHistory addHistory) {
        this.addHistory= addHistory;
    }

    class VideoSongHolder extends RecyclerView.ViewHolder {
        private TextView songName;
        private ImageView songThumbnail;
        private LinearLayout rowContainer;

        public VideoSongHolder(View itemView) {
            super(itemView);
            songName = itemView.findViewById(R.id.song_name);
            songThumbnail = itemView.findViewById(R.id.song_thumbnail);
            rowContainer = itemView.findViewById(R.id.item_row);
        }
    }

    public interface AddHistory{
        void addSongsHistory(SongBean songs);
    }
}
