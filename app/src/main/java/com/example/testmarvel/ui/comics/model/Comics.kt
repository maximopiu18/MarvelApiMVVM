package com.example.testmarvel.ui.comics.model

import com.example.testmarvel.ui.comics.model.*
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Comics : Serializable{
    @SerializedName("id")
    var id: Int? = null
    @SerializedName("digitalId")
    var digitalId: Int? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("issueNumber")
    var issueNumber: Int? = null
    @SerializedName("variantDescription")
    var variantDescription: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("modified")
    var modified: String? = null
    @SerializedName("isbn")
    var isbn: String? = null
    @SerializedName("upc")
    var upc: String? = null
    @SerializedName("diamondCode")
    var diamondCode: String? = null
    @SerializedName("ean")
    var ean: String? = null
    @SerializedName("issn")
    var issn: String? = null
    @SerializedName("format")
    var format: String? = null
    @SerializedName("pageCount")
    var pageCount: Int? = null
    @SerializedName("resourceURI")
    var resourceURI: String? = null
    @SerializedName("urls")
    var urls: ArrayList<Urls>? = null
    @SerializedName("series")
    var series: Series? = null
    @SerializedName("variants")
    var variants: ArrayList<Variants>? = null
    @SerializedName("dates")
    var dates: ArrayList<Dates>? =null
    @SerializedName("prices")
    var prices: ArrayList<Prices>? =null
    @SerializedName("thumbnail")
    var thumbnail: Thumbnail? =null




}