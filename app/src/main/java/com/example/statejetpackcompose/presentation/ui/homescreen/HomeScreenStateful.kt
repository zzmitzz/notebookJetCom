package com.example.statejetpackcompose.presentation.ui.homescreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.statejetpackcompose.domain.model.CATEGORY
import com.example.statejetpackcompose.domain.model.Note
import com.example.statejetpackcompose.presentation.ui.homescreen.components.HomeScreenStateless


@Composable
fun HomeScreenStateful(){
//    var listNote by remember { mutable("") }
    HomeScreenStateless(modifier = Modifier, onDateUpdate = {true}, onCategoryUpdate = { CATEGORY.TASK}, onFavouriteUpdate = {})
}