package com.example.statejetpackcompose.presentation.ui.detailscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.statejetpackcompose.domain.model.CATEGORY
import com.example.statejetpackcompose.domain.model.Note
import com.example.statejetpackcompose.presentation.theme.DarkGrey10
import java.util.Date

@Composable
fun HomeScreenStateless(modifier: Modifier) {
    val listCategory: MutableList<String> = mutableListOf()
    CATEGORY.entries.forEach{
        listCategory.add(it.title)
    }
    listCategory.add(0,"All")
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
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(){
            items(listCategory.size){
                val category = listCategory[it]
                Box(modifier = Modifier
                    .clip(
                        shape = RoundedCornerShape(4.dp)
                    )
                    .background(DarkGrey10)
                    .padding(8.dp)){
                    Text(text = category )
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        val generateList = generateSampleNotes()
        LazyColumn {
            items(generateList.size){
                val notes = generateList[it]
                NoteItemComposable(note = notes)
            }
        }
    }
    FloatingActionButton(onClick = { }, modifier = Modifier.) {
        Icon(imageVector = Icons.Default.Add)
    }
}

// Function to generate a list of 10 notes
fun generateSampleNotes(): List<Note> {
    val notes = mutableListOf<Note>()

    for (i in 1..10) {
        notes.add(
            Note(
                id = i,
                title = "Note Title $i",
                noteContent = "This is the content of note number $i.",
                timeCreated = null,
                isFavourite = i % 2 == 0, // Make every second note a favorite
                isDeleted = false,
                lastModify = Date(),
                category = CATEGORY.entries.toTypedArray().random(), // Randomly assign a category
                priority = (1..5).random() // Random priority between 1 and 5
            )
        )
    }

    return notes
}
@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    HomeScreenStateless(modifier = Modifier)
}
