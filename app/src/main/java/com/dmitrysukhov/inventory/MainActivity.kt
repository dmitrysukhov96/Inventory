package com.dmitrysukhov.inventory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { InventoryApp() }
    }


}

@Composable
fun InventoryApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "inventory") {
        composable("inventory") { InventoryScreen(navController) }
        composable("item") { ItemScreen(navController) }
        composable("details") { DetailsScreen() }
    }
}

@Composable
fun InventoryScreen(navController: NavHostController) {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Inventory Screen")
        Button(onClick = { navController.navigate("item") }) {
            Text("go to Item screen")
        }
        Button(onClick = { navController.navigate("details") }) {
            Text("go to details screen")
        }
    }
}

@Composable
fun ItemScreen(navController: NavHostController) {
    Column(Modifier.fillMaxSize()) {
        Button(onClick = { navController.navigate("details") }) {
            Text("go to details screen")
        }
    }
}

@Composable
fun DetailsScreen() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Details Screen")
    }
}