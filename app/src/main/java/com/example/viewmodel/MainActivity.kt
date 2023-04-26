package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvnum = findViewById<TextView>(R.id.no)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.myData.observe(this, { value ->
            tvnum.text = value.toString()
        })
        
    }

}