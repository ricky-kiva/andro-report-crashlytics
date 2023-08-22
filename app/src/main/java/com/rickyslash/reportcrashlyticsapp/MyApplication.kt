package com.rickyslash.reportcrashlyticsapp

import android.app.Application
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

open class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) { // check if the build is in Debug mode
            Timber.plant(Timber.DebugTree()) // initialize Timber, 'plants' debug tree to help logging
        } else {
            Timber.plant(ReleaseTree()) // plant custom ReleaseTree crash if build is NOT in Debug mode
        }
    }
}