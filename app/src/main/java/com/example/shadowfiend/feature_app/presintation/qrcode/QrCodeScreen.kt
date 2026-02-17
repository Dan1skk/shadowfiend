package com.example.shadowfiend.feature_app.presintation.qrcode

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shadowfiend.R

@Composable
fun QrCodeScreen() {
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
            IconButton(
                onClick = {},
                Modifier.align(Alignment.CenterStart)                        .size(24.dp)
                ,

                ) {
                Image(
                    painterResource(R.drawable.arrowleft),
                    contentDescription = null,
                    Modifier

                )
            }
            Text(
                "Профиль",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(Modifier.size(27.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Ваш персональный QR-код",
                fontSize = 20.sp,
            )
            Spacer(Modifier.size(30.dp))
            Image(
                painterResource(R.drawable.qr_code),
                contentDescription = null,
            )
            Spacer(Modifier.size(20.dp))
            Text(
                "Покажите ваш QR-code\nдля получения заказа",
                fontSize = 18.sp,
//                textAlign = TextAlign.Center

            )
        }

    }
}