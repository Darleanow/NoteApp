package com.esgi.noteapp.domain.repository

import com.esgi.noteapp.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getAllNotes(): Flow<List<Note>>
    suspend fun insertNote(note: Note)
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(note: Note)
    suspend fun deleteAllNotes()
}