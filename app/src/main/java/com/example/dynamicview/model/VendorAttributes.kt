package com.example.dynamicview.model

import com.example.dynamicview.model.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VendorAttributes(
    @SerializedName("Address Information")
    @Expose
    val addressInformation: List<AddressInformation> ? = null,

    @SerializedName("Company Information")
    @Expose
    val companyInformation: List<CompanyInformation>,

    @SerializedName("General Information")
    @Expose
    val generalInformation: List<GeneralInformation>,

    @SerializedName("SEO Information")
    @Expose
    val seoInformation: List<SEOInformation>,

    @SerializedName("Support Information")
    @Expose
    val supportInformation: List<SupportInformation>
)