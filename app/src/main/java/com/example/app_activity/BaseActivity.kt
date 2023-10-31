package com.example.app_activity

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.app_activity.ui.theme.AppactivityTheme

open class BaseActivity : ComponentActivity() {
    lateinit var tag: String
    private lateinit var am: ActivityManager
    private val hashCode = Integer.toHexString(this.hashCode())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tag = this::class.java.simpleName

        Log.d(tag, "===== onCreate =====")
        Log.d(tag, "$tag@$hashCode in task#$taskId")

        am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        am.appTasks.forEach { task ->
            Log.d(tag, "id: ${task.taskInfo.taskId}")
            Log.d(tag, "size: ${task.taskInfo.numActivities}")
            Log.d(tag, "base: ${task.taskInfo.baseActivity?.className}")
            Log.d(tag, "top: ${task.taskInfo.topActivity?.className}")
        }

        setContent {
            AppactivityTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text("this is $tag")
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "===== onResume =====")
        Log.d(tag, "$tag@$hashCode in task#$taskId")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(tag, "===== onNewIntent =====")
        Log.d(tag, "$tag@$hashCode in task#$taskId")
    }
}