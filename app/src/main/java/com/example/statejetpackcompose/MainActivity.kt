package com.example.statejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.statejetpackcompose.presentation.theme.StateJetpackComposeTheme
import com.example.statejetpackcompose.presentation.ui.homescreen.HomeScreenStateful
import com.example.statejetpackcompose.presentation.ui.homescreen.components.HomeScreenStateless

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            StateJetpackComposeTheme {
                Surface(modifier = Modifier.fillMaxSize().systemBarsPadding() ) {
                    HomeScreenStateful()
                }
            }
        }
    }
}

