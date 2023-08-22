package com.rickyslash.reportcrashlyticsapp

import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

class ReleaseTree: Timber.Tree() { // extend Timber.Tree that handles logging message behavior
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) { // this will be called whenever log message issued using Timber
        if (priority == Log.ERROR || priority == Log.WARN) {
            if (t == null) { // log message to Crashlytics if there is no Throwable (exception)
                FirebaseCrashlytics.getInstance().log(message)
            } else {
                FirebaseCrashlytics.getInstance().recordException(t) // send Throwable (exception) information if there is crash to Crashlytics
            }
        }
    }
}