package com.example.shadowfiend.feature_app.presintation.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shadowfiend.feature_app.domain.usecase.auth.SignUpUseCase
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var name by mutableStateOf("")
    var phone by mutableStateOf("")
    var showAlertDiag by mutableStateOf(false)


    fun onSignUp() {
        viewModelScope.launch {
            try {

                signUpUseCase(
                    email, password, name, phone
                )
            } catch (e: Exception) {
                showAlertDiag = true
            }
        }
    }


}