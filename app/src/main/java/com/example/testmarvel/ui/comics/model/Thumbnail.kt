package com.example.testmarvel.ui.comics.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Thumbnail: Serializable {
    @SerializedName("path")
    var path: String? = null
    @SerializedName("extension")
    var extension: String? = null
}