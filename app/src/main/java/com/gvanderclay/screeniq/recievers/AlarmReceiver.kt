package com.gvanderclay.screeniq.recievers

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import com.gvanderclay.screeniq.activities.MainActivity
import com.gvanderclay.screeniq.services.TrackingService
import com.gvanderclay.screeniq.utils.initAlarmManager

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        TrackingService.startActionInitService(context)
        val alarmManager = initAlarmManager(context)
        val cal = Calendar.getInstance()
        cal.add(Calendar.MINUTE, 1)
        val alarmIntent = Intent(context, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, MainActivity.ALARM_REQUEST_CODE, alarmIntent, 0)
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.timeInMillis, pendingIntent)
    }
}
