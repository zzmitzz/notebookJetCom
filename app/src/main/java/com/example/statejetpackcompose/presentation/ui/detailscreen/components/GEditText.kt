package com.example.statejetpackcompose.presentation.ui.detailscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GEditText(
    text: String = null ?: "Your note goes here",
    onTextChange: (String) -> Unit,
    modifier: Modifier
){
    TextField(
        value = text,
        onValueChange = {
            onTextChange(it)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Transparent,      // Set the border color when focused
            unfocusedBorderColor = Color.Transparent     // Set the border color when not focused
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.Transparent),
        singleLine = true
    )
}