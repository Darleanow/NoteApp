package com.ynov.noteapp.domain.useCase

import com.ynov.noteapp.domain.model.Note
import com.ynov.noteapp.domain.repository.NoteRepository
import javax.inject.Inject

class InsertUseCase @Inject constructor(
    private val noteRepository: NoteRepository

) {
    suspend operator fun invoke(note: Note) {
        noteRepository.insertNote(note)
    }

}