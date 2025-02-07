package com.esgi.noteapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO {
    @Query("SELECT * FROM notes")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Insert
    suspend fun insertNote(noteEntity: NoteEntity)

    @Update
    suspend fun updateNote(noteEntity: NoteEntity)

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)

    @Query("DELETE FROM notes")
    suspend fun deleteAllNotes()
}