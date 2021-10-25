package id.bagas.noteroom.ui.insert;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import id.bagas.noteroom.database.Note;
import id.bagas.noteroom.repository.NoteRepository;

public class NoteAddUpdateViewModel extends ViewModel {
    private final NoteRepository mNoteRepository;

    public NoteAddUpdateViewModel(Application application){
        mNoteRepository = new NoteRepository(application);
    }

    public void insert(Note note){
        mNoteRepository.insert(note);
    }

    public void update(Note note){
        mNoteRepository.update(note);
    }

    public void delete(Note note){
        mNoteRepository.delete(note);
    }

}

