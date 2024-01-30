package com.kamilagcabay.movieappcleanarchitecture.Presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kamilagcabay.movieappcleanarchitecture.Presentation.Screen
import com.kamilagcabay.movieappcleanarchitecture.Presentation.movie_detail.views.MovieDetailScreen
import com.kamilagcabay.movieappcleanarchitecture.Presentation.movies.views.MovieScreen
import com.kamilagcabay.movieappcleanarchitecture.Util.Constants.IMDB_ID
import com.kamilagcabay.movieappcleanarchitecture.ui.theme.MovieAppCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppCleanArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.MovieScreen.route) {
                        composable(route = Screen.MovieScreen.route) {
                            MovieScreen(navController = navController)
                        }

                        composable(route = Screen.MovieDetailScreen.route + "/{${IMDB_ID}}") {
                            MovieDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
