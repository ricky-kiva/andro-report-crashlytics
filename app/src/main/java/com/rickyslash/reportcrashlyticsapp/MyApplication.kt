package com.rickyslash.reportcrashlyticsapp

import android.app.Application
import timber.log.Timber

open class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) { // check if the build is in Debug mode
            Timber.plant(Timber.DebugTree()) // initialize Timber, 'plants' debug tree to help logging
        }
    }
}