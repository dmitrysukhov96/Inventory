package com.dmitrysukhov.inventory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InventoryApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventoryApp() {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Привет") },
            colors = topAppBarColors(containerColor = Color.Green)
        )
    })
    { padding ->
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = ADD_ITEM_SCREEN, //todo поменять на инвентори
            modifier = Modifier.padding(padding)
        ) {
            composable(INVENTORY_SCREEN) { InventoryScreen(navController) }
            composable(ADD_ITEM_SCREEN) { AddItemScreen(navController) }
            composable(EDIT_ITEM_SCREEN) { EditItemScreen(navController) }
            composable(ITEM_DETAILS_SCREEN) { ItemDetailsScreen(navController) }
        }
    }
}

@Composable
fun InventoryScreen(navController: NavHostController) {

}

@Composable
fun AddItemScreen(navController: NavHostController) {
    var name by rememberSaveable { mutableStateOf("") }
    var surname by rememberSaveable { mutableStateOf("") }
    var result by rememberSaveable { mutableStateOf("") }
    Column {
        TextField(value = name, onValueChange = { name = it })
        TextField(value = surname, onValueChange = { surname = it })
        Button(onClick = { result = "$name $surname" }) {
            Text(text = "Анука что там будет")
        }
        Text(text = result, fontSize = 50.sp)
    }
}

@Composable
fun EditItemScreen(navController: NavHostController) {

}

@Composable
fun ItemDetailsScreen(navController: NavHostController) {

}

const val INVENTORY_SCREEN = "Inventory"
const val ADD_ITEM_SCREEN = "Add Item"
const val EDIT_ITEM_SCREEN = "Edit Item"
const val ITEM_DETAILS_SCREEN = "Item Details"



const val TEST_SCREEN = "test_screen"
const val SCREEN_HOUSE = "screen_house"
const val SCREEN_WALK = "screen_walk"
const val SCREEN_HOME = "screen_home"
const val SCREEN_ATB = "screen_atb"

@Composable
fun ScreenHouse(navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Мы в помещении", fontSize = 50.sp)
        Button(onClick = { navController.navigate(SCREEN_WALK) }) {
            Text(text = "Идем гулять!!")
        }
        Button(onClick = { navController.navigate(SCREEN_HOME) }) {
            Text(text = "Нет, идем домой")
        }
    }
}

@Composable
fun ScreenWalk(navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Мы пришли на Балковскую", fontSize = 50.sp)
        Button(onClick = { navController.navigate(SCREEN_HOME) }) {
            Text(text = "Идем дальше")
        }
        Button(onClick = { navController.navigate(SCREEN_HOME) }) {
            Text(text = "Едем на маршрутке домой")
        }
        Button(onClick = { navController.navigate(SCREEN_ATB) }) {
            Text(text = "Идем в АТБ!!!!")
        }
    }
}

@Composable
fun ScreenHome(navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Ура, мы добрались домой", fontSize = 50.sp)
        Button(onClick = { navController.popBackStack(SCREEN_HOUSE, false) }) {
            Text(text = "Начать приключение сначала)")
        }
    }
}

@Composable
fun ScreenAtb(navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "УУ тут вкусняшки", fontSize = 50.sp)
        Button(onClick = { navController.navigateUp() }) {
            Text(text = "Выходим из АТБ")
        }
    }
}

@Composable
fun TestScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .background(Color(0xFF9CC27E)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "View Meeting",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFFFFFFF)
            )
        }
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(start = 20.dp, top = 22.dp, end = 20.dp)
        ) {
            Text(text = "Design review meeting", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Meeting Status:", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(17.dp))
            Text(text = "Pending", fontSize = 16.sp, fontWeight = W500)
            Spacer(modifier = Modifier.height(33.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Time:", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(14.dp))
            Row {
                Text(text = "30 Mar 2024", fontSize = 16.sp, fontWeight = W500)
                Spacer(modifier = Modifier.weight(1F))
                Text(text = "15:00 - 16:00", fontSize = 16.sp, fontWeight = W500)
            }
            Spacer(modifier = Modifier.height(10.5.dp))
            Text(text = "Timezone Kyiv, UTC+3", fontSize = 16.sp, color = Color(0xFFA9A9A9))
            Spacer(modifier = Modifier.height(24.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Place:", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    text = "Online", fontSize = 16.sp, fontWeight = W500,
                    modifier = Modifier.weight(1F)
                )
                Text(
                    text = "Discord Room 1", fontSize = 16.sp, fontWeight = W500,
                    modifier = Modifier.weight(1F)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Link:", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .height(37.dp)
                    .fillMaxWidth()
                    .background(Color(0xFFEEF0F3))
                    .padding(start = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "www.discord.com/tre/meetroom1",
                    fontSize = 16.sp,
                    color = Color(0xFF6C9E45),
                    textDecoration = TextDecoration.Underline
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Description:", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Pellentesque ornare cursus nibh in pulvinar. Praesent at nibh a nunc vehicula volutpat a non mauris. Praesent eleifend malesuada nunc, non gravida ligula euismod id. Morbi bibendum ipsum id commodo consequat. Nullatpat dolor.",
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(24.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Project:", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Youth Android App", fontSize = 16.sp, fontWeight = W500)
            Spacer(modifier = Modifier.height(24.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Scheduled by:", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Vasia Pupkin", fontSize = 16.sp, fontWeight = W500)
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}










