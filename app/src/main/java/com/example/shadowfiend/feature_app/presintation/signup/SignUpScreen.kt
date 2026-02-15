package com.example.shadowfiend.feature_app.presintation.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

    val checkedState = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(Modifier.size(21.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 26.dp)
        ) {
            // кнопка назад
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .size(24.dp)
            ) {
                Icon(
                    Icons.Default.ArrowBack,
                    null,

                    )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 41.dp)
        ) {
            // тексты
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    "Зарегистрироваться",
                    style = TextStyle(
                        fontSize = 22.sp,
                        color = AppColors.c14AC46
                    )
                )

                Text(
                    "Создать аккаунт здесь",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = AppColors.DarkBlue
                    )
                )
            }


            // Поля
            Column() {
                TextField(
                    value = viewModel.name,
                    onValueChange = { viewModel.name = it },
                    placeholder = { Text("Имя") },
                    leadingIcon = { Icon(Icons.Default.AccountCircle, null) }
                )

                TextField(
                    value = viewModel.phone,
                    onValueChange = { viewModel.phone = it },
                    placeholder = { Text("Телефон") },
                    leadingIcon = { Icon(Icons.Default.Phone, null) }

                )

                TextField(
                    value = viewModel.email,
                    onValueChange = { viewModel.email = it },
                    placeholder = { Text("Почта") },
                    leadingIcon = { Icon(Icons.Default.Email, null) }
                )

                TextField(
                    value = viewModel.password,
                    onValueChange = { viewModel.password = it },
                    placeholder = { Text("Пароль") },
                    leadingIcon = { Icon(Icons.Default.Lock, null) }
                )
            }

            // условия

            Row() {
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it }
                )
                Text(
                    "Я принимаю условия пользовательского соглашения",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = AppColors.DarkBlue
                    )
                )
            }

            // кнопка
            IconButton(
                onClick = { viewModel.onSignUp() },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.End)
                    .size(64.dp)
                    .background(AppColors.c14AC46, CircleShape),

                ) {
                Icon(
                    Icons.Default.ArrowForward,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}