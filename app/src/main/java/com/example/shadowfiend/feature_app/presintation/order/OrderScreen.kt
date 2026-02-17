package com.example.shadowfiend.feature_app.presintation.order

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Цветовая палитра
val DarkBlue = Color(0xFF1D2E3D)
val CoffeeGreen = Color(0xFF147D34)
val LightGray = Color(0xFFF5F5F5)
val SubtitleGray = Color(0xFF8E8E93)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeOrderScreen() {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Заказ",
                        modifier = Modifier.fillMaxWidth().padding(end = 48.dp),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = "Корзина")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            // 1. Прокручиваемая область (настройки кофе)
            Column(
                modifier = Modifier
                    .weight(1f) // Занимает всё доступное место, вытесняя кнопку вниз
                    .verticalScroll(scrollState)
            ) {
                // Картинка товара
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .background(LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    // Здесь предполагается изображение кофе
                    Text("☕", fontSize = 100.sp)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Название и счетчик
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Капучино", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = DarkBlue)
                    QuantityPicker()
                }

                HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp), thickness = 0.5.dp, color = Color.LightGray)

                // Ристретто
                OptionRow("Ристретто") {
                    SegmentedControl(listOf("Один", "Два"), selectedIndex = 0)
                }

                // На месте / На вынос
                OptionRow("На месте / навынос") {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(painterResource(id = android.R.drawable.ic_menu_edit), contentDescription = null, tint = Color.LightGray, modifier = Modifier.size(28.dp))
                        Spacer(modifier = Modifier.width(20.dp))
                        Icon(painterResource(id = android.R.drawable.ic_menu_send), contentDescription = null, tint = DarkBlue, modifier = Modifier.size(28.dp))
                    }
                }

                // Объем
                OptionRow("Объем, мл") {
                    Row(verticalAlignment = Alignment.Bottom) {
                        VolumeItem("250", isSelected = false, scale = 0.7f)
                        VolumeItem("350", isSelected = true, scale = 0.85f)
                        VolumeItem("450", isSelected = false, scale = 1.0f)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Время
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Приготовить к\nопределенному времени\nсегодня?",
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        color = DarkBlue
                    )
                    Column(horizontalAlignment = Alignment.End) {
                        Switch(
                            checked = true,
                            onCheckedChange = {},
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = CoffeeGreen,
                                uncheckedBorderColor = Color.LightGray
                            )
                        )
                        Surface(
                            color = LightGray,
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.padding(top = 8.dp)
                        ) {
                            Text(
                                "18 : 10",
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Кнопка конструктора
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = CoffeeGreen),
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    Icon(Icons.Default.Settings, contentDescription = null, modifier = Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text("Конструктор кофемана", modifier = Modifier.weight(1f), fontSize = 15.sp)
                    Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null)
                }

                // Отступ в конце скролла, чтобы контент не перекрывался ценой
                Spacer(modifier = Modifier.height(32.dp))
            }

            // 2. Фиксированная нижняя панель
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Итоговая сумма", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = DarkBlue)
                    Text("250₽", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = DarkBlue)
                }

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = DarkBlue),
                    shape = RoundedCornerShape(28.dp)
                ) {
                    Text("Далее", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun OptionRow(label: String, content: @Composable () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = DarkBlue)
        content()
    }
}

@Composable
fun QuantityPicker() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .border(1.dp, Color(0xFFE5E5E5), RoundedCornerShape(20.dp))
            .padding(horizontal = 4.dp, vertical = 4.dp)
    ) {
        IconButton(onClick = {}, modifier = Modifier.size(32.dp)) { Text("-", fontSize = 20.sp) }
        Text("1", modifier = Modifier.padding(horizontal = 12.dp), fontWeight = FontWeight.Bold, fontSize = 16.sp)
        IconButton(onClick = {}, modifier = Modifier.size(32.dp)) { Text("+", fontSize = 20.sp) }
    }
}

@Composable
fun SegmentedControl(options: List<String>, selectedIndex: Int) {
    Row {
        options.forEachIndexed { index, text ->
            val isSelected = index == selectedIndex
            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .border(1.dp, if (isSelected) DarkBlue else Color(0xFFE5E5E5), RoundedCornerShape(20.dp))
                    .clickable { },
                color = Color.Transparent
            ) {
                Text(
                    text,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
                    color = if (isSelected) DarkBlue else SubtitleGray,
                    fontSize = 14.sp,
                    fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal
                )
            }
            if (index < options.size - 1) Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun VolumeItem(label: String, isSelected: Boolean, scale: Float) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {
        Icon(
            painter = painterResource(id = android.R.drawable.ic_menu_send), // Заглушка иконки стакана
            contentDescription = null,
            modifier = Modifier.size((40 * scale).dp),
            tint = if (isSelected) DarkBlue else Color.LightGray
        )
        Text(
            label,
            fontSize = 12.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) DarkBlue else SubtitleGray
        )
    }
}