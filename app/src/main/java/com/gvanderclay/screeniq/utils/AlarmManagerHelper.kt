package com.gvanderclay.screeniq.utils

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.util.Log
import android.widget.Toast
import java.util.*

private const val TAG = "AlarmManagerHelper"

fun triggerAlarmManager(context: Context, pendingIntent: PendingIntent) {
    val alarmTriggerTime = pendingIntent.
    val cal = Calendar.getInstance()
    Log.v(TAG, "Current time: ${cal.time}")
    cal.add(Calendar.SECOND, alarmTriggerTime)
    val alarmManager = initAlarmManager(context)
    Log.v(TAG, "Running timer at ${cal.time} every $alarmTriggerTime")
    alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.timeInMillis, pendingIntent)
    Toast.makeText(
            context,
            "Tracking every ${secondsToMinutes(alarmTriggerTime)} minutes",
            Toast.LENGTH_SHORT).show()
}

fun stopAlarmManager(context: Context, pendingIntent: PendingIntent) {
    val alarmManager = initAlarmManager(context)
    alarmManager.cancel(pendingIntent)
}

fun initAlarmManager(context: Context): AlarmManager {
    return context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
}
