package com.example.dynamicview

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dynamicview.databinding.ActivityMainBinding
import com.example.dynamicview.viewmodel.MainActivityViewModel

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

            // wp7progressBar.hideProgressBar()

            // val msg = serviceSetterGetter.message

            //   lblResponse.text = msg

        })


    }
}