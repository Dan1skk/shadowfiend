package com.example.shadowfiend.di

import com.example.shadowfiend.feature_app.presintation.signin.SignInViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val ViewModelModule = module {
    viewModelOf(::SignInViewModel)

}