package com.example.shadowfiend.feature_app.presintation.signup

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SignUpScreen(viewModel: SignUpViewModel) {
    val mail = rememberSaveable() { mutableStateOf(viewModel.email) }
    val password = rememberSaveable() { mutableStateOf(viewModel.password) }

    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp)) {
        Spacer(Modifier.size(60.dp))
        Text(
            "✋ Добро пожаловать",
            fontSize = 24.sp
        )
        Spacer(Modifier.size(20.dp))
        Text(
            "Войдите, чтобы пользоваться функциями приложения",
            fontSize = 15.sp
        )
        Spacer(Modifier.size(64.dp))
        Text(
            "Вход по E-mail",
            color = Color.Gray
        )
        Spacer(Modifier.size(5.dp))
        OutlinedTextField(
            value = mail.value,
            onValueChange = { mail.value = it },
            placeholder = { Text("example@gmail.com")},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),


        )
        OutlinedTextField(
            value = password.value,
            onValueChange = {password.value = it},
            modifier = Modifier.fillMaxWidth(),

        )
    }
}