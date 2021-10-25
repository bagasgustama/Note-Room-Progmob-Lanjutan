package id.bagas.noteroom.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteRoomDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();

    private static volatile id.bagas.noteroom.database.NoteRoomDatabase INSTANCE;

    public static id.bagas.noteroom.database.NoteRoomDatabase getDataBase(final Context context){
        if (INSTANCE == null){
            synchronized (id.bagas.noteroom.database.NoteRoomDatabase.class){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        id.bagas.noteroom.database.NoteRoomDatabase.class, "note_database").build();
            }
        }
        return INSTANCE;
    }
}
