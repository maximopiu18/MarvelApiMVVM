package com.example.testmarvel.ui.comics.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Prices: Serializable {
    @SerializedName("type")
    var type: String? = null
    @SerializedName("price")
    var price: Double? = null
}