package com.example.shadowfiend.feature_app.presintation.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shadowfiend.R
import com.example.shadowfiend.feature_app.Routes
import com.example.shadowfiend.feature_app.presintation.ui.theme.AppColors
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignInScreen(
    navController: NavController,
    viewModel: SignInViewModel = koinViewModel()
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val customTextFieldColors = TextFieldDefaults.colors(
        unfocusedContainerColor = Color.Transparent,
        focusedContainerColor = Color.Transparent,
        unfocusedIndicatorColor = Color.LightGray,
        focusedIndicatorColor = Color.LightGray,
    )
    LaunchedEffect(viewModel.isAuthComplete) {
        if (viewModel.isAuthComplete) {
            navController.navigate("StartUp") {
                popUpTo("SignIn") { inclusive = true }
            }
        }
    }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = 41.dp),
    ) {
        //первое
        Column(
            modifier = Modifier
                .padding(top = 90.dp)
                .fillMaxWidth()
        ) {
            Text(
                "Войти",
                style = TextStyle(
                    color = AppColors.c14AC46,
                    fontSize = 24.sp
                )
            )
            Text(
                "Добро пожаловать",
                style = TextStyle(
                    color = AppColors.DarkBlue,
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top = 24.dp)
            )
        }

        // поля
        Column(
            modifier = Modifier
                .padding(top = 58.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = viewModel.email,
                onValueChange = { viewModel.email = it },
                placeholder = {
                    Text(
                        "Адрес электронной почты",
                        fontSize = 14.sp
                    )
                },
                leadingIcon = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.Email,
                            contentDescription = null,
                            tint = AppColors.c14AC46
                        )
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 12.dp)
                                .width(1.dp)
                                .height(24.dp)
                                .background(Color.LightGray)
                        )
                    }
                },
                colors = customTextFieldColors,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

            )
            Spacer(Modifier.size(16.dp))

            TextField(
                value = viewModel.password,
                onValueChange = { viewModel.password = it },
                placeholder = {
                    Text(
                        "Пароль",
                        fontSize = 14.sp
                    )
                },
                leadingIcon = {
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Icon(
                            Icons.Outlined.Lock,
                            contentDescription = null,
                            tint = AppColors.c14AC46
                        )
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 12.dp)
                                .width(1.dp)
                                .height(24.dp)
                                .background(Color.LightGray)
                        )
                    }
                },
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(
                                if (passwordVisible) R.drawable.eye else R.drawable.welcomeico // используй свои ресурсы
                            ),
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                colors = customTextFieldColors,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(Modifier.size(18.dp))
            Text(
                "Забыли пароль?",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = AppColors.c14AC46
                ),
            )

        }

        Spacer(Modifier.size(116.dp))

        // кнопка
        IconButton(
            onClick = { viewModel.onSignIn() },
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

        // сервисы
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Войти с помощью",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black
                )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(38.dp)

                ) {
                    Image(
                        painterResource(R.drawable.yandexz),
                        contentDescription = null,
                    )
                }
                Spacer(Modifier.size(6.dp))
                IconButton(
                    onClick = {navController.navigate(Routes.Menu.route)},
                    modifier = Modifier.size(38.dp)

                ) {
                    Image(
                        painterResource(R.drawable.google),
                        contentDescription = null,
                    )
                }
                Spacer(Modifier.size(6.dp))
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(38.dp)

                ) {
                    Image(
                        painterResource(R.drawable.vk),
                        contentDescription = null,
                    )
                }

            }
        }

        // впревые
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 26.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Впервые? ",
                fontSize = 14.sp,
                color = Color.Gray
            )
            Text(
                text = "Зарегистрироваться.",
                fontSize = 14.sp,
                color = AppColors.c14AC46,
                modifier = Modifier.clickable {
                    navController.navigate("SignUp")
                }
            )
        }

    }
}

