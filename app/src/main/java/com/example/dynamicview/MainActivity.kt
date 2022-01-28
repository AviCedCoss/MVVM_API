package com.example.dynamicview

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dynamicview.databinding.ActivityMainBinding
import com.example.dynamicview.viewmodel.MainActivityViewModel
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var context: Context
    private lateinit var mainActivityViewModel: MainActivityViewModel
     lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        context = this@MainActivity

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        mainActivityViewModel.getUser()!!.observe(this, Observer { serviceSetterGetter ->

            val productData= Gson().toJson(serviceSetterGetter)
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
                        binding.tvAddress.setText(address)
                        Log.v("city : ", address.toString())
                    }
                    else if (addressArray.getJSONObject(i).getString("field_to_post")=="city"){
                        val city=addressArray.getJSONObject(i).getString("saved_value")
                        binding.tvCity.setText(city)
                        Log.v("city : ", city.toString())
                    }
                    else if (addressArray.getJSONObject(i).getString("field_to_post")=="zip_code"){
                        val zipcode=addressArray.getJSONObject(i).getString("saved_value")
                        binding.tvPinCode.setText(zipcode)
                        Log.v("city : ", zipcode.toString())
                    }
                    else if (addressArray.getJSONObject(i).getString("field_to_post")=="region_id"){
                        val state=addressArray.getJSONObject(i).getJSONArray("options")

                        // access the spinner
                        val spinner = binding.spState
                       /* if (spinner != null) {
                            val adapter = ArrayAdapter(this,
                                android.R.layout.simple_spinner_item, state)
                            spinner.adapter = adapter

                            spinner.onItemSelectedListener = object :
                                AdapterView.OnItemSelectedListener {
                                override fun onItemSelected(parent: AdapterView<*>,
                                                            view: View, position: Int, id: Long) {

                                }

                                override fun onNothingSelected(parent: AdapterView<*>) {
                                    // write code to perform some action
                                }
                            }
                        }*/

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
                        binding.tvCompanyName.setText(companyName)
                        Log.v("city : ", companyName.toString())
                    }
                    else if (companyArray.getJSONObject(i).getString("field_to_post")=="about"){
                        val about=companyArray.getJSONObject(i).getString("saved_value")
                        binding.tvAbout.setText(about)
                        Log.v("city : ", about.toString())
                    }
                    else if (companyArray.getJSONObject(i).getString("field_to_post")=="company_logo"){
                        val companyLogo=companyArray.getJSONObject(i).getString("saved_value")
                        Picasso.get().load(companyLogo).into(binding.ivCompanyLogo)
                        // main.tvPinCode.setText(zipcode)
                        Log.v("city : ", companyLogo.toString())
                    }
                    else if (companyArray.getJSONObject(i).getString("field_to_post")=="company_banner"){
                        val companyBanner=companyArray.getJSONObject(i).getString("saved_value")
                        Picasso.get().load(companyBanner).into(binding.ivCompanyBanner)
                        Log.v("city : ", companyBanner.toString())
                    }
                    else if (companyArray.getJSONObject(i).getString("field_to_post")=="region_id"){
                        val state=companyArray.getJSONObject(i).getString("saved_value")
                        //main.compa.setText(state)
                        Log.v("city : ", state.toString())
                    }
                    else if (companyArray.getJSONObject(i).getString("field_to_post")=="company_address"){
                        val companyAddress=companyArray.getJSONObject(i).getString("saved_value")
                        binding.tvCompanyAddress.setText(companyAddress)
                        Log.v("city : ", companyAddress.toString())
                    }

                }

                val generalInformation=vendorAttributes.getJSONArray("General Information")
                for(i in 0 until generalInformation.length())
                {
                    if(generalInformation.getJSONObject(i).getString("field_to_post")=="public_name")
                    {
                        val publicName=generalInformation.getJSONObject(i).getString("saved_value")
                        binding.tvPersonName.setText(publicName)
                        Log.v("city : ", publicName.toString())
                    }
                    else if (generalInformation.getJSONObject(i).getString("field_to_post")=="name"){
                        val name=generalInformation.getJSONObject(i).getString("saved_value")
                        binding.tvName.setText(name)
                        Log.v("city : ", name.toString())
                    }
                    else if (generalInformation.getJSONObject(i).getString("field_to_post")=="Gender"){
                        val gender=generalInformation.getJSONObject(i).getString("saved_value")
                        //binding.tvPinCode.setText(zipcode)
                        Log.v("city : ", gender.toString())
                    }
                    else if (generalInformation.getJSONObject(i).getString("field_to_post")=="profile_picture"){
                        val profilePicture=generalInformation.getJSONObject(i).getString("saved_value")
                        Picasso.get().load(profilePicture).into(binding.ivProfilePicture)
                        Log.v("city : ", profilePicture.toString())
                    }
                    else if (generalInformation.getJSONObject(i).getString("field_to_post")=="email"){
                        val email=generalInformation.getJSONObject(i).getString("saved_value")
                        binding.tvEmail.setText(email)
                        Log.v("city : ", email.toString())
                    }
                    else if (generalInformation.getJSONObject(i).getString("field_to_post")=="contact_number"){
                        val contactNumber=generalInformation.getJSONObject(i).getString("saved_value")
                        binding.tvContactNumber.setText(contactNumber)
                        Log.v("city : ", contactNumber.toString())
                    }

                }

                val seoInformation=vendorAttributes.getJSONArray("SEO Information")
                for(i in 0 until seoInformation.length())
                {
                    if(seoInformation.getJSONObject(i).getString("field_to_post")=="meta_keywords")
                    {
                        val metaKeywords=seoInformation.getJSONObject(i).getString("saved_value")
                        binding.tvMetaKeywords.setText(metaKeywords)
                        Log.v("city : ", metaKeywords.toString())
                    }
                    else if (seoInformation.getJSONObject(i).getString("field_to_post")=="meta_description"){
                        val metaDescription=seoInformation.getJSONObject(i).getString("saved_value")
                        binding.tvMetaDescription.setText(metaDescription)
                        Log.v("city : ", metaDescription.toString())
                    }
                }

                val supportInformation=vendorAttributes.getJSONArray("Support Information")
                for(i in 0 until supportInformation.length())
                {
                    if(supportInformation.getJSONObject(i).getString("field_to_post")=="support_number")
                    {
                        val supportNumber=supportInformation.getJSONObject(i).getString("saved_value")
                        binding.tvSupportNumber.setText(supportNumber)
                        Log.v("city : ", supportNumber.toString())
                    }
                    else if (supportInformation.getJSONObject(i).getString("field_to_post")=="support_email"){
                        val supportEmail=supportInformation.getJSONObject(i).getString("saved_value")
                        binding.tvSupportEmail.setText(supportEmail)
                        Log.v("city : ", supportEmail.toString())
                    }
                    else if (supportInformation.getJSONObject(i).getString("field_to_post")=="facebook_id"){
                        val facebookId=supportInformation.getJSONObject(i).getString("saved_value")
                        binding.tvFaceBookId.setText(facebookId)
                        Log.v("city : ", facebookId.toString())
                    }
                    else if (supportInformation.getJSONObject(i).getString("field_to_post")=="twitter_id"){
                        val twitterId=supportInformation.getJSONObject(i).getString("saved_value")
                        binding.tvTwitterId.setText(twitterId)
                        Log.v("city : ", twitterId.toString())
                    }
                }
            }

        })


    }
}