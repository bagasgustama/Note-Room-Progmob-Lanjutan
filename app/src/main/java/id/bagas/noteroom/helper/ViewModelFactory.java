package id.bagas.noteroom.helper;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import id.bagas.noteroom.ui.insert.NoteAddUpdateViewModel;
import id.bagas.noteroom.ui.main.MainViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile id.bagas.noteroom.helper.ViewModelFactory INSTANCE;
    private final Application mApplication;
    private ViewModelFactory(Application application) {
        mApplication = application;

    }

    public static id.bagas.noteroom.helper.ViewModelFactory getInstance(Application application){
        if(INSTANCE == null){
            synchronized (id.bagas.noteroom.helper.ViewModelFactory.class){
                INSTANCE = new id.bagas.noteroom.helper.ViewModelFactory(application);
            }
        }
        return INSTANCE;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(mApplication);

        } else if (modelClass.isAssignableFrom(NoteAddUpdateViewModel.class)) {
            return (T) new NoteAddUpdateViewModel(mApplication);

        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
