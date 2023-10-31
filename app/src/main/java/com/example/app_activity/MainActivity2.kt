package com.example.app_activity

import android.content.Intent
import android.os.Bundle
import android.util.Log

class MainActivity2 : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(applicationContext, MainActivity3::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()

        Log.d(tag, "has extra: ${intent.hasExtra("toEnd")}")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        val toEnd = intent?.getBooleanExtra("toEnd", false) ?: false
        Log.d(tag, "has extra: ${intent?.hasExtra("toEnd")}, value: $toEnd")

        if (toEnd) {
            val mIntent = Intent(applicationContext, MainActivity5::class.java)
            startActivity(mIntent)
        }
    }
}
