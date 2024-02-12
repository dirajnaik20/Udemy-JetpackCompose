package com.example.jetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                DisplaySnackBar()
            }

        }
    }
}

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DisplaySnackBar() {


//    Scaffold(
//        snackbarHost = {
//            SnackbarHost(hostState = snackBarHostState)
//        },
//        floatingActionButton = {
//            ExtendedFloatingActionButton(
//                text = { Text("Show snackBar") },
//                icon = { Icon(Icons.Filled.Close, contentDescription = "") },
//                onClick = {
//                    scope.launch {
//                        snackBarHostState.showSnackbar("Snackbar")
//                    }
//                }
//            )
//        }
//    ) {
//
//    }

    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        }
    ) {

        Button(onClick = {
            scope.launch {
                val snackBarResult = snackBarHostState.showSnackbar(
                    message = "This the snackBar",
                    actionLabel = "Undo",
                    duration = SnackbarDuration.Short
                )
                when (snackBarResult) {
                    SnackbarResult.ActionPerformed -> Log.i(
                        "MYTAG",
                        "Action Performed"
                    )

                    SnackbarResult.Dismissed -> Log.i(
                        "MYTAG",
                        "Dismissed"
                    )
                }
            }
        }) {
            Text(text = "Display SnackBar")
        }
    }

}
