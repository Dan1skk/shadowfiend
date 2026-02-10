package com.example.shadowfiend.feature_app

sealed class Routes(val route: String) {
    object SignUp : Routes("SignUp")
}