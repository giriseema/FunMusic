package com.example.funmusic.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

    @Database(entities = {Songs.class}, version = 1)
    public abstract class SongDataBase extends RoomDatabase {

        private static SongDataBase instance;

        public abstract SongsDao noteDao();

        public static synchronized SongDataBase getInstance(Context context) {
            if (instance == null) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        SongDataBase.class, "songs_database")
                        .fallbackToDestructiveMigration()
                        .build();
            }
            return instance;
        }
    }

