package com.gvanderclay.screeniq.services

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log
import java.util.*
import kotlin.concurrent.timerTask

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 *
 *
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
class TrackingService : IntentService("TrackingService") {


    override fun onHandleIntent(intent: Intent?) {
        if (intent != null) {
            val action = intent.action
            if (ACTION_INIT_SERVICE == action) {
                handleActionInitService()
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionInitService() {
        Timer().schedule(timerTask {
            Log.v(TAG, "Timer finished")
        }, 10000)
    }

    companion object {
        private const val ACTION_INIT_SERVICE = "com.gvanderclay.screeniq.action.INITIALIZE_SERVICE"

        private const val TAG = "TrackingService"

        /**
         * Starts this service to perform action Foo with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        fun startActionInitService(context: Context) {
            val intent = Intent(context, TrackingService::class.java)
            intent.action = ACTION_INIT_SERVICE
            context.startService(intent)
        }
    }
}
