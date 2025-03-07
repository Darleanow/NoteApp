package com.esgi.noteapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.esgi.noteapp.domain.model.Note

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "titleNote")
    var title: String,

    @ColumnInfo(name = "contentNote")
    var content: String
)

fun NoteEntity.toNote() : Note{
    return Note(
        id = this.id,
        title = this.title,
        content = this.content
    )
}


