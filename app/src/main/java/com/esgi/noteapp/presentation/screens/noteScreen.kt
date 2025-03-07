package com.esgi.noteapp.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.esgi.noteapp.presentation.NoteViewModel
import com.esgi.noteapp.presentation.components.AddNoteButton
import com.esgi.noteapp.presentation.components.AddNotePopup
import com.esgi.noteapp.presentation.components.LoadAllNotesScreen
import com.esgi.noteapp.presentation.components.TopAppBarNote
import com.esgi.noteapp.presentation.components.UpdateNotePopup
import com.esgi.noteapp.theme.Pink40

@Composable
fun NoteScreen(
    modifier: Modifier = Modifier,
    noteViewModel: NoteViewModel = hiltViewModel()
) {
    val notes by noteViewModel.notes.collectAsState()
    noteViewModel.loadAllNotes()

    var isAddNotePopupVisible by remember { mutableStateOf(false) }
    var isUpdateNotePopupVisible by remember { mutableStateOf(false) }
    var updateNoteIndex by remember { mutableStateOf(-1) }

    if (isAddNotePopupVisible) {
        AddNotePopup(
            onDismissClick = { isAddNotePopupVisible = false },
            onConfirmClick = { note ->
                // Save Note on Database
                noteViewModel.insertNote(note)
                isAddNotePopupVisible = false
            }
        )
    }

    if (isUpdateNotePopupVisible) {
        UpdateNotePopup(
            note = notes[updateNoteIndex],
            onDismissClick = { isUpdateNotePopupVisible = false },
            onConfirmClick = { note ->
                // Save Edit Note on Database
                noteViewModel.updateNote(note)
                isUpdateNotePopupVisible = false
            }
        )
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Pink40,
        topBar = {
            TopAppBarNote { noteViewModel.deleteAllNotes() }
        },
        floatingActionButton = {
            AddNoteButton{ isAddNotePopupVisible = true }
        }
    ) { innerPadding ->

        if (notes.isEmpty()) {
            EmptyScreen(modifier = modifier.padding(innerPadding))
        } else {
            LoadAllNotesScreen(
                innerPadding,
                notes,
                onClickDelete = {
                    noteViewModel.deleteNote(notes[updateNoteIndex])
                },
                onClickEdit = { noteIndex ->
                    updateNoteIndex = noteIndex
                    isUpdateNotePopupVisible = true
                }
            )
        }
    }
}

@Preview
@Composable
private fun NoteScreenPreview() {
    NoteScreen()
}