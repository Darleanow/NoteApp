package com.esgi.noteapp.di

import android.content.Context
import androidx.room.Room
import com.esgi.noteapp.data.NoteDatabase
import com.esgi.noteapp.data.dao.NoteDao
import com.esgi.noteapp.data.repository.NoteRepositoryImpl
import com.esgi.noteapp.domain.repository.NoteRepository
import com.esgi.noteapp.domain.useCase.DeleteAllNotesUseCase
import com.esgi.noteapp.domain.useCase.DeleteNoteUseCase
import com.esgi.noteapp.domain.useCase.GetAllNotesUseCase
import com.esgi.noteapp.domain.useCase.InsertUseCase
import com.esgi.noteapp.domain.useCase.NoteUseCase
import com.esgi.noteapp.domain.useCase.UpdateNoteUseCase
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