package com.example.shadowfiend.feature_app.data.network

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object Supabase {
    val client = createSupabaseClient(
        supabaseUrl = "https://zffbthxstwybditwsgrw.supabase.co",
        supabaseKey = "sb_publishable_YAqL7a_xGivcpgFxsR6dTQ_hKLfH3_f"
    ) {
        install(Auth)
        install(Postgrest)
        //install other modules
    }
}