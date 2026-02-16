package com.example.shadowfiend.feature_app.presintation.signup

import android.widget.ImageButton
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

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.shadowfiend.feature_app.presintation.common.CustomAlertDialog
import com.example.shadowfiend.feature_app.presintation.ui.theme.AppColors
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: SignUpViewModel = koinViewModel()
) {
    if (viewModel.showAlertDiag) {
        CustomAlertDialog(
            onDismiss = { viewModel.showAlertDiag = false }
        )
    }
    val checkedState = remember { mutableStateOf(false) }
    val customTextFieldColors = TextFieldDefaults.colors(
        unfocusedContainerColor = Color.Transparent,
        focusedContainerColor = Color.Transparent,
        unfocusedIndicatorColor = Color.LightGray,
        focusedIndicatorColor = Color.LightGray,
    )
    val customPlaceHolderText = TextStyle(
        fontSize = 12.sp,
        color = AppColors.A1A1A1
    )
    val passwordVisibility = remember { mutableStateOf(false) }

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
                Image(
                    painterResource(R.drawable.arrowleft),
                    null,

                    )
            }
        }
        Spacer(Modifier.size(46.dp))
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
                Spacer(Modifier.size(24.dp))
                Text(
                    "Создать аккаунт здесь",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = AppColors.DarkBlue
                    )
                )
            }
            Spacer(Modifier.size(32.dp))

            // Поля
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                TextField(
                    value = viewModel.name,
                    onValueChange = { viewModel.name = it },
                    placeholder = { Text("Имя пользователя", style = customPlaceHolderText) },
                    leadingIcon = {
                        Row() {
                            Image(
                                painterResource(R.drawable.profilesvg),
                                null,
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.CenterVertically)
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
                )

                TextField(
                    value = viewModel.phone,
                    onValueChange = { viewModel.phone = it },
                    placeholder = {
                        Text(
                            "Номер мобильного телефона",
                            style = customPlaceHolderText
                        )
                    },
                    leadingIcon = {
                        Row() {
                            Image(
                                painterResource(R.drawable.smartphone),
                                null,
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.CenterVertically)
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
                    colors = customTextFieldColors

                )

                TextField(
                    value = viewModel.email,
                    onValueChange = { viewModel.email = it },
                    placeholder = {
                        Text(
                            "Адрес электронной почты",
                            style = customPlaceHolderText
                        )
                    },
                    leadingIcon = {
                        Row() {
                            Image(
                                painterResource(R.drawable.message),
                                null,
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.CenterVertically)
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

                TextField(
                    value = viewModel.password,
                    onValueChange = { viewModel.password = it },
                    placeholder = { Text("Пароль", style = customPlaceHolderText) },
                    leadingIcon = {
                        Row() {
                            Image(
                                painterResource(R.drawable.lock),
                                null,
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.CenterVertically)
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
                        IconButton(onClick = {
                            passwordVisibility.value = !passwordVisibility.value
                        }) {
                            Image(
                                painterResource(R.drawable.eye),
                                null,
                                Modifier.size(18.dp),
                            )
                        }
                    },
                    colors = customTextFieldColors,
                    visualTransformation = if (passwordVisibility.value) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
            }


            Spacer(Modifier.size(22.dp))
            // условия
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = AppColors.A1A1A1, // Теперь рамка будет серой при выборе
                        uncheckedColor = AppColors.A1A1A1, // И при пустом состоянии
                        checkmarkColor = Color.White // Цвет самой птички

                    )
                )
                Text(
                    "Я принимаю условия пользовательского соглашения",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = AppColors.DarkBlue
                    ),
                )
            }

            // кнопка
            IconButton(
                onClick = {
                    viewModel.onSignUp()
                },
                enabled = checkedState.value,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.End)
                    .size(64.dp)
                    .background(
                        if (checkedState.value) {
                            AppColors.c14AC46
                        } else {
                            AppColors.inactive
                        }, CircleShape
                    ),

                ) {
                Image(
                    painterResource(R.drawable.arrowright),
                    contentDescription = null,
                )
            }

            // войти
            Row(modifier = Modifier.padding(top = 92.dp)) {
                Text(
                    "Уже зарегистрировались? ",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = AppColors.DarkBlue
                    )
                )
                Text(
                    "Войти.",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = AppColors.c14AC46
                    ),
                    modifier = Modifier.clickable { navController.navigate(Routes.SignIn.route) }
                )
            }
        }
    }
}