package com.example.dynamicview.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("success")
    @Expose
    val success: Boolean? = null,

    @SerializedName("vendor_attributes")
    @Expose
    val vendor_attributes: VendorAttributes? = null
)