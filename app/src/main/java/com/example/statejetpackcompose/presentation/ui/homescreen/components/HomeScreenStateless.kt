package com.example.statejetpackcompose.presentation.ui.homescreen.components

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.statejetpackcompose.domain.model.CATEGORY
import com.example.statejetpackcompose.domain.model.Note
import com.example.statejetpackcompose.presentation.theme.DarkGrey10
import com.example.statejetpackcompose.presentation.theme.NoteColor1
import com.example.statejetpackcompose.presentation.theme.NoteColor2
import com.example.statejetpackcompose.presentation.theme.NoteColor3
import com.example.statejetpackcompose.presentation.theme.NoteColor4
import com.example.statejetpackcompose.presentation.theme.NoteColor5
import com.example.statejetpackcompose.presentation.theme.NoteColor6
import com.example.statejetpackcompose.presentation.theme.NoteColor7
import com.example.statejetpackcompose.presentation.ui.Utils

@Composable
fun HomeScreenStateless(
    modifier: Modifier,
    onDateUpdate: () -> Boolean, // Sort date chosen turn true,
    onCategoryUpdate: (CATEGORY) -> Unit,
    onFavouriteUpdate: () -> Unit

) {
    val listCategory: MutableList<String> = mutableListOf()

    CATEGORY.entries.forEach {
        listCategory.add(it.title)
    }
    listCategory.add(0, "All")
    Column(
        modifier =
        Modifier
            .padding(
                top = 16.dp,
                start = 8.dp,
                end = 8.dp,
            )
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "My Notes",
            fontSize = 24.sp,
            style =
            TextStyle(
                fontWeight = FontWeight.Bold,
            ),
        )
        Row(
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Sort By",
            )
            Spacer(modifier = Modifier)
            Row {
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = "Date",
                    style =
                    TextStyle(
                        fontWeight = FontWeight.Bold,
                    ),
                )
                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Divider()
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow() {
            items(listCategory.size) {
                val category = listCategory[it]
                Box(
                    modifier = Modifier
                        .clip(
                            shape = RoundedCornerShape(4.dp)
                        )
                        .background(DarkGrey10)
                        .padding(8.dp)
                ) {
                    Text(text = category)
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        val generateList = generateSampleNotes()
        LazyColumn {
            items(generateList.size) {
                val notes = generateList[it]
                NoteItemComposable(note = notes)
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        FloatingActionButton(
            onClick = { },
            modifier = Modifier.align(Alignment.BottomEnd),
            contentColor = contentColorFor(
                androidx.compose.ui.graphics.Color.Cyan
            )
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "")
        }
    }
}

// Function to generate a list of 10 notes
fun generateSampleNotes(): List<Note> = Utils.generateSampleNotes()

@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    HomeScreenStateless(modifier = Modifier, onDateUpdate = {true}, onCategoryUpdate = {CATEGORY.TASK}, onFavouriteUpdate = {})
}
