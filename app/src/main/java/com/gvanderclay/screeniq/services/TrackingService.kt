package com.gvanderclay.screeniq.services

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log
import android.widget.Toast
import java.util.*
import kotlin.concurrent.timerTask

class TrackingService : IntentService("TrackingService") {
    override fun onHandleIntent(intent: Intent?) {
        if (intent != null) {
            val action = intent.action
            if (ACTION_INIT_SERVICE == action) {
                handleActionInitService()
            }
        }
    }

    private fun handleActionInitService() {
        Log.v(TAG, "Tracking Service Started")
    }

    companion object {
        private const val ACTION_INIT_SERVICE = "com.gvanderclay.screeniq.action.INITIALIZE_SERVICE"
        private const val NOTIFICATION_DURATION = "NOTIFICATION_DURATION"

        private const val TAG = "TrackingService"

        fun startActionInitService(context: Context) {
            val intent = Intent(context, TrackingService::class.java)
            intent.action = ACTION_INIT_SERVICE
            context.startService(intent)
        }
    }
}
