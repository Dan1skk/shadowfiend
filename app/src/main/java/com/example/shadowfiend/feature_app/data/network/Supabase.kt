package com.example.shadowfiend.feature_app.data.network

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.SettingsSessionManager
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object Supabase {
    val client = createSupabaseClient(
        supabaseUrl = "https://kdfrubpqlmcmkagooich.supabase.co",
        supabaseKey = "sb_publishable_4PxMUNYiQaE48muCljaIcQ_wxbSZ4nK"
    ) {
        install(Auth){
            sessionManager = SettingsSessionManager()
        }
        install(Postgrest)
        //install other modules
    }
}