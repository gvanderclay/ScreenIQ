package com.gvanderclay.screeniq.activities

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.gvanderclay.screeniq.services.TrackingService

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "Hello World", Toast.LENGTH_SHORT).show()

        context.startService(Intent(context, TrackingService::class.java))
    }
}
