package com.esgi.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.esgi.noteapp.data.dao.NoteDao
import com.esgi.noteapp.data.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
}