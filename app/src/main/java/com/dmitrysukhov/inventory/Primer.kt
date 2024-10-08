package com.dmitrysukhov.inventory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

data class Mebel(
    var title: String,
    var type: String,
    var isInStock: Boolean,
    var size: String,
    var material: String,
    var price: Long
)

//Одежда - Тима
//книги - Сава
//игрушки - Марк

@Composable
fun PrimerScreen() {
    Column(Modifier.fillMaxSize()) {
        val mebelList = ArrayList<Mebel>()
        mebelList.add(
            Mebel(
                type = "Стол",
                isInStock = false,
                material = "Ольха",
                size = "200x100x70",
                price = 2000,
                title = "Стол офисный"
            )
        )
        mebelList.add(Mebel("Стул", "Офисная мебель", true, "45x45x90", "Пластик", 1500))
        mebelList.add(Mebel("Стол", "Офисная мебель", true, "120x60x75", "Дерево", 5000))
        mebelList.add(Mebel("Кресло", "Гостиная мебель", true, "80x80x90", "Ткань", 3000))
        mebelList.add(Mebel("Диван", "Гостиная мебель", true, "200x90x85", "Кожа", 15000))
        mebelList.add(Mebel("Тумба", "Спальная мебель", true, "60x40x50", "Дерево", 2000))
        mebelList.add(Mebel("Кровать", "Спальная мебель", true, "160x200x40", "Дерево", 12000))
        mebelList.add(Mebel("Стеллаж", "Книжная мебель", false, "80x30x180", "Дерево", 4000))
        mebelList.add(Mebel("Обеденный стол", "Кухонная мебель", true, "150x90x75", "Дерево", 8000))
        mebelList.add(Mebel("Барный стул", "Кухонная мебель", true, "45x45x110", "Металл", 2000))
        mebelList.add(Mebel("Пуф", "Гостиная мебель", false, "50x50x40", "Ткань", 1500))
        mebelList.add(Mebel("Комод", "Спальная мебель", true, "80x45x90", "Дерево", 6000))
        mebelList.add(Mebel("Кофейный столик", "Гостиная мебель", true, "60x60x45", "Стекло", 3500))
        mebelList.add(Mebel("Шкаф", "Спальная мебель", true, "120x60x200", "Дерево", 10000))
        mebelList.add(Mebel("Офисный стол", "Офисная мебель", true, "140x70x75", "Дерево", 7000))
        mebelList.add(Mebel("Тахта", "Гостиная мебель", false, "180x80x85", "Ткань", 8000))
        mebelList.add(Mebel("Кушетка", "Гостиная мебель", true, "160x80x70", "Ткань", 5000))
        mebelList.add(Mebel("Тумбочка", "Спальная мебель", false, "50x40x50", "Дерево", 1500))
        mebelList.add(Mebel("Шкаф-купе", "Спальная мебель", true, "200x60x240", "Дерево", 15000))
        mebelList.add(Mebel("Письменный стол", "Офисная мебель", true, "140x70x75", "Дерево", 8000))
        mebelList.add(Mebel("Кресло-качалка", "Гостиная мебель", true, "70x90x100", "Дерево", 4000))
        mebelList.add(Mebel("Гардероб", "Спальная мебель", true, "100x50x200", "Дерево", 9000))
        mebelList.add(Mebel("Скамейка", "Гардеробная мебель", false, "120x40x45", "Дерево", 3000))
        mebelList.add(Mebel("Книжный шкаф", "Книжная мебель", true, "80x30x180", "Дерево", 5000))
        mebelList.add(Mebel("Письменный стол", "Офисная мебель", true, "140x70x75", "Дерево", 8000))
        mebelList.add(Mebel("Кресло-качалка", "Гостиная мебель", true, "70x90x100", "Дерево", 4000))
        mebelList.add(Mebel("Гардероб", "Спальная мебель", true, "100x50x200", "Дерево", 9000))
        mebelList.add(Mebel("Скамейка", "Гардеробная мебель", false, "120x40x45", "Дерево", 3000))
        mebelList.add(Mebel("Книжный шкаф", "Книжная мебель", true, "80x30x180", "Дерево", 5000))
        mebelList.add(Mebel("Письменный стол", "Офисная мебель", true, "140x70x75", "Дерево", 8000))
        mebelList.add(Mebel("Кресло-качалка", "Гостиная мебель", true, "70x90x100", "Дерево", 4000))
        mebelList.add(Mebel("Гардероб", "Спальная мебель", true, "100x50x200", "Дерево", 9000))
        mebelList.add(Mebel("Письменный стол", "Офисная мебель", true, "140x70x75", "Дерево", 8000))
        mebelList.add(Mebel("Кресло-качалка", "Гостиная мебель", true, "70x90x100", "Дерево", 4000))
        mebelList.add(Mebel("Гардероб", "Спальная мебель", true, "100x50x200", "Дерево", 9000))
        mebelList.add(Mebel("Скамейка", "Гардеробная мебель", false, "120x40x45", "Дерево", 3000))
        mebelList.add(Mebel("Книжный шкаф", "Книжная мебель", true, "80x30x180", "Дерево", 5000))
        mebelList.add(Mebel("Письменный стол", "Офисная мебель", true, "140x70x75", "Дерево", 8000))
        mebelList.add(Mebel("Кресло-качалка", "Гостиная мебель", true, "70x90x100", "Дерево", 4000))
        mebelList.add(Mebel("Гардероб", "Спальная мебель", true, "100x50x200", "Дерево", 9000))
        mebelList.add(Mebel("Скамейка", "Гардеробная мебель", false, "120x40x45", "Дерево", 3000))
        mebelList.add(Mebel("Книжный шкаф", "Книжная мебель", true, "80x30x180", "Дерево", 5000))
        mebelList.add(Mebel("Письменный стол", "Офисная мебель", true, "140x70x75", "Дерево", 8000))
        mebelList.add(Mebel("Кресло-качалка", "Гостиная мебель", true, "70x90x100", "Дерево", 4000))
        mebelList.add(Mebel("Гардероб", "Спальная мебель", true, "100x50x200", "Дерево", 9000))
        mebelList.add(Mebel("Скамейка", "Гардеробная мебель", false, "120x40x45", "Дерево", 3000))
        mebelList.add(Mebel("Книжный шкаф", "Книжная мебель", true, "80x30x180", "Дерево", 5000))
        mebelList.add(Mebel("Письменный стол", "Офисная мебель", true, "140x70x75", "Дерево", 8000))
        mebelList.add(Mebel("Кресло-качалка", "Гостиная мебель", true, "70x90x100", "Дерево", 4000))
        mebelList.add(Mebel("Гардероб", "Спальная мебель", true, "100x50x200", "Дерево", 9000))
        mebelList.add(Mebel("Скамейка", "Гардеробная мебель", false, "120x40x45", "Дерево", 3000))
        mebelList.add(Mebel("Книжный шкаф", "Книжная мебель", true, "80x30x180", "Дерево", 5000))
        mebelList.add(Mebel("Скамейка", "Гардеробная мебель", false, "120x40x45", "Дерево", 3000))
        mebelList.add(Mebel("Книжный шкаф", "Книжная мебель", true, "80x30x180", "Дерево", 5000))
        mebelList.add(Mebel("Письменный стол", "Офисная мебель", true, "140x70x75", "Дерево", 8000))
        mebelList.add(Mebel("Кресло-качалка", "Гостиная мебель", true, "70x90x100", "Дерево", 4000))
        mebelList.add(Mebel("Гардероб", "Спальная мебель", true, "100x50x200", "Дерево", 9000))
        mebelList.add(Mebel("Скамейка", "Гардеробная мебель", false, "120x40x45", "Дерево", 3000))
        mebelList.add(Mebel("Книжный шкаф", "Книжная мебель", true, "80x30x180", "Дерево", 5000))

        mebelList.add(Mebel("Письменный стол", "Офисная мебель", true, "140x70x75", "Дерево", 8000))
        mebelList.add(Mebel("Кресло-качалка", "Гостиная мебель", true, "70x90x100", "Дерево", 4000))
        mebelList.add(Mebel("Гардероб", "Спальная мебель", true, "100x50x200", "Дерево", 9000))
        mebelList.add(Mebel("Скамейка", "Гардеробная мебель", false, "120x40x45", "Дерево", 3000))
        mebelList.add(Mebel("Книжный шкаф", "Книжная мебель", true, "80x30x180", "Дерево", 5000))
        mebelList.add(
            Mebel(
                "Тумба под телевизор",
                "Гостиная мебель",
                true,
                "150x45x50",
                "Дерево",
                4500
            )
        )
        mebelList.add(
            Mebel(
                "Столик для туалета",
                "Спальная мебель",
                false,
                "80x40x70",
                "Дерево",
                3500
            )
        )
        mebelList.add(
            Mebel(
                "Столик с ящиками",
                "Гостиная мебель",
                false,
                "80x50x75",
                "Дерево",
                4000
            )
        )
        mebelList.add(Mebel("Шезлонг", "Гардеробная мебель", true, "60x180x30", "Ткань", 6000))
        mebelList.add(Mebel("Детский стол", "Детская мебель", true, "90x60x50", "Пластик", 2500))
        mebelList.add(Mebel("Парта", "Детская мебель", true, "100x50x50", "Дерево", 3500))


        LazyColumn {
            item {
                Text("dfvlkdvfldfvk", fontSize = 50.sp)
            }
            items(mebelList) {
                Text(it.title + " " + it.material + " " + it.price, fontSize = 24.sp)
            }
        }
    }
}

val PRIMER_SCREEN = "primer screen"