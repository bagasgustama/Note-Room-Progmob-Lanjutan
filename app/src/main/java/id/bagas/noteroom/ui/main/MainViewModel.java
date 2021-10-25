package id.bagas.noteroom.ui.main;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import id.bagas.noteroom.database.Note;
import id.bagas.noteroom.repository.NoteRepository;

public class MainViewModel extends ViewModel {
    private final NoteRepository mNoteRepository;

    public MainViewModel(Application application){
        mNoteRepository = new NoteRepository(application);
    }

    LiveData<List<Note>> getAllNotes() {
        return mNoteRepository.getAllNotes();
    }

}
