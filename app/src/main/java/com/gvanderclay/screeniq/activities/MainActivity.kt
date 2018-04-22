package com.gvanderclay.screeniq.activities

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.gvanderclay.screeniq.R
import com.gvanderclay.screeniq.utils.AlarmManagerHelper.Companion.stopAlarmManager
import com.gvanderclay.screeniq.utils.AlarmManagerHelper.Companion.triggerAlarmManager

class MainActivity : AppCompatActivity() {

    lateinit var startButton: Button
    lateinit var pendingIntent: PendingIntent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startButton = findViewById(R.id.start_button)

        val alarmIntent = Intent(this, AlarmReceiver::class.java)
        pendingIntent = PendingIntent.getBroadcast(this, ALARM_REQUEST_CODE, alarmIntent, 0)
        setButtonToStartAlarm()
    }

    private fun setButtonToStopAlarm() {
        startButton.text = getString(R.string.stop_tracking)
        triggerAlarmManager(this,  pendingIntent, 10)
        startButton.setOnClickListener(null)
        startButton.setOnClickListener {
            setButtonToStartAlarm()
        }
    }

    private fun setButtonToStartAlarm() {
        startButton.text = getString(R.string.start_tracking)
        stopAlarmManager(this, pendingIntent)
        startButton.setOnClickListener(null)
        startButton.setOnClickListener {
            setButtonToStopAlarm()
        }
    }

    companion object {
        private var ALARM_REQUEST_CODE = 133;
    }
}
