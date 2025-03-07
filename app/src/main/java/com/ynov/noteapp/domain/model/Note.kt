package com.ynov.noteapp.domain.model

import com.ynov.noteapp.data.entity.NoteEntity

data class Note(
    val id: Int = 0,
    val title: String,
    val content: String,
)

fun Note.toNoteEntity() : NoteEntity {
    return NoteEntity(
        id = this.id,
        title = this.title,
        content = this.content
    )
}
