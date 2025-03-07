package com.ynov.noteapp.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun AddNoteButton(
    onClickAddNote: () -> Unit
) {

    FloatingActionButton(
        onClick = { onClickAddNote() },
        containerColor = FloatingActionButtonDefaults.containerColor,
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = ""
        )
    }
}