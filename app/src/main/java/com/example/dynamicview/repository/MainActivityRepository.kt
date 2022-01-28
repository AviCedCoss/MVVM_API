package com.example.dynamicview.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.dynamicview.MainActivity
import com.example.dynamicview.model.ServicesSetterGetter
import com.example.dynamicview.retrofit.RetrofitClient
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    val serviceSetterGetter = MutableLiveData<ServicesSetterGetter>()

    fun getServicesApiCall(): MutableLiveData<ServicesSetterGetter> {
        val call = RetrofitClient.apiInterface.getServices(
            "rNRccT7K6NVaZ6wgvsuLEUMow22IPYqp"
            ,1
        )
        call.enqueue(object: Callback<ServicesSetterGetter> {
            override fun onFailure(call: Call<ServicesSetterGetter>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }
            override fun onResponse(
                call: Call<ServicesSetterGetter>,
                response: Response<ServicesSetterGetter>
            ) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())

                val main = MainActivity()

                val productData=Gson().toJson(response.body())
                val jsonObject = JSONObject(productData)
                val newData=jsonObject.getJSONObject("data")
                if(newData.getString("success")=="true")
                {
                    val vendorAttributes=newData.getJSONObject("vendor_attributes")
                    val addressArray=vendorAttributes.getJSONArray("Address Information")
                    for(i in 0 until addressArray.length())
                    {
                            if(addressArray.getJSONObject(i).getString("field_to_post")=="address")
                            {
                                val address=addressArray.getJSONObject(i).getString("saved_value")
                                main.tvAddress.setText(address)
                                Log.v("city : ", address.toString())
                            }
                            else if (addressArray.getJSONObject(i).getString("field_to_post")=="city"){
                                val city=addressArray.getJSONObject(i).getString("saved_value")
                                main.tvCity.setText(city)
                                Log.v("city : ", city.toString())
                            }
                            else if (addressArray.getJSONObject(i).getString("field_to_post")=="zip_code"){
                                val zipcode=addressArray.getJSONObject(i).getString("saved_value")
                                main.tvPinCode.setText(zipcode)
                                Log.v("city : ", zipcode.toString())
                            }
                            else if (addressArray.getJSONObject(i).getString("field_to_post")=="region_id"){
                                val state=addressArray.getJSONObject(i).getString("saved_value")
                                // main.spState.setText(state)
                                Log.v("city : ", state.toString())
                            }
                            else if (addressArray.getJSONObject(i).getString("field_to_post")=="country_id"){
                                val country=addressArray.getJSONObject(i).getString("saved_value")
                                 //main.spCountry.setText(state)
                                Log.v("city : ", country.toString())
                            }

                    }

                    val companyArray=vendorAttributes.getJSONArray("Company Information")
                    for(i in 0 until companyArray.length())
                    {
                        if(companyArray.getJSONObject(i).getString("field_to_post")=="company_name")
                        {
                            val companyName=companyArray.getJSONObject(i).getString("saved_value")
                            main.tvCompanyName.setText(companyName)
                            Log.v("city : ", companyName.toString())
                        }
                        else if (companyArray.getJSONObject(i).getString("field_to_post")=="about"){
                            val about=companyArray.getJSONObject(i).getString("saved_value")
                            main.tvAbout.setText(about)
                            Log.v("city : ", about.toString())
                        }
                        else if (companyArray.getJSONObject(i).getString("field_to_post")=="company_logo"){
                            val companyLogo=companyArray.getJSONObject(i).getString("saved_value")
                            Picasso.get().load(companyLogo).into(main.ivCompanyLogo)
                            // main.tvPinCode.setText(zipcode)
                            Log.v("city : ", companyLogo.toString())
                        }
                        else if (companyArray.getJSONObject(i).getString("field_to_post")=="company_banner"){
                            val companyBanner=companyArray.getJSONObject(i).getString("saved_value")
                            Picasso.get().load(companyBanner).into(main.ivCompanyBanner)
                            Log.v("city : ", companyBanner.toString())
                        }
                        else if (companyArray.getJSONObject(i).getString("field_to_post")=="region_id"){
                            val state=companyArray.getJSONObject(i).getString("saved_value")
                            //main.compa.setText(state)
                            Log.v("city : ", state.toString())
                        }
                        else if (companyArray.getJSONObject(i).getString("field_to_post")=="company_address"){
                            val companyAddress=companyArray.getJSONObject(i).getString("saved_value")
                            main.tvCompanyAddress.setText(companyAddress)
                            Log.v("city : ", companyAddress.toString())
                        }

                    }

                    val generalInformation=vendorAttributes.getJSONArray("General Information")
                    for(i in 0 until generalInformation.length())
                    {
                        if(generalInformation.getJSONObject(i).getString("field_to_post")=="public_name")
                        {
                            val publicName=generalInformation.getJSONObject(i).getString("saved_value")
                            main.tvPersonName.setText(publicName)
                            Log.v("city : ", publicName.toString())
                        }
                        else if (generalInformation.getJSONObject(i).getString("field_to_post")=="name"){
                            val name=generalInformation.getJSONObject(i).getString("saved_value")
                            main.tvName.setText(name)
                            Log.v("city : ", name.toString())
                        }
                        else if (generalInformation.getJSONObject(i).getString("field_to_post")=="Gender"){
                            val gender=generalInformation.getJSONObject(i).getString("saved_value")
                            // main.tvPinCode.setText(zipcode)
                            Log.v("city : ", gender.toString())
                        }
                        else if (generalInformation.getJSONObject(i).getString("field_to_post")=="profile_picture"){
                            val profilePicture=generalInformation.getJSONObject(i).getString("saved_value")
                            Picasso.get().load(profilePicture).into(main.ivProfilePicture)
                            Log.v("city : ", profilePicture.toString())
                        }
                        else if (generalInformation.getJSONObject(i).getString("field_to_post")=="email"){
                            val email=generalInformation.getJSONObject(i).getString("saved_value")
                            main.tvEmail.setText(email)
                            Log.v("city : ", email.toString())
                        }
                        else if (generalInformation.getJSONObject(i).getString("field_to_post")=="contact_number"){
                            val contactNumber=generalInformation.getJSONObject(i).getString("saved_value")
                            main.tvContactNumber.setText(contactNumber)
                            Log.v("city : ", contactNumber.toString())
                        }

                    }

                    val seoInformation=vendorAttributes.getJSONArray("SEO Information")
                    for(i in 0 until seoInformation.length())
                    {
                        if(seoInformation.getJSONObject(i).getString("field_to_post")=="meta_keywords")
                        {
                            val metaKeywords=seoInformation.getJSONObject(i).getString("saved_value")
                            main.tvMetaKeywords.setText(metaKeywords)
                            Log.v("city : ", metaKeywords.toString())
                        }
                        else if (seoInformation.getJSONObject(i).getString("field_to_post")=="meta_description"){
                            val metaDescription=seoInformation.getJSONObject(i).getString("saved_value")
                            main.tvMetaDescription.setText(metaDescription)
                            Log.v("city : ", metaDescription.toString())
                        }
                    }

                    val supportInformation=vendorAttributes.getJSONArray("Support Information")
                    for(i in 0 until supportInformation.length())
                    {
                        if(supportInformation.getJSONObject(i).getString("field_to_post")=="support_number")
                        {
                            val supportNumber=supportInformation.getJSONObject(i).getString("saved_value")
                            main.tvSupportNumber.setText(supportNumber)
                            Log.v("city : ", supportNumber.toString())
                        }
                        else if (supportInformation.getJSONObject(i).getString("field_to_post")=="support_email"){
                            val supportEmail=supportInformation.getJSONObject(i).getString("saved_value")
                            main.tvSupportEmail.setText(supportEmail)
                            Log.v("city : ", supportEmail.toString())
                        }
                        else if (supportInformation.getJSONObject(i).getString("field_to_post")=="facebook_id"){
                            val facebookId=supportInformation.getJSONObject(i).getString("saved_value")
                            main.tvFaceBookId.setText(facebookId)
                            Log.v("city : ", facebookId.toString())
                        }
                        else if (supportInformation.getJSONObject(i).getString("field_to_post")=="twitter_id"){
                            val twitterId=supportInformation.getJSONObject(i).getString("saved_value")
                            main.tvTwitterId.setText(twitterId)
                            Log.v("city : ", twitterId.toString())
                        }
                    }
                }
            }
        })

        return serviceSetterGetter
    }
}