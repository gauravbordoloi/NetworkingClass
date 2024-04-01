package com.codercampy.networkingclass

import com.google.gson.annotations.SerializedName

data class Person(
    val name: String,
    val language: String,
    val id: String,
    val bio: String,
    @SerializedName("app_version")
    val appVersion: Double?,
)