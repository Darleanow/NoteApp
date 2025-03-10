package com.esgi.noteapp.data.repository

import com.esgi.noteapp.data.dao.NoteDao
import com.esgi.noteapp.data.entity.toNote
import com.esgi.noteapp.domain.model.Note
import com.esgi.noteapp.domain.model.toNoteEntity
import com.esgi.noteapp.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor (private val noteDao: NoteDao) : NoteRepository {

    override fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes().map { notesEntityList ->
            notesEntityList.map { noteEntity -> noteEntity.toNote() }
        }
    }

    suspend override fun insertNote(note: Note) {
        noteDao.insert(note.toNoteEntity())
    }

    suspend override fun updateNote(note: Note) {
        noteDao.update(note.toNoteEntity())
    }

    suspend override fun deleteNote(note: Note) {
        noteDao.delete(note.toNoteEntity())
    }

    suspend override fun deleteAllNotes() {
        noteDao.deleteAllNotes()
    }
}