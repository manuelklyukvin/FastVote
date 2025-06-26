package klyuch.echovote.core.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    internal const val API_URL = "http://192.168.83.42:8080/api/"

    private val gson = GsonBuilder().serializeNulls().create()

    val retrofit: Retrofit = Retrofit
        .Builder()
        .baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}