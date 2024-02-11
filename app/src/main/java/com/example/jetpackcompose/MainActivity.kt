package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxExample3()
        }
    }
}

@Preview
@Composable
fun BoxExample1(){
    Box(
        modifier = Modifier
            .background(color = Color.Green)
            .size(180.dp, 300.dp)
    ){
        Box(modifier = Modifier
            .background(color = Color.Yellow)
            .size(125.dp, 100.dp)
            .align(Alignment.TopEnd)
        ){

        }

        Text(text = "Hi",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .background(color = Color.White)
                .size(90.dp, 50.dp)
                .align(Alignment.BottomCenter),
            textAlign = TextAlign.Center

            )
    }
}
@Preview
@Composable
fun BoxExample2(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
    ) {
        Text(text = "Top Start",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(10.dp)
                .align(Alignment.TopStart)
        )

        Text(text = "Top Center",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(10.dp)
                .align(Alignment.TopCenter)
        )

        Text(text = "Top End",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(10.dp)
                .align(Alignment.TopEnd)
        )

        Text(text = "Center Start",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(10.dp)
                .align(Alignment.CenterStart)
        )

        Text(text = "Center",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(10.dp)
                .align(Alignment.Center)
        )

        Text(text = "Center End",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(10.dp)
                .align(Alignment.CenterEnd)
        )

        Text(text = "Bottom Start",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(10.dp)
                .align(Alignment.BottomStart)
        )

        Text(text = "Bottom Center",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(10.dp)
                .align(Alignment.BottomCenter)
        )
        Text(text = "Bottom End",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .background(color = Color.Yellow)
                .padding(10.dp)
                .align(Alignment.BottomEnd)
        )

    }

}

@Composable
fun BoxExample3(){

    Box(modifier = Modifier
        .background(color = Color.White)){
        Image(painter = painterResource(id = R.drawable.beach_resort),
            contentDescription ="beach_resort",
        )
        Text(text = "Beach Resort",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.BottomStart)
        )
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.textButtonColors(
                contentColor = Color.DarkGray
            ),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
                .border(
                    5.dp, Color.DarkGray,
                    shape = RectangleShape
                )
        ) {
            Text(text = "Add to Cart")
        }
    }

}