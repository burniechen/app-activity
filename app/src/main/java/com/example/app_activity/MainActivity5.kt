package com.example.app_activity

import android.util.Log

class MainActivity5 : BaseActivity() {
    override fun onResume() {
        super.onResume()
        Log.d(tag, "end!")
    }
}