package com.ynov.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ynov.noteapp.data.dao.NoteDao
import com.ynov.noteapp.data.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
}