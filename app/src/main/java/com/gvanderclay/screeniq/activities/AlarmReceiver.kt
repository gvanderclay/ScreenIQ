package com.gvanderclay.screeniq.activities

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.gvanderclay.screeniq.services.TrackingService

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        TrackingService.startActionInitService(context)
    }
}
