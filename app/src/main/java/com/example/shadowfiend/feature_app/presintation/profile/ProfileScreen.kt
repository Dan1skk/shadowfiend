package com.example.shadowfiend.feature_app.presintation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shadowfiend.R
import com.example.shadowfiend.feature_app.Routes
import com.example.shadowfiend.feature_app.presintation.ui.theme.AppColors
import okhttp3.Route

@Composable
fun ProfileScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 13.dp)
                .padding(top = 21.dp)
        ) {
            // 1. Кнопка назад (прижата к началу)
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.align(Alignment.CenterStart) // Центрируем вертикально, прижимаем влево
            ) {
                Image(
                    painterResource(R.drawable.arrowleft),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }

            // 2. Текст (всегда по центру всего Box)
            Text(
                "Профиль",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Center) // Ровно по центру
            )
        }
        Spacer(Modifier.size(16.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 33.dp),

            ) {
            CustomRowInfo(
                navController,
                R.drawable.flower,
                "Daun",
                "pipipopo",
                Routes.Menu.route,
                R.drawable.eye
            )
            Spacer(Modifier.size(29.dp))

            CustomRowInfo(
                navController,
                R.drawable.flower,
                "Номер телефона",
                "+7 812 324 6345",
                Routes.Menu.route,
                R.drawable.eye
            )
            Spacer(Modifier.size(29.dp))

            CustomRowInfo(
                navController,
                R.drawable.flower,
                "Почта",
                "apolsdiapoui@gmail.com",
                Routes.Menu.route,
                R.drawable.eye
            )
            Spacer(Modifier.size(29.dp))

            CustomRowInfo(
                navController,
                R.drawable.flower,
                "Адрес кофейни Magic Coffee",
                "г. Оренбург, ул. Чкалова 32",
                Routes.Menu.route,
                R.drawable.eye
            )

        }
    }
}

@Composable
fun CustomRowInfo(
    navController: NavController,
    image: Int,
    name: String,
    description: String,
    navigate: String,
    righticon: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(image),
            contentDescription = null,
            modifier = Modifier.size(42.dp)
        )
        Spacer(
            Modifier.size(16.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy((-8).dp)
        ) {
            Text(
                name,
                fontSize = 10.sp,
                color = AppColors.LightGray
            )
            Text(
                description,
                fontSize = 14.sp,
                color = AppColors.DarkBlue,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(Modifier.weight(1f))
        IconButton(onClick = { navController.navigate(navigate) }) {
            Image(
                painterResource(righticon),
                contentDescription = null,
                Modifier.size(24.dp)
            )
        }
    }
}