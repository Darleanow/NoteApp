package com.esgi.noteapp.domain.useCase

import com.esgi.noteapp.domain.model.Note
import com.esgi.noteapp.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    operator fun invoke(): Flow<List<Note>> {
        return noteRepository.getAllNotes()
    }
}