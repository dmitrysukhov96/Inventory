package com.dmitrysukhov.inventory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InventoryScreen() {
    Column(
        Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Row {
            Text(
                "ITEM", Modifier
                    .weight(2F)
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp)
            )
            Text(
                "PRICE", Modifier
                    .weight(1F)
                    .align(Alignment.CenterVertically), textAlign = TextAlign.Center
            )
            Text(
                "QUANTITY IN STOCK", Modifier
                    .weight(1F)
                    .align(Alignment.CenterVertically), textAlign = TextAlign.Center
            )
        }
        Spacer(Modifier.height(8.dp))
        HorizontalDivider()
        LazyColumn {
            items(0) {

            }
        }
    }
}

@Composable
fun AddItemScreen() {
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
fun EditItemScreen() {

}

@Composable
fun ItemDetailsScreen() {

}

const val INVENTORY_SCREEN = "Inventory"
const val ADD_ITEM_SCREEN = "Add Item"
const val EDIT_ITEM_SCREEN = "Edit Item"
const val ITEM_DETAILS_SCREEN = "Item Details"

@Preview(showSystemUi = true)
@Composable
fun PreviewInv() {
    InventoryScreen()
}