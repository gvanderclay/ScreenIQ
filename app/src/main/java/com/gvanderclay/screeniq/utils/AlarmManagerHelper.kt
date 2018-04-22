package com.gvanderclay.screeniq.utils

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.gvanderclay.screeniq.services.TrackingService
import java.util.*

class AlarmManagerHelper {
    companion object {
        fun triggerAlarmManager(context: Context,
                                pendingIntent: PendingIntent,
                                alarmTriggerTime: Int
                                ) {
            val cal = Calendar.getInstance()
            cal.add(Calendar.SECOND, alarmTriggerTime)
            val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.set(AlarmManager.RTC_WAKEUP, cal.timeInMillis, pendingIntent)
            Toast.makeText(context, "Toast again in 10 seconds", Toast.LENGTH_SHORT).show()
        }

        fun stopAlarmManager(context: Context, pendingIntent: PendingIntent) {
            val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.cancel(pendingIntent)
            context.stopService(Intent(context, TrackingService::class.java))
        }
    }
}