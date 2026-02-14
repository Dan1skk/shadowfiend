package com.example.shadowfiend.feature_app.presintation.menu

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.shadowfiend.R // Твои ресурсы
import com.example.shadowfiend.feature_app.Routes // Твои роуты
import com.example.shadowfiend.feature_app.presintation.ui.theme.AppColors

@Composable
fun MenuScreen(navController: NavController) {
    // 1. Логика отслеживания текущего экрана для меню
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .statusBarsPadding()
    ) {
        // --- ШАПКА ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Добро пожаловать!", color = Color.Gray, fontSize = 12.sp)
                Text("Алексей", color = AppColors.DarkBlue, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
            Row {
                Icon(painterResource(id = R.drawable.cart), null, Modifier.size(24.dp))
                Spacer(Modifier.width(16.dp))
                Icon(painterResource(id = R.drawable.profile), null, Modifier.size(24.dp))
            }
        }

        // --- ТЕМНЫЙ КОНТЕНТ ---
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(Color(0xFF2D3237))
        ) {
            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                Text(
                    "Выберите Ваш кофе",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 24.dp)
                )

                // СЕТКА С КОФЕ
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    items(6) { index -> // 6 карточек для примера
                        Card(
                            shape = RoundedCornerShape(20.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(12.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.coffee_cup),
                                    contentDescription = null,
                                    modifier = Modifier.size(80.dp)
                                )
                                Text("Кофе", fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 8.dp))
                                Text("100₽", fontSize = 12.sp, color = Color.Gray, modifier = Modifier.align(Alignment.End))
                            }
                        }
                    }
                }

                // --- НИЖНЕЕ МЕНЮ (ВСЁ ВНУТРИ) ---
                Surface(
                    modifier = Modifier
                        .padding(bottom = 24.dp, top = 8.dp)
                        .fillMaxWidth()
                        .height(72.dp),
                    shape = RoundedCornerShape(24.dp),
                    color = Color.White
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Кнопка 1 (Магазин)
                        val isMenu = currentRoute == Routes.Menu.route // Сверяем роут
                        IconButton(onClick = { navController.navigate(Routes.Menu.route) }) {
                            Icon(
                                painter = painterResource(id = R.drawable.shop),
                                contentDescription = null,
                                // ПОДСВЕТКА: если активно - черный, нет - серый
                                tint = if (isMenu) Color(0xFF2D3237) else Color.LightGray,
                                modifier = Modifier.size(if (isMenu) 28.dp else 24.dp)
                            )
                        }

                        // Кнопка 2 (Подарки)
                        val isGift = currentRoute == "Gifts"
                        IconButton(onClick = { /* навигируй куда надо */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.gift),
                                contentDescription = null,
                                tint = if (isGift) Color(0xFF2D3237) else Color.LightGray,
                                modifier = Modifier.size(if (isGift) 28.dp else 24.dp)
                            )
                        }

                        // Кнопка 3 (Профиль/Список)
                        val isList = currentRoute == "List"
                        IconButton(onClick = { /* навигируй куда надо */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.list),
                                contentDescription = null,
                                tint = if (isList) Color(0xFF2D3237) else Color.LightGray,
                                modifier = Modifier.size(if (isList) 28.dp else 24.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}