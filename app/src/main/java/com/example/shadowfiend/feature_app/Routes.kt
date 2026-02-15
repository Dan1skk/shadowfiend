package com.example.shadowfiend.feature_app

sealed class Routes(val route: String) {
    object SignIn : Routes("SignIn")
    object Welcome : Routes("Welcome")
}