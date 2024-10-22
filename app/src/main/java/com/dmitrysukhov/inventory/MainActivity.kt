package com.dmitrysukhov.inventory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MyApp() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = currentRoute ?: "") },
            navigationIcon = {
                if (navController.previousBackStackEntry != null) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            },
            colors = topAppBarColors(containerColor = Color.Green)
        )
    }, floatingActionButton = {
        if (currentRoute == INVENTORY_SCREEN)
            Button({ navController.navigate(ADD_ITEM_SCREEN) }) {
                Icon(painter = painterResource(R.drawable.add), contentDescription = null)
            }
    })
    { padding ->
        NavHost(
            navController = navController, startDestination = INVENTORY_SCREEN,
            modifier = Modifier.padding(padding)
        ) {
            composable(INVENTORY_SCREEN) { InventoryScreen() }
            composable(ADD_ITEM_SCREEN) { AddItemScreen() }
            composable(EDIT_ITEM_SCREEN) { EditItemScreen() }
            composable(ITEM_DETAILS_SCREEN) { ItemDetailsScreen() }
        }
    }
}