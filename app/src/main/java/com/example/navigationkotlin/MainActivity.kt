package com.example.navigationkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationkotlin.ui.theme.NavigationKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationKotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
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
    NavHost(navController = navController, startDestination = "FirstScreen"
    ){
        composable("FirstScreen"){
            FirstScreen {name->
                navController.navigate("SecondScreen/$name")
            }
        }
        composable("SecondScreen/{name}"){
            val name = it.arguments?.getString("name") ?: "no name"
            SecondScreen(name) {
                navController.navigate("ThirdScreen")
            }
        }
        composable("ThirdScreen"){
            ThirdScreen {
                navController.navigate("FirstScreen")
            }
        }
    }
}


