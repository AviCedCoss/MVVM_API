package com.example.dynamicview.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Option(
    @SerializedName("label")
    @Expose
    val label: String? = null,
    @SerializedName("value")
    @Expose
    val value: String? = null
)