package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<MyViewModel>()

            val count = viewModel.count

            MyButton(count) { viewModel.updateCount() }

        }
    }
}

//val count = mutableIntStateOf(0);


@Composable

fun MyButton(counter: Int, updateCount: (Int) -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = {

                updateCount(counter)

            },
            shape = RectangleShape,
            contentPadding = PaddingValues(16.dp),
            border = BorderStroke(10.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(Color.Gray)
        ) {

            Text(
                "Count: $counter",
                modifier = Modifier
                    .padding(5.dp),
                style = MaterialTheme.typography.displaySmall,
                color = Color.White
            )
        }

    }


}
