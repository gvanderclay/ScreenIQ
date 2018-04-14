package com.gvanderclay.screeniq.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gvanderclay.screeniq.R
import com.gvanderclay.screeniq.services.TrackingService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TrackingService.startActionInitService(this)
    }
}
