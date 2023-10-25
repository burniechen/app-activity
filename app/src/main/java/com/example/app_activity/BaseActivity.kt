package com.example.app_activity

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
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
    private lateinit var className: String
    private lateinit var tag: String
    private lateinit var am: ActivityManager

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        className = this::class.java.simpleName
        tag = className

        Log.d(tag, "[$tag] onCreate")
        am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val tasks = am.appTasks
        tasks.forEach {task ->
            Log.d(tag, "id: ${task.taskInfo.taskId}")
            Log.d(tag, "size: ${task.taskInfo.numActivities}")
            Log.d(tag, "base: ${task.taskInfo.baseActivity}")
            Log.d(tag, "top: ${task.taskInfo.topActivity}")
        }
        Log.d(tag, "$className in task No.$taskId")

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
                        Text("this is $className")
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "[$tag] onResume")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(tag, "[$tag] onNewIntent")
    }
}
