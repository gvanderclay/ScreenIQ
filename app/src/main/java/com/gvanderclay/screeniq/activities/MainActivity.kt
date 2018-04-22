package com.gvanderclay.screeniq.activities

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.gvanderclay.screeniq.R
import com.gvanderclay.screeniq.utils.AlarmManagerHelper.Companion.stopAlarmManager
import com.gvanderclay.screeniq.utils.AlarmManagerHelper.Companion.triggerAlarmManager

class MainActivity : AppCompatActivity() {

    private lateinit var startButton: Button
    private lateinit var periodSelector: EditText
    private lateinit var pendingIntent: PendingIntent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPendingIntent()
        initStartButton()
        initPeriodSelector()
    }

    private fun initPeriodSelector() {
        periodSelector = findViewById(R.id.periodSelector)
    }

    private fun initPendingIntent() {
        val alarmIntent = Intent(this, AlarmReceiver::class.java)
        pendingIntent = PendingIntent.getBroadcast(this, ALARM_REQUEST_CODE, alarmIntent, 0)
    }

    private fun initStartButton() {
        startButton = findViewById(R.id.startButton)
        setButtonToStartAlarm()
    }

    private fun setButtonToStopAlarm() {
        startButton.text = getString(R.string.stop_tracking)
        triggerAlarmManager(this, pendingIntent, getTriggerTime())
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

    private fun getTriggerTime(): Int {
        val entry = periodSelector.text
        return entry.toString().toInt()
    }

    companion object {
        private var ALARM_REQUEST_CODE = 133;
    }
}
