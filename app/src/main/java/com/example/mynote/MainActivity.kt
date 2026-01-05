package com.example.mynote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.mynote.ui.theme.AppTheme
import com.example.mynote.ui.NoteScreen
import com.example.mynote.viewmodel.NoteViewModel

class MainActivity : ComponentActivity() {
    private val noteViewModel: NoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                NoteScreen(viewModel = noteViewModel)
            }
        }
    }
}
