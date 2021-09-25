package com.example.testmarvel.apiservice


import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/v1/public/comics")
    fun getComics(@Query("ts") ts: String,
                  @Query("apikey") apikey: String,
                  @Query("hash") hash: String,
    ): Call<ResponseBody>

    @GET("")
    fun getComics(): Call<ResponseBody>


}