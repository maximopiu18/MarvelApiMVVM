package com.example.testmarvel.ui.comics.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Variants: Serializable {
    @SerializedName("resourceURI")
    var resourceURI: String? = null
    @SerializedName("name")
    var name: String? = null
}