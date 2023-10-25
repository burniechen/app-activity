package com.example.app_activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi

class MainActivity2 : BaseActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(applicationContext, MainActivity3::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        Log.d("extra", "has: ${intent.hasExtra("stop")}")
        if (intent.hasExtra("stop")) {
            val stop = intent.getBooleanExtra("stop", false)
            Log.d("extra", "stop: $stop")
            if (!stop) {
                val intent = Intent(applicationContext, MainActivity3::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.let {
            Log.d("extra", "has: ${intent.hasExtra("stop")}")
            if (it.hasExtra("stop")) {
                val stop = intent.getBooleanExtra("stop", false)
                Log.d("extra", "stop: $stop")
            }
        }
    }
}
