package com.example.funmusic.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class SongsRepositry {
    private SongsDao songsDao;
    private LiveData<List<Songs>> allSongs;

    public SongsRepositry(Application application) {
        SongDataBase database = SongDataBase.getInstance(application);
        songsDao = database.noteDao();
        allSongs = songsDao.getAllNotes();
    }

    public void insert(Songs note) {
        new InsertNoteAsyncTask(songsDao).execute(note);
    }


    private static class InsertNoteAsyncTask extends AsyncTask<Songs, Void, Void> {
        private SongsDao songsDao;

        private InsertNoteAsyncTask(SongsDao noteDao) {
            this.songsDao = noteDao;
        }

        @Override
        protected Void doInBackground(Songs... notes) {
            songsDao.insert(notes[0]);
            return null;
        }
    }
    public LiveData<List<Songs>> getAllSongs() {
        return allSongs;
    }
}
