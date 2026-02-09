package com.example.shadowfiend.feature_app.presintation.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun SignUpScreen() {
    val mail = remember { mutableStateOf("") }

    Column() {
        Text(
            "✋ Добро пожаловать",
            fontSize = 24.sp
        )
        Spacer(Modifier.size(20.dp))
        Text(
            "Войдите, чтобы пользоваться функциями приложения",
            fontSize = 15.sp
        )
        Spacer(Modifier.size(50.dp))
        Text("Вход по E-mail")
        OutlinedTextField(
            value = null,
            onValueChange = {newText -> mail.value = newText}
        )
    }
}