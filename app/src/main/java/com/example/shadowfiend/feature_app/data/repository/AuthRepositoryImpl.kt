package com.example.shadowfiend.feature_app.data.repository

import com.example.shadowfiend.feature_app.data.network.Supabase
import com.example.shadowfiend.feature_app.data.network.Supabase.client
import com.example.shadowfiend.feature_app.domain.repository.AuthRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.postgrest.from

class AuthRepositoryImpl(): AuthRepository{
    override suspend fun SignUp(email: String, pass: String, name: String, phone: String) {
        val authResponse =
        client.auth.signUpWith(Email) {
            this.email = email
            password = pass
        }

        val userId = authResponse?.id ?: client.auth.currentUserOrNull()?.id

        if (userId != null) {
            // 2. Вставляем данные в профиль
            client.from("profiles").insert(
                mapOf(
                    "userId" to userId,
                    "name" to name,
                    "phone" to phone
                )
            )
        } else {
            println("Ошибка: ID пользователя не получен. Возможно, нужно подтверждение почты.")
        }
    }

    override suspend fun SignIn(email: String, pass: String) {
        client.auth.signInWith(provider = Email) {
            this.email = email
            password = pass
        }
    }

}