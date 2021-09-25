package com.example.testmarvel.apiservice

import com.example.testmarvel.costants.Constantes
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private var retrofit: Retrofit? = null
    val getInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(Constantes.URL_BASE).addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit
        }
}