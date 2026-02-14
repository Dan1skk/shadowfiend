package com.example.shadowfiend.feature_app.presintation.signin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shadowfiend.feature_app.domain.usecase.auth.SignInUseCase
import kotlinx.coroutines.launch

class SignInViewModel(
    private val signInUseCase: SignInUseCase
) : ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    var isAuthComplete by mutableStateOf(false)

    fun onSignUp() {
        viewModelScope.launch {
            signInUseCase(
                email = email,
                pass = password
            )
            isAuthComplete = true
        }
    }

}