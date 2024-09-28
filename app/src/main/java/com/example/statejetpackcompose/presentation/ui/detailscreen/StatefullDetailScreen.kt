package com.example.statejetpackcompose.presentation.ui.detailscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.statejetpackcompose.presentation.ui.detailscreen.components.StatelessDetailScreen


@Composable
fun StatefulDetailScreen (){
    var currentEditTextContent by remember { mutableStateOf("") }

    StatelessDetailScreen(
        currentEditTextContent,
        onValueTextChange = {newtext -> currentEditTextContent = newtext}
    )


}

@Preview(showBackground = true)
@Composable
fun PreviewState(){
    StatefulDetailScreen()
}