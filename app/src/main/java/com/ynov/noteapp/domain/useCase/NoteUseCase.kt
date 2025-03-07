package com.ynov.noteapp.domain.useCase

import javax.inject.Inject

data class NoteUseCase @Inject constructor(
    val getAllNotesUseCase: GetAllNotesUseCase,
    val insertUseCase: InsertUseCase,
    val updateNoteUseCase: UpdateNoteUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val deleteAllNotesUseCase: DeleteAllNotesUseCase
)