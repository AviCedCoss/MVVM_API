package com.example.dynamicview.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GeneralInformation(
    @SerializedName("field_name")
    @Expose
    val field_name: String?= null,

    @SerializedName("field_to_post")
    @Expose
    val field_to_post: String?= null,

    @SerializedName("input_type")
    @Expose
    val input_type: String? = null,

    @SerializedName("is_required")
    @Expose
    val is_required: String?=null,

    @SerializedName("options")
    @Expose
    val options: List<OptionX>? = null,

    @SerializedName("saved_value")
    @Expose
    val saved_value: String? = null,

    @SerializedName("type")
    @Expose
    val type: String? = null
)