package com.gvanderclay.screeniq.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.gvanderclay.screeniq.R
import com.gvanderclay.screeniq.services.TrackingService

class MainActivity : AppCompatActivity() {

    lateinit var startButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startButton = findViewById(R.id.start_button)

        onStopClicked()
    }

    fun onStartClicked() {
        startButton.text = getString(R.string.stop_tracking)
        startButton.setOnClickListener(null)
        startButton.setOnClickListener {
            onStopClicked()
        }
    }

    fun onStopClicked() {
        startButton.text = getString(R.string.start_tracking)
        startButton.setOnClickListener(null)
        startButton.setOnClickListener {
            onStartClicked()
        }
    }
}
