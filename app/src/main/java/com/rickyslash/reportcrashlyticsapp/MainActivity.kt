package com.rickyslash.reportcrashlyticsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.crashlytics.FirebaseCrashlytics
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCrash = findViewById<Button>(R.id.btn_crash)
        btnCrash.setOnClickListener {
            FirebaseCrashlytics.getInstance().log("Clicked on crash button") // add log to crashlytics
            FirebaseCrashlytics.getInstance().setCustomKey("str_key", "some_data") // send data to crashlytics
            throw RuntimeException("Test Crash") // imitate throwing exception
        }
    }
}