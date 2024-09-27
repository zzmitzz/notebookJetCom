package com.example.statejetpackcompose.domain.model

import androidx.compose.ui.graphics.Color
import java.util.Date

data class Note(
    val id: Int? = null,
    val title: String? = null,
    val noteContent: String? = null,
    val timeCreated: Date? = null,
    val isFavourite: Boolean = false,
    val isDeleted: Boolean = false,
    val lastModify: Date? = null,
    val category: CATEGORY? = null,
    val priority: Int = 1
)

enum class CATEGORY(val title: String){
    FAVOURITE("Favourite"),
    TODO_LIST("To-do list"),
    IDEAS("Ideas"),
    TASK("Task"),
    QUOTES("Quotes")
}