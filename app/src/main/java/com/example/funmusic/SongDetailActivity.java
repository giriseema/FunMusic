package com.example.funmusic;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.funmusic.model.SongBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

import xyz.neocrux.suziloader.SuziLoader;

public class SongDetailActivity extends AppCompatActivity {
    private SongBean songBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);
        songBean=getIntent().getExtras().getParcelable("KEY");
          TextView artistName=findViewById(R.id.artist_name);
          ImageView musicThumbnail=findViewById(R.id.music_thumbnail);
          TextView trackPrice=findViewById(R.id.track_price);
          TextView trackName=findViewById(R.id.track_name);
          TextView collectionName=findViewById(R.id.collection_name);
          TextView releaseDate=findViewById(R.id.release_date);
          artistName.setText(songBean.getArtistName());
          collectionName.setText(songBean.getCollectionName());
          trackName.setText(songBean.getTrackName());
          trackPrice.setText(songBean.getTrackPrice()+"$");
          //1983-12-02T08:00:00Z
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Date date = null;
        try {
            date = sdf.parse(songBean.getReleaseDate());
            String displayDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
            System.out.println("Time: " + date);
            releaseDate.setText(displayDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }


     /*   Glide.with(this)
                .load(songBean.getPreviewUrl())
                .centerCrop()
                .thumbnail(0.2f)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .skipMemoryCache(false)
                .placeholder(R.drawable.ic_launcher_background)
                .into(musicThumbnail);*/
       /* // musicThumbnail.setImageBitmap(retriveVideoFrameFromVideo(songBean.getPreviewUrl()));
            String filePath=songBean.getPreviewUrl();
        // MICRO_KIND: 96 x 96 thumbnail

        musicThumbnail.setImageBitmap(ThumbnailUtils.createVideoThumbnail(filePath,
                MediaStore.Video.Thumbnails.MINI_KIND));*/

        // MINI_KIND: 512 x 384 thumbnail
     /*   bmThumbnail = ThumbnailUtils.createVideoThumbnail(filePath,
                Thumbnails.MINI_KIND);*/

/*        Bitmap bitmap = null;
        try {
            bitmap = retriveVideoFrameFromVideo(songBean.getPreviewUrl());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        if (bitmap != null) {
            bitmap = Bitmap.createScaledBitmap(bitmap, 240, 240, false);
            musicThumbnail.setImageBitmap(bitmap);
        }*/

        SuziLoader loader = new SuziLoader(); //Create it for once
        loader.with(SongDetailActivity.this) //Context
                .load(songBean.getPreviewUrl()) //Video path
                .into(musicThumbnail) // imageview to load the thumbnail
                .type("mini") // mini or micro
                .show(); // to show the thumbnail
        /*try {
            musicThumbnail.setImageBitmap(retriveVideoFrameFromVideo(songBean.getPreviewUrl()));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }*/
    }

    public static Bitmap retriveVideoFrameFromVideo1(String videoPath)
    {
        Bitmap bitmap = null;
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try
        {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            if (Build.VERSION.SDK_INT >= 14)
                mediaMetadataRetriever.setDataSource(videoPath, new HashMap<String, String>());
            else
                mediaMetadataRetriever.setDataSource(videoPath);
            //   mediaMetadataRetriever.setDataSource(videoPath);
            bitmap = mediaMetadataRetriever.getFrameAtTime();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in retriveVideoFrameFromVideo(String videoPath)" + e.getMessage());

        } finally {
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
        }
        return bitmap;
    }
    public static Bitmap retriveVideoFrameFromVideo(String videoPath)
            throws Throwable {
        Bitmap bitmap = null;
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            if (Build.VERSION.SDK_INT >= 14)
                mediaMetadataRetriever.setDataSource(videoPath, new HashMap<String, String>());
            else
                mediaMetadataRetriever.setDataSource(videoPath);

            bitmap = mediaMetadataRetriever.getFrameAtTime(1, MediaMetadataRetriever.OPTION_CLOSEST);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Throwable(
                    "Exception in retriveVideoFrameFromVideo(String videoPath)"
                            + e.getMessage());

        } finally {
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
        }
        return bitmap;
    }
}
