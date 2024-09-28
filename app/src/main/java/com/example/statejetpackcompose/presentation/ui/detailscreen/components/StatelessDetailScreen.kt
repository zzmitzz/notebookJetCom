package com.example.statejetpackcompose.presentation.ui.detailscreen.components

import android.widget.EditText
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun StatelessDetailScreen(
    currentText: String,
    onValueTextChange: (String) -> Unit,
) {

    Box(modifier = Modifier.padding(top = 16.dp, start = 8.dp, end = 8.dp)){
        Column(
            modifier = Modifier.fillMaxSize()
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = ""
                )
                Box(){
                    Row {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = Icons.Default.Share,
                            contentDescription = ""
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = Icons.Default.Done,
                            contentDescription = ""
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Random Note Title", fontSize = 26.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(8.dp))
            Spacer(modifier = Modifier.height(12.dp))
            Divider()
            Row(
                modifier = Modifier.padding(vertical = 20.dp)
            ) {
                Icon(imageVector = Icons.Default.AddCircle, contentDescription = "",
                    modifier = Modifier.align(Alignment.CenterVertically))
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Add Category",
                    fontSize = 24.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(12.dp))
            }
            Divider()
            GEditText(
                text = currentText,
                onTextChange = onValueTextChange,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

