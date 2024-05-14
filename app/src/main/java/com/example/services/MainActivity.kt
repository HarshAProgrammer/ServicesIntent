package com.example.services

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.services.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnStart!!.setOnClickListener(this)
        binding.btnStop!!.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v == binding.btnStart){
            startService(Intent(this,MyService::class.java))
        }else if (v == binding.btnStop){
            stopService(Intent(this,MyService::class.java))

        }
    }


}


