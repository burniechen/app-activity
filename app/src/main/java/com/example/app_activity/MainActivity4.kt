package com.example.app_activity

import android.content.Intent
import android.os.Bundle

class MainActivity4 : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(applicationContext, MainActivity2::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT
            putExtra("stop", true)
        }
        startActivity(intent)
    }
}
