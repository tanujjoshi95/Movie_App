package com.example.test.Screen.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.test.Model.Movie
import com.example.test.Model.getMovies
import com.example.test.Widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    navController: NavController,
    movieId:String?){
    val newMovieList= getMovies().filter { movie->
        movie.id==movieId
    }
    Scaffold(topBar = {
        TopAppBar(title = {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription ="null",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    }
                )
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = "Movies")
            }

    },
        colors = topAppBarColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier.shadow(
            elevation = 3.dp
        )
    )}) {
        it
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(90.dp))
            MovieRow(movie = newMovieList.first())
            Spacer(modifier = Modifier.height(10.dp))
            Divider()
            Text(text = "Movie Images", style = MaterialTheme.typography.headlineSmall)
            horizontalImageView(newMovieList = newMovieList)

            //Text(text = movieId.toString(), style = MaterialTheme.typography.bodyLarge)

        }

    }

    }

}
@Composable
fun horizontalImageView(newMovieList:List<Movie>){
    LazyRow {
        items(newMovieList[0].image){
                image->
            Card(modifier = Modifier
                .padding(12.dp)
                //.fillMaxWidth()
               .width(240.dp)
                .height(140.dp)
//                .background(
//                color = Color.Transparent),
                    ,
                elevation =CardDefaults.cardElevation(defaultElevation = 4.dp)) {
                Image(painter = rememberAsyncImagePainter(model = image),
                    contentDescription = "image", modifier = Modifier.align(Alignment.CenterHorizontally)
//                    contentScale = ContentScale.Fit,modifier = Modifier
//                        .fillMaxWidth()
            )
            }
        }

    }
}
