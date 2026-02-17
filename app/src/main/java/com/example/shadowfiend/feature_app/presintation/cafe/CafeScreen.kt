package com.example.shadowfiend.feature_app.presintation.cafe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shadowfiend.R
import com.example.shadowfiend.feature_app.Routes

// Основные цвета из макета
val AppGreen = Color(0xFF1DB954)
val DarkSurface = Color(0xFF121212)

@Composable
fun CafeScreen() {
    Box(modifier = Modifier.fillMaxSize().background(DarkSurface)) {

        // 1. Фоновое изображение карты
        Image(
            painter = painterResource(id = R.drawable.map), // Замените на ваш ресурс
            contentDescription = "Map Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // 2. Нижняя панель (BottomSheet-like)
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(AppGreen)
                .padding(top = 20.dp)
        ) {
            Text(
                text = "Выберите кофейню Coffee break",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Белая область со списком
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                    .background(Color.White)
                    .padding(20.dp)
            ) {
                AddressItem("ул. Туркестанская, 3", Routes.Menu.route)

                // Отступ снизу для красоты
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun AddressItem(address: String, route: String) {
    Surface(
        onClick = { route },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        color = AppGreen
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = null,
                tint = Color.White
            )

            Text(
                text = address,
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .weight(1f)
            )

            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null,
                tint = Color.White.copy(alpha = 0.7f)
            )
        }
    }
}