package com.esgi.noteapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esgi.noteapp.domain.model.Note
import com.esgi.noteapp.domain.useCase.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor (
    private val noteUseCase: NoteUseCase
) : ViewModel() {

    private val _notes : MutableStateFlow<List<Note>> = MutableStateFlow(emptyList())
    val notes : StateFlow<List<Note>> = _notes

    fun loadAllNotes() = viewModelScope.launch(Dispatchers.IO) {
        noteUseCase.getAllNotesUseCase().collectLatest { notes ->
            _notes.value = notes
        }
    }

    fun insertNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        noteUseCase.insertUseCase(note)
        loadAllNotes()
    }
    fun updateNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        noteUseCase.updateNoteUseCase(note)
        loadAllNotes()
    }

    fun deleteNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        noteUseCase.deleteNoteUseCase(note)
        loadAllNotes()
    }

    fun deleteAllNotes() = viewModelScope.launch(Dispatchers.IO) {
        noteUseCase.deleteAllNotesUseCase()
        loadAllNotes()
    }

}