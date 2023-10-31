package com.example.app_activity

import android.content.Intent
import android.os.Bundle

class MainActivity3 : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(applicationContext, MainActivity4::class.java)
        startActivity(intent)
    }
}
