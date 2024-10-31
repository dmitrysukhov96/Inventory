package com.dmitrysukhov.inventory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
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
    var price by rememberSaveable { mutableStateOf("") }
    var quantity by rememberSaveable { mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp)) {
        TextField(name, { name = it }, modifier = Modifier.fillMaxWidth(), label = {
            Text("Item Name")
        })
        Spacer(Modifier.height(16.dp))
        TextField(
            value = price,
            onValueChange = { price = it },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            label = { Text("Item Price") }
        )
        Spacer(Modifier.height(16.dp))
        TextField(
            value = quantity,
            onValueChange = { quantity = it },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Quantity in Stock") }
        )
        Spacer(Modifier.height(32.dp))
        Button({}, modifier = Modifier.fillMaxWidth()) { Text("Save") }
    }
}

@Composable
fun ItemDetailsScreen() {
    Column(Modifier.padding(16.dp)) {
        Text("Asus Laptop", fontSize = 16.sp)
        Spacer(Modifier.height(16.dp))
        Text("$5,400.00", fontSize = 16.sp)
        Spacer(Modifier.height(16.dp))
        Text("Quantity in Stock: 30", fontSize = 16.sp)
        Spacer(Modifier.height(16.dp))
        Button({}, modifier = Modifier.fillMaxWidth()) { Text("Sell") }
        OutlinedButton({}, modifier = Modifier.fillMaxWidth()) { Text("Delete") }
    }
}

const val INVENTORY_SCREEN = "Inventory"
const val ADD_ITEM_SCREEN = "Add Item"
const val ITEM_DETAILS_SCREEN = "Item Details"

@Preview(showSystemUi = true)
@Composable
fun PreviewInv() {
    InventoryScreen()
}