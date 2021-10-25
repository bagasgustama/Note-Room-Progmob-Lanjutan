package id.bagas.noteroom.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import id.bagas.noteroom.database.Note;
import id.bagas.noteroom.database.NoteDao;
import id.bagas.noteroom.database.NoteRoomDatabase;

public class NoteRepository {
    private final NoteDao mNoteDao;
    private final ExecutorService executorService;

    public NoteRepository(Application application) {
        executorService = Executors.newSingleThreadExecutor();
        NoteRoomDatabase db = NoteRoomDatabase.getDataBase(application);
        mNoteDao = db.noteDao();

    }

    public LiveData<List<Note>> getAllNotes(){
        return mNoteDao.getAllNotes();
    }

    public void insert(final Note note){
        executorService.execute(() -> mNoteDao.insert(note));
    }

    public void delete(final Note note){
        executorService.execute(() -> mNoteDao.delete(note));
    }

    public void update(final Note note){
        executorService.execute(() -> mNoteDao.update(note));
    }
}
