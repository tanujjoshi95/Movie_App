package com.example.test.Widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.test.Model.Movie
import com.example.test.Model.getMovies
@Preview
@Composable
fun MovieRow(movie: Movie= getMovies()[0],
             onClick:(String)  -> Unit={} ){
    var expand by remember {
        mutableStateOf(false
        )
    }
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable {
                onClick(movie.id)
            },
          //  .height(130.dp), because we need variable height
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                shadowElevation = 4.dp
            ) {
                Image(painter = rememberAsyncImagePainter(model = movie.image[0]), contentDescription =null )
//                Image(imageVector = Icons.Default.AccountBox, contentDescription ="null" )
            }
        Column(modifier = Modifier.padding(4.dp)) {
            Text(text = movie.title,
                style = MaterialTheme.typography.headlineSmall)
            Text(text = "Director : ${movie.directors}",
                style = MaterialTheme.typography.bodyMedium)
            Text(text = "Released : ${movie.year}",
                style = MaterialTheme.typography.bodyMedium)
            AnimatedVisibility(visible = expand) {
                Column {
                    Text(text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.DarkGray,
                            fontSize = 13.sp)){
                            append("Plot: ")
                        }
                        withStyle(style = SpanStyle(color = Color.DarkGray,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold)){
                            append(movie.plot)
                        }
                    }, modifier = Modifier.padding(6.dp))
                    Divider()
                    Text(text = "Director: ${movie.directors}", style = MaterialTheme.typography.bodyMedium )
                    Text(text = "Actors: ${movie.actors}", style = MaterialTheme.typography.bodyMedium )
                    Text(text = "Rating: ${movie.rating}", style = MaterialTheme.typography.bodyMedium )
                }

            }

            Icon(
                imageVector = if (expand) Icons.Filled.KeyboardArrowUp
                else Icons.Filled.KeyboardArrowDown,
                contentDescription ="arrow",
                modifier = Modifier
                    .size(25.dp)
                    .clickable {
                        expand = !expand
                    },
                tint = Color.DarkGray
            )
            }
        }

    }

}
