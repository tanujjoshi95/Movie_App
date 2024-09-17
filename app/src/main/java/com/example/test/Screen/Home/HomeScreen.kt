package com.example.test.Screen.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.test.Model.Movie
import com.example.test.Model.getMovies
import com.example.test.Navigation.MovieScreens
import com.example.test.Widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController:NavController){
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Movies")
            },
                colors = topAppBarColors(
                    containerColor = Color.Transparent
                )
//                ,
//                modifier = Modifier.shadow(
//                    elevation = 5.dp
//                )
            )
        },)
    {
        it
        MainContent(navController=navController)
    }

}
@Composable
fun MainContent(navController: NavController,
                movieList:List<Movie> = getMovies()
                ) {
    Column(modifier = Modifier.padding(12.dp, top = 70.dp)) {
        LazyColumn {
            items(items = movieList)
            {
                MovieRow(movie = it) { movie ->
                   navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")               
                }

            }

        }
    }
}