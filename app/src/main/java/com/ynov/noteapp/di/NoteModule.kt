package com.ynov.noteapp.di

import android.content.Context
import androidx.room.Room
import com.ynov.noteapp.data.NoteDatabase
import com.ynov.noteapp.data.dao.NoteDao
import com.ynov.noteapp.data.repository.NoteRepositoryImpl
import com.ynov.noteapp.domain.repository.NoteRepository
import com.ynov.noteapp.domain.useCase.DeleteAllNotesUseCase
import com.ynov.noteapp.domain.useCase.DeleteNoteUseCase
import com.ynov.noteapp.domain.useCase.GetAllNotesUseCase
import com.ynov.noteapp.domain.useCase.InsertUseCase
import com.ynov.noteapp.domain.useCase.NoteUseCase
import com.ynov.noteapp.domain.useCase.UpdateNoteUseCase
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
    fun provideNoteDatabase( @ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            "notedb")
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(noteDatabase: NoteDatabase) =
        noteDatabase.noteDao()

    @Provides
    @Singleton
    fun provideNoteRepository(noteDao: NoteDao) : NoteRepository{
        return NoteRepositoryImpl(noteDao)
    }

    @Provides
    @Singleton
    fun provideGetAllNotesUseCase(noteRepository: NoteRepository) : GetAllNotesUseCase {
        return GetAllNotesUseCase(noteRepository)
    }

    @Provides
    @Singleton
    fun provideInsertUseCase(noteRepository: NoteRepository) : InsertUseCase {
        return InsertUseCase(noteRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateNoteUseCase(noteRepository: NoteRepository) : UpdateNoteUseCase {
        return UpdateNoteUseCase(noteRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteNoteUseCase(noteRepository: NoteRepository) : DeleteNoteUseCase {
        return DeleteNoteUseCase(noteRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteAllNotesUseCase(noteRepository: NoteRepository) : DeleteAllNotesUseCase {
        return DeleteAllNotesUseCase(noteRepository)
    }

    @Provides
    @Singleton
    fun provideNoteUseCase(
        getAllNotesUseCase: GetAllNotesUseCase,
        insertUseCase: InsertUseCase,
        updateNoteUseCase: UpdateNoteUseCase,
        deleteNoteUseCase: DeleteNoteUseCase,
        deleteAllNotesUseCase: DeleteAllNotesUseCase
    ) : NoteUseCase {

        return NoteUseCase(
            getAllNotesUseCase,
            insertUseCase,
            updateNoteUseCase,
            deleteNoteUseCase,
            deleteAllNotesUseCase
        )

    }

}