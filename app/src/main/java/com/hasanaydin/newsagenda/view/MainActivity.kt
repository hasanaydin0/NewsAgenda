package com.hasanaydin.newsagenda.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hasanaydin.newsagenda.R
import com.hasanaydin.newsagenda.databinding.ActivityMainBinding

// API KEY : d9c0b94025e44775aca56658f264e6a2
//  URL : https://newsapi.org/v2/everything?q=bitcoin&apiKey=d9c0b94025e44775aca56658f264e6a2

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }



}