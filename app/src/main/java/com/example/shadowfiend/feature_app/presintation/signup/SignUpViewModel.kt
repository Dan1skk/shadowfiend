package com.example.shadowfiend.feature_app.presintation.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shadowfiend.feature_app.data.repository.AuthRepositoryImpl
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val repo: AuthRepositoryImpl
) : ViewModel() {
    var email by mutableStateOf("")
    val password by mutableStateOf("")

    fun onSignUp() {
        viewModelScope.launch {
            repo.SignUp(
                email = email,
                pass = password
            )
        }
    }

}