package com.example.aulanova

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.aulanova.ui.theme.AulaNovaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AulaNovaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "home"
    ) {

        composable("home"
        ) {
            HomeScreen(onNavigateForm1 = {
                navController.navigate("form1"
                )
            }, onNavigateForm2 = {navController.navigate("form2/${it}")})
        }

        composable("form1"
        ) {
            Form1Screen(
                onBack = {navController.navigateUp()},
                onNavigateForm2 = {navController.navigate("form2/${it}")
                }
            )
        }

        composable("form2/{nome}",
            arguments = listOf(navArgument("nome") {type = NavType.StringType})
        ) {
            val param = it.arguments?.getString("nome")
            Form2Screen(param)
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!")
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AulaNovaTheme {
        MyApp()
    }
}