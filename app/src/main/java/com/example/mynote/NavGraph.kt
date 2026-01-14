package com.example.mynote

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mynote.ui.notes.NoteEditScreen
import com.example.mynote.ui.notes.NoteListScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = "notes") {
        composable("notes") {
            val viewModel: com.example.mynote.viewmodel.NoteViewModel = hiltViewModel()
            NoteListScreen(
                viewModel = viewModel,
                onAddNote = { navController.navigate("edit") },
                onEditNote = { noteId -> navController.navigate("edit/$noteId") }
            )
        }
        composable("edit") {
            val viewModel: com.example.mynote.viewmodel.NoteViewModel = hiltViewModel()
            NoteEditScreen(
                viewModel = viewModel,
                noteId = null,
                onNavigateBack = { navController.popBackStack() }
            )
        }
        composable("edit/{noteId}") { backStackEntry ->
            val viewModel: com.example.mynote.viewmodel.NoteViewModel = hiltViewModel()
            val noteId = backStackEntry.arguments?.getString("noteId")?.toLongOrNull()
            NoteEditScreen(
                viewModel = viewModel,
                noteId = noteId,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}