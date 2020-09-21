package com.example.madlevel5task1.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.madlevel5task1.DAO.NoteDao
import com.example.madlevel5task1.Database.NotepadRoomDatabase
import com.example.madlevel5task1.Model.Note

class NoteRepository(context: Context) {

    private val noteDao: NoteDao

    init {
        val database = NotepadRoomDatabase.getDatabase(context)
        noteDao = database!!.noteDao()
    }

    fun getNotepad(): LiveData<Note?> {
        return noteDao.getNotepad()
    }

    suspend fun updateNotepad(note: Note) {
        noteDao.updateNote(note)
    }

}
