package com.example.dynamicview.model

import com.example.dynamicview.model.Data
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ServicesSetterGetter (
    @SerializedName("data")
    @Expose
    val data: Data? = null
)