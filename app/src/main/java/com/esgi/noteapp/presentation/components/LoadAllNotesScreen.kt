package com.esgi.noteapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.esgi.noteapp.domain.model.Note

@Composable
fun LoadAllNotesScreen(
    innerPadding: PaddingValues,
    notes: List<Note>,
    onClickDelete: () -> Unit = {},
    onClickEdit: (Int) -> Unit = {}
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(innerPadding),
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(notes.size) { noteIndex ->
            NoteCardItem(
                note = notes[noteIndex],
                onClickDelete = { onClickDelete() },
                onClickEdit = {onClickEdit(noteIndex)}
            )
        }
    }
}