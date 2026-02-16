package com.example.shadowfiend.feature_app.presintation.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.example.shadowfiend.feature_app.presintation.ui.theme.AppColors

@Composable
fun CustomAlertDialog(
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text("Ok", color = AppColors.c14AC46)
            }
        },
        title = {
            Text("Ошибка")
        },
        text = {Text(text = "Some Data Error")}
    )
}