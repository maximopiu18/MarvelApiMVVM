package com.example.testmarvel.ui.comics.repository


import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.testmarvel.apiservice.ApiService
import com.example.testmarvel.apiservice.RetrofitService
import com.example.testmarvel.costants.Constantes
import com.example.testmarvel.ui.comics.model.ResponseComics
import com.google.gson.Gson
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ComicsRepository() {

    var modelComicsResponse: ResponseComics? = null
    var context: Context? = null
    var newsApi: ApiService? = null

    companion object {

        var newsRepository: ComicsRepository? = null

        fun getInstance(): ComicsRepository? {
            if (newsRepository == null) {
                newsRepository = ComicsRepository()
            }
            return newsRepository
        }

    }


    fun callServiceComics(): MutableLiveData<ResponseComics> {
        Log.e("EJECUTANDO", "EJECUTANDO SERVICIO REST")

        val mutableLiveData: MutableLiveData<ResponseComics> = MutableLiveData<ResponseComics>()
        newsApi = RetrofitService.getInstance!!.create(ApiService::class.java)
        //val call = newsApi!!.getComics()
        val call = newsApi!!.getComics(Constantes.TIMESTAMP, Constantes.API_KEY, Constantes.HASH)

        call!!.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {

                try {
                    val gson = Gson()
                    modelComicsResponse = gson.fromJson(response.body()!!.string(), ResponseComics::class.java)
                    mutableLiveData.setValue(modelComicsResponse)
                    Log.e("valor:", "valor: " + modelComicsResponse!!.data!!.results!!.size)
                } catch (e: Exception) {
                    Log.e("error", "error$e")
                }


                    /*         System.out.println(""+ response.body()!!.string())
                             var body = response.body()!!.string()
                             var cadena=body.toString()
                             System.out.println(cadena)*/

                    /* var jsonObject  = JSONObject(cadena)

                     try {
                         val gson = Gson()
                         modelComicsResponse = gson.fromJson<ResponseComics>(cadena, ResponseComics::class.java)
                         mutableLiveData.setValue(modelComicsResponse)
                         Log.e("valor:", "valor: " + modelComicsResponse!!.data!!.results!!.size)
                     } catch (e: Exception) {
                         Log.e("error", "error$e")
                     }*/

                }

                override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                    Log.e("error", "error$t")
                }
            })

            return mutableLiveData
        }

    }