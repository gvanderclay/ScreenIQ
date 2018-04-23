package com.gvanderclay.screeniq.activities

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.gvanderclay.screeniq.R
import com.gvanderclay.screeniq.utils.minutesToSeconds
import com.gvanderclay.screeniq.utils.secondsToMinutes
import com.gvanderclay.screeniq.utils.stopAlarmManager
import com.gvanderclay.screeniq.utils.triggerAlarmManager

class MainActivity : AppCompatActivity() {

    private lateinit var startButton: Button
    private lateinit var periodSelector: EditText
    private lateinit var pendingIntent: PendingIntent

    private var ALARM_REQUEST_CODE = 133;
    private var PERIOD_MIN = 2

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
        triggerAlarmManager(this, pendingIntent, getTriggerTimeInSeconds())
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
            try {
                val triggerTime = getTriggerTimeInSeconds()
                if(validPeriodInput(triggerTime)) {
                    setButtonToStopAlarm()
                }
            } catch(e: NumberFormatException) {
                periodSelector.error = getString(R.string.valid_number)
            }
        }
    }

    private fun validPeriodInput(triggerTime: Int): Boolean {
        if (secondsToMinutes(triggerTime) < PERIOD_MIN) {
            periodSelector.error = getString(R.string.time_greater_than_error)
            return false
        }
        return true
    }

    private fun getTriggerTimeInSeconds(): Int {
        val entry = periodSelector.text
        var seconds = 0
        try {
            seconds = minutesToSeconds(entry.toString().toInt())
        } catch (e: NumberFormatException) {
            throw NumberFormatException()
        }
        return seconds
    }

    companion object {
    }
}
