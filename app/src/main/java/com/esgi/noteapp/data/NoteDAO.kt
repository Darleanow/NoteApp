package com.esgi.noteapp.data

import androidx.room.*

@Dao
interface NoteDAO {
    @Query("SELECT * FROM notes")
    fun getAllNotes(): List<Note>

    @Insert
    fun insertNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Query("DELETE FROM notes")
    fun deleteAllNotes()
}