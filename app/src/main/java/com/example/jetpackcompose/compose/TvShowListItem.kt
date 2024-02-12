package com.example.jetpackcompose.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.composerecyclerview.model.TvShow

@Composable
fun TvShowListItem(tvShow: TvShow, selectedItem: (TvShow) -> Unit) {

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        shape = RoundedCornerShape(corner = CornerSize(10.dp))

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
                .clickable { selectedItem(tvShow) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            TvShowImage(tvShow = tvShow)
            Column {
                Text(
                    text = tvShow.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(
                    modifier = Modifier
                        .height(4.dp)
                )
                Text(
                    text = tvShow.overview,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = tvShow.year.toString(),
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Text(
                        text = tvShow.rating.toString(),
                        style = MaterialTheme.typography.headlineSmall
                    )

                }
            }
        }

    }

}