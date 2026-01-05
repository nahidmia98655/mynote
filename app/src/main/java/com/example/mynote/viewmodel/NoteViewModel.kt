package com.example.mynote.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynote.model.Note
import com.example.mynote.repository.NoteRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NoteViewModel(private val repository: NoteRepository = NoteRepository()) : ViewModel() {
    val notes: StateFlow<List<Note>> = repository.getNotes()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    var noteTitle = mutableStateOf("")
    var noteContent = mutableStateOf("")

    fun addNote() {
        val title = noteTitle.value.trim()
        val content = noteContent.value.trim()
        if (title.isNotEmpty() || content.isNotEmpty()) {
            val newNote = Note(title = title, content = content)
            viewModelScope.launch {
                repository.addNote(newNote)
            }
            noteTitle.value = ""
            noteContent.value = ""
        }
    }

    fun deleteNote(noteId: String) {
        viewModelScope.launch {
            repository.deleteNote(noteId)
        }
    }
}
