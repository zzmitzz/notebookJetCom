package com.example.statejetpackcompose.presentation.ui

import com.example.statejetpackcompose.domain.model.CATEGORY
import com.example.statejetpackcompose.domain.model.Note
import java.util.Date

object Utils {

    fun generateSampleNotes(): List<Note> {
        return listOf(
            Note(
                id = 1,
                title = "Weekend To-Do List",
                noteContent = "1. Clean the house\n2. Buy groceries\n3. Call mom",
                timeCreated = Date(),
                isFavourite = false,
                isDeleted = false,
                lastModify = Date(),
                category = CATEGORY.TODO_LIST,
                priority = 1
            ),
            Note(
                id = 2,
                title = "Favorite Quote",
                noteContent = "The only limit to our realization of tomorrow is our doubts of today. – Franklin D. Roosevelt",
                timeCreated = Date(),
                isFavourite = true,
                isDeleted = false,
                lastModify = Date(),
                category = CATEGORY.QUOTES,
                priority = 2
            ),
            Note(
                id = 3,
                title = "App Idea",
                noteContent = "Develop a mindfulness app that sends hourly positive reminders.",
                timeCreated = Date(),
                isFavourite = true,
                isDeleted = false,
                lastModify = Date(),
                category = CATEGORY.IDEAS,
                priority = 3
            ),
            Note(
                id = 4,
                title = "Work Task",
                noteContent = "Complete the Q4 project plan by Friday.",
                timeCreated = Date(),
                isFavourite = false,
                isDeleted = false,
                lastModify = Date(),
                category = CATEGORY.TASK,
                priority = 1
            ),
            Note(
                id = 5,
                title = "Daily Motivation",
                noteContent = "Don’t watch the clock; do what it does. Keep going.",
                timeCreated = Date(),
                isFavourite = true,
                isDeleted = false,
                lastModify = Date(),
                category = CATEGORY.QUOTES,
                priority = 2
            ),
            Note(
                id = 6,
                title = "Tech Idea",
                noteContent = "Create a browser extension to help track daily productivity.",
                timeCreated = Date(),
                isFavourite = false,
                isDeleted = false,
                lastModify = Date(),
                category = CATEGORY.IDEAS,
                priority = 3
            ),
            Note(
                id = 7,
                title = "Important Task",
                noteContent = "Prepare tax documents for submission next week.",
                timeCreated = Date(),
                isFavourite = false,
                isDeleted = false,
                lastModify = Date(),
                category = CATEGORY.TASK,
                priority = 1
            ),
            Note(
                id = 8,
                title = "Travel Checklist",
                noteContent = "1. Passport\n2. Tickets\n3. Hotel reservation\n4. Clothes",
                timeCreated = Date(),
                isFavourite = false,
                isDeleted = false,
                lastModify = Date(),
                category = CATEGORY.TODO_LIST,
                priority = 2
            ),
            Note(
                id = 9,
                title = "Startup Idea",
                noteContent = "An AI-powered personal finance advisor that helps users invest intelligently.",
                timeCreated = Date(),
                isFavourite = true,
                isDeleted = false,
                lastModify = Date(),
                category = CATEGORY.IDEAS,
                priority = 3
            ),
            Note(
                id = 10,
                title = "To-Do: Fix Bugs",
                noteContent = "1. Fix login issue\n2. Optimize loading time on main screen",
                timeCreated = Date(),
                isFavourite = false,
                isDeleted = false,
                lastModify = Date(),
                category = CATEGORY.TASK,
                priority = 1
            )
        )
    }

}