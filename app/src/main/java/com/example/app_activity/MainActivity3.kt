package com.example.app_activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi

class MainActivity3 : BaseActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(applicationContext, MainActivity4::class.java)
        startActivity(intent)
    }
}
