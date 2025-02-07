package com.esgi.noteapp.domain

import com.esgi.noteapp.data.NoteEntity

data class Note(
    val id: Int = 0,
    val title: String,
    val content: String,
)

fun Note.toNoteEntity(): NoteEntity {
    return NoteEntity(
        id = id,
        title = title,
        content = content
    )
}