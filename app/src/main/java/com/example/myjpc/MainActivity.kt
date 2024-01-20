package com.example.myjpc

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {

    private var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Greeting()
        }
    }
}

@Composable
fun Greeting() {

    var counter by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(key1 = counter) {
        Log.i("Greeting", "Hello $counter!")
    }

    Log.i("Greeting", "Recompose $counter!")
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Button(onClick = { counter++ }) {
                Text(text = "Hello $counter!")
            }
            Button(onClick = {
                if (counter % 5 == 0) {
                    counter--
                }
            }) {
                Text(text = "Hello 2.. $counter!")
            }
        }

    }
}