package com.gvanderclay.screeniq.activities

import android.app.AlarmManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.gvanderclay.screeniq.services.TrackingService
import com.gvanderclay.screeniq.utils.triggerAlarmManager

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        TrackingService.startActionInitService(context)
    }
}
