package com.example.shadowfiend.feature_app.domain.repository

interface AuthRepository {
    suspend fun signUpWithEmail(email: String, password: String): Result<Unit>
    suspend fun signInWithEmail(email: String, password: String): Result<Unit>
    suspend fun verifyOTP(email: String, code: String): Result<Unit>
    suspend fun saveProfile(firstName: String, lastName: String, gender: String): Result<Unit>
}