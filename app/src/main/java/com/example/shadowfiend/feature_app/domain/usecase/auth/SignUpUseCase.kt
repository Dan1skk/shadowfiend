package com.example.shadowfiend.feature_app.domain.usecase.auth

import com.example.shadowfiend.feature_app.domain.repository.AuthRepository

class SignUpUseCase(private val repo: AuthRepository) {
    suspend operator fun invoke(email: String, pass: String) {
        repo.SignUp(email, pass)
    }
}