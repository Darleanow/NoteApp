package com.esgi.noteapp.domain.useCase

import com.esgi.noteapp.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteAllNotesUseCase @Inject constructor (
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke() {
        noteRepository.deleteAllNotes()
    }
}