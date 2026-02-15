package com.example.shadowfiend.feature_app.domain.repository

interface AuthRepository {
    suspend fun SignUp(email: String, pass: String, name: String, phone: String)
    suspend fun SignIn(email: String, pass: String)
//    suspend fun verifyOTP(email: String, code: String): Result<Unit>
//    suspend fun saveProfile(firstName: String, lastName: String, gender: String): Result<Unit>
}