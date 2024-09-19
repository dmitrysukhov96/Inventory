package com.dmitrysukhov.inventory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun KubikScreen() {
    Column(Modifier.fillMaxSize()) {
        Button({
        }) {
            Text("Бросить кубик")
        }
//        val kartinka by rememberSaveable { mutableStateOf(R.drawable.img_1) }
        val result by rememberSaveable { mutableStateOf("") }
//        Image(painter = painterResource(kartinka), contentDescription = null)
        Text(result)
    }
}

@Composable
fun FonScreen() {
    val kolir by rememberSaveable { mutableLongStateOf(0xFFFFFFFF) }
    Column(
        modifier = Modifier
            .background(Color(kolir))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button({

        }, modifier = Modifier.offset(x=22.dp, y=56.dp)) {
            Text("")
        }

        Text("fldlfkvklfdfd")
        Text("fldlfkvklfdfd")
        Text("fldlfkvklfdfd")
        Text("fldlfkvklfdfd")
        Text("fldlfkvklfdfd")
    }
}

val FON_SCREEN = "fon screen"


@Preview(showSystemUi = true,
    device = "spec:id=reference_phone,shape=Normal,width=411,height=891,unit=dp,dpi=420"
)
@Composable
fun Preview() {
    FonScreen()
}