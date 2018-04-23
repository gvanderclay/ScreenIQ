package com.gvanderclay.screeniq.utils

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.util.Log
import android.widget.Toast
import java.util.*

private const val TAG = "AlarmManagerHelper"
fun triggerAlarmManager(context: Context,
                        pendingIntent: PendingIntent,
                        alarmTriggerTime: Int
) {
    val cal = Calendar.getInstance()
    cal.add(Calendar.SECOND, alarmTriggerTime)
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    Log.v(TAG, "Running timer at ${cal.time} every $alarmTriggerTime")
    alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.timeInMillis, pendingIntent)
    Toast.makeText(context, "Tracking every ${secondsToMinutes(alarmTriggerTime)} minutes", Toast.LENGTH_SHORT).show()
}

fun stopAlarmManager(context: Context, pendingIntent: PendingIntent) {
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    alarmManager.cancel(pendingIntent)
}
