package com.esgi.noteapp.data

import com.esgi.noteapp.domain.Note
import com.esgi.noteapp.domain.NoteRepository
import com.esgi.noteapp.domain.toNoteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(
    private val noteDAO: NoteDAO
) : NoteRepository {
    override fun getAllNotes(): Flow<List<Note>> {
        return noteDAO.getAllNotes().map { noteEntityList ->
            noteEntityList.map { note -> note.toNote() }
        }
    }

    override suspend fun insertNote(note: Note) {
        noteDAO.insertNote(note.toNoteEntity())
    }

    override suspend fun updateNote(note: Note) {
        noteDAO.updateNote(note.toNoteEntity())
    }

    override suspend fun deleteNote(note: Note) {
        noteDAO.deleteNote(note.toNoteEntity())
    }

    override suspend fun deleteAllNotes() {
        noteDAO.deleteAllNotes()
    }

}