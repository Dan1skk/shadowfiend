package com.example.shadowfiend.feature_app.data.repository

import com.example.shadowfiend.feature_app.data.network.Supabase
import com.example.shadowfiend.feature_app.data.network.Supabase.client
import com.example.shadowfiend.feature_app.domain.repository.AuthRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email

class AuthRepositoryImpl(): AuthRepository{
    override suspend fun SignUp(email: String, pass: String) {
        client.auth.signUpWith(Email) {
            this.email = email
            password = pass
        }
    }

    override suspend fun SignIn(email: String, pass: String) {
        client.auth.signInWith(provider = Email) {
            this.email = email
            password = pass
        }
    }

}