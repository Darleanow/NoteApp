package com.esgi.noteapp.domain.useCase

import com.esgi.noteapp.domain.model.Note
import com.esgi.noteapp.domain.repository.NoteRepository
import javax.inject.Inject

class InsertUseCase @Inject constructor(
    private val noteRepository: NoteRepository

) {
    suspend operator fun invoke(note: Note) {
        noteRepository.insertNote(note)
    }

}