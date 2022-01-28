package com.example.dynamicview.retrofit

import com.example.dynamicview.model.ServicesSetterGetter
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("index/getProfileFields")
    fun getServices(@Query("hashkey") hashkey : String,
                    @Query("vendor_id") vendor_id : Int )
    : Call<ServicesSetterGetter>

}