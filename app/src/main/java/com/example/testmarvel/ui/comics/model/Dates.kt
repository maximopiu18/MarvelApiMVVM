package com.example.testmarvel.ui.comics.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Dates: Serializable {
    @SerializedName("type")
    var type: String? = null
    @SerializedName("date")
    var date: String? = null
}