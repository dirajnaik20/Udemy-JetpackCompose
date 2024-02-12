package com.example.jetpackcompose

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composerecyclerview.model.TvShow
import java.io.Serializable


class InfoActivity : ComponentActivity() {

    companion object {
        private const val TvShowId = "tvshowid"

        fun intent(context: Context, tvShow: TvShow) =
            Intent(context, InfoActivity::class.java).apply {
                putExtra(TvShowId, tvShow)
            }

        inline fun <reified T : Serializable> Intent.serializable(key: String): T? = when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getSerializableExtra(key, T::class.java)
            else -> @Suppress("DEPRECATION") getSerializableExtra(key) as? T
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tvShow = intent.serializable<TvShow>(TvShowId)
        setContent {

            tvShow?.let { ViewMoreInfo(tvShow = it) }
        }
    }
}



@Composable
fun ViewMoreInfo(tvShow: TvShow) {

    val scrollState = rememberScrollState()

    ElevatedCard(
        modifier = Modifier
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(
            corner = CornerSize(
                10.dp
            )
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .verticalScroll(scrollState)
        ) {
            Image(
                painter = painterResource(id = tvShow.imageId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(corner = CornerSize(4.dp))),
                contentScale = ContentScale.Crop
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            Text(
                text = tvShow.name,
                style = MaterialTheme.typography.displayMedium
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            Text(
                text = tvShow.overview,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            Text(
                text = "Original Release: ${tvShow.year}",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            Text(
                text = "IMDB: ${tvShow.year}",
                style = MaterialTheme.typography.headlineMedium
            )
        }

    }

}
