package com.example.mynote.repository

import com.example.mynote.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class NoteRepository {
    // In‑memory store for simplicity; replace with Room or DataStore in production
    private val notes = MutableStateFlow<List<Note>>(emptyList())

    fun getNotes(): Flow<List<Note>> = notes

    suspend fun addNote(note: Note) {
        notes.update { current -> current + note }
    }

    suspend fun deleteNote(noteId: String) {
        notes.update { current -> current.filterNot { it.id == noteId } }
    }
}
