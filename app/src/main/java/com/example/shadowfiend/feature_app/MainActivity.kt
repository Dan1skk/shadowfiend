package com.example.shadowfiend.feature_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shadowfiend.feature_app.data.network.Supabase.client
import com.example.shadowfiend.feature_app.presintation.signin.SignInScreen
import com.example.shadowfiend.feature_app.presintation.signup.SignUpScreen
import com.example.shadowfiend.feature_app.presintation.startup.StartUpScreen
import com.example.shadowfiend.feature_app.presintation.ui.theme.ShadowfiendTheme
import com.example.shadowfiend.feature_app.presintation.welcome.WelcomeScreen
import io.github.jan.supabase.auth.auth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShadowfiendTheme {
                val navcontroller = rememberNavController()

                NavHost(navController = navcontroller, startDestination = Routes.Welcome.route) {
                    composable(Routes.SignIn.route) {
                        SignInScreen(navcontroller)
                    }
                    composable(Routes.Welcome.route) {
                        WelcomeScreen(navcontroller)
                    }
                    composable(Routes.SignUp.route) {
                        SignUpScreen(navcontroller)
                    }
                    composable(Routes.StartUp.route) {
                        StartUpScreen(navcontroller)
                    }
                }

            }

        }
    }
}
