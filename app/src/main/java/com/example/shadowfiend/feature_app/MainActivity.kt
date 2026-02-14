package com.example.shadowfiend.feature_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shadowfiend.feature_app.presintation.signin.SignUpScreen
import com.example.shadowfiend.feature_app.presintation.ui.theme.ShadowfiendTheme
import com.example.shadowfiend.feature_app.presintation.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShadowfiendTheme {
                val navcontroller = rememberNavController()

                NavHost(navController = navcontroller, startDestination = "Welcome") {
                    composable("SignIn") {
                        SignUpScreen(navcontroller)
                    }
                    composable("Welcome") {
                        WelcomeScreen(navcontroller)
                    }
                }

            }

        }
    }
}
