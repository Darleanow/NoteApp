package com.esgi.noteapp.di

import android.content.Context
import androidx.room.Room
import com.esgi.noteapp.data.NoteDAO
import com.esgi.noteapp.data.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(
        @ApplicationContext context: Context
    ): NoteDatabase {
        return Room.databaseBuilder(
            context, NoteDatabase::class.java,
            "note-db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteDAO(noteDatabase: NoteDatabase): NoteDAO {
        return noteDatabase.noteDAO()
    }
}