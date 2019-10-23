package com.example.funmusic.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SongsDao {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insert(Songs note);

        @Update
        void update(Songs note);

        @Delete
        void delete(Songs note);

        @Query("DELETE FROM songs_history_table")
        void deleteAllNotes();

        @Query("SELECT * FROM songs_history_table")
        LiveData<List<Songs>> getAllNotes();
    }

