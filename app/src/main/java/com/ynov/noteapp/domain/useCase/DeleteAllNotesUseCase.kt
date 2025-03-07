package com.ynov.noteapp.domain.useCase

import com.ynov.noteapp.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteAllNotesUseCase @Inject constructor (
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke() {
        noteRepository.deleteAllNotes()
    }
}