package com.example.statejetpackcompose.presentation.navigation


sealed class Screen(val route: String){
    object HomeScreen: Screen("main_screen")
    object DetailNoteScreen: Screen("note_screen")

}