package com.example.shadowfiend.di

import com.example.shadowfiend.feature_app.data.repository.AuthRepositoryImpl
import com.example.shadowfiend.feature_app.domain.repository.AuthRepository
import com.example.shadowfiend.feature_app.domain.usecase.auth.SignInUseCase
import com.example.shadowfiend.feature_app.domain.usecase.auth.SignUpUseCase
import org.koin.dsl.module

val AuthModule = module {
    single<AuthRepository> { AuthRepositoryImpl() }

    factory { SignUpUseCase(get()) }
    factory { SignInUseCase(get()) }
}