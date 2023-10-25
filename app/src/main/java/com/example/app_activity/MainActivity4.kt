package com.example.app_activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi

class MainActivity4 : BaseActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(applicationContext, MainActivity2::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT
            putExtra("stop", true)
        }
        startActivity(intent)
    }
}
