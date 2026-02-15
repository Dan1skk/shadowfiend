package com.example.shadowfiend.feature_app.presintation.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shadowfiend.feature_app.presintation.ui.theme.AppColors
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: SignUpViewModel = koinViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // кнопка назад
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                Icons.Default.ArrowBack,
                null,

                )
        }

        // тексты
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                "Зарегистрироваться",
                style = TextStyle(
                    fontSize = 24.sp,
                    color = AppColors.c14AC46
                )
            )

            Text(
                "Создать аккаунт здесь",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = AppColors.DarkBlue
                )
            )
        }

        // Поля
        TextField(
            value = viewModel.email,
            onValueChange = {viewModel.email = it},
            placeholder = {Text("Почта")}
        )
    }
}