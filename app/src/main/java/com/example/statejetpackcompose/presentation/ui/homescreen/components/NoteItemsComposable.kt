package com.example.statejetpackcompose.presentation.ui.homescreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.statejetpackcompose.domain.model.Note
import com.example.statejetpackcompose.presentation.theme.NoteColor1
import com.example.statejetpackcompose.presentation.theme.NoteColor2
import com.example.statejetpackcompose.presentation.theme.NoteColor3
import com.example.statejetpackcompose.presentation.theme.NoteColor4
import com.example.statejetpackcompose.presentation.theme.NoteColor5
import com.example.statejetpackcompose.presentation.theme.NoteColor6
import com.example.statejetpackcompose.presentation.theme.NoteColor7

@Composable
fun NoteItemComposable(note: Note) {
    val colorList: List<androidx.compose.ui.graphics.Color> = listOf(
        NoteColor1,
        NoteColor2,
        NoteColor3,
        NoteColor4,
        NoteColor5,
        NoteColor6,
        NoteColor7
    )
    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        colors = CardDefaults.cardColors(containerColor = colorList.random()),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = note.category?.title ?: "Ideas",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = note.title ?: "E-commerce idea",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = note.noteContent ?: "Personalizes the shopping experience with AI suggestions, seamless navigation, and a one-tap...",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier =
                        Modifier
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(16.dp),
                            )
                            .padding(4.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favorite",
                            modifier = Modifier.size(20.dp),
                            tint = Color.Gray,
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = note.lastModify.toString(),
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray,
                        )
                    }
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End,
            ) {
                Column {
                    IconButton(onClick = { /* Handle favorite action */ }) {
                        Box(
                            modifier =
                                Modifier
                                    .background(Color.White)
                                    .shadow(
                                        shape = CircleShape,
                                        elevation = 0.dp,
                                    ).padding(8.dp),
                        ) {
                            Icon(
                                modifier = Modifier.size(16.dp),
                                imageVector = Icons.Default.Favorite,
                                contentDescription = "Favorite",
                                tint = Color.Gray,
                            )
                        }
                    }
                    IconButton(onClick = { /* Handle delete action */ }) {
                        Box(
                            modifier =
                                Modifier
                                    .background(Color.White)
                                    .shadow(
                                        shape = CircleShape,
                                        elevation = 0.dp,
                                    ).padding(8.dp),
                        ) {
                            Icon(
                                modifier = Modifier.size(16.dp),
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete",
                                tint = Color.Gray,
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier =
                    Modifier
                        .clip(CircleShape)
                        .background(Color(0xFF9575CD))
                        .align(Alignment.CenterVertically)
                        .size(32.dp),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Arrow",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    NoteItemComposable(Note())
}
