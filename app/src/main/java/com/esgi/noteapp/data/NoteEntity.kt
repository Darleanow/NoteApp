package com.esgi.noteapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.esgi.noteapp.domain.Note

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,

    @ColumnInfo(name = "title") val title: String,

    @ColumnInfo(name = "content") val content: String
)

fun NoteEntity.toNote(): Note {
    return Note(
        id = id, title = title, content = content
    )
}
