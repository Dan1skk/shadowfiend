package com.example.shadowfiend.feature_app.presintation.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.shadowfiend.R
import com.example.shadowfiend.feature_app.Routes
import com.example.shadowfiend.feature_app.presintation.ui.theme.AppColors
import kotlinx.datetime.format.Padding

@Composable
fun MenuScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp, vertical = 27.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    Text(
                        "Добро пожаловать!",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color(0xFFA1A1A1),
                        )
                    )
                    Text(
                        "Алексей",
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Color(0xFF4F7993)
                        )
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = {}) {
                        Image(
                            painterResource(R.drawable.telega),
                            contentDescription = null,
                            modifier = Modifier.size(26.dp)
                        )
                    }
                    IconButton(onClick = {}) {
                        Image(
                            painterResource(R.drawable.profile),
                            contentDescription = null,
                            modifier = Modifier.size(26.dp)
                        )
                    }
                }
            }
        }

// green контейнер
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    AppColors.DarkBackground,
                    RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
                .padding(horizontal = 26.dp),
        ) {
            Text(
                "Выберите Ваш кофе",
                style = TextStyle(fontSize = 16.sp, color = Color.White),
                modifier = Modifier.padding(top = 16.dp)
            )

            Spacer(Modifier.size(30.dp))

            // ГЛАВНОЕ ИЗМЕНЕНИЕ: Добавляем weight(1f)
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .weight(1f) // Заполнит всё место, кроме бара
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(17.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                item { CustomBoxCard(navController,R.drawable.cofe1, "Капучино", "100p") }
                item { CustomBoxCard(navController,R.drawable.cofe2, "Американо", "100p") }
                item { CustomBoxCard(navController,R.drawable.cofe3, "Латте", "100p") }
                item { CustomBoxCard(navController,R.drawable.cofe4, "Флэт Уайт", "100p") }
                item { CustomBoxCard(navController,R.drawable.cofe5, "Раф", "100p") }
                item { CustomBoxCard(navController,R.drawable.cofe6, "Эспрессо", "100p") }
            }
            Spacer(Modifier.size(16.dp))

            // Теперь этот Box всегда будет в самом низу экрана
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 22.dp) // Отступ от самого края экрана
                    .background(Color.White, RoundedCornerShape(16.dp))
                    .height(64.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CustomIconButton(navController, Routes.Menu.route, R.drawable.eye)
                    Spacer(Modifier.size(32.dp))
                    CustomIconButton(navController, Routes.Menu.route, R.drawable.telega)
                    Spacer(Modifier.size(32.dp))
                    CustomIconButton(navController, Routes.Menu.route, R.drawable.profile)
                }
            }
        }

    }
}

@Composable
fun CustomBoxCard(
    navController: NavController,
    image: Int,
    text: String,
    price: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(164.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
            .clickable(onClick = { navController.navigate(Routes.Menu.route) })
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(7.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(image),
                contentDescription = null,
                modifier = Modifier.size(85.dp),
                contentScale = ContentScale.FillBounds
            )
            Spacer(Modifier.size(15.dp))
            Text(
                text,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            )
            Spacer(Modifier.size(3.dp))
            Text(
                price,
                style = TextStyle(
                    fontSize = 12.sp
                ),
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}

@Composable
fun CustomIconButton(navController: NavController, clicky: String, imaga: Int) {
    IconButton(onClick = { navController.navigate(clicky) }) {
        Image(
            painterResource(imaga),
            contentDescription = null,
            modifier = Modifier.size(21.dp)
        )
    }
}