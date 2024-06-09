package com.example.thirdapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.moengage.core.Properties
import com.moengage.core.analytics.MoEAnalyticsHelper
import com.moengage.inapp.MoEInAppHelper

class MiddlePageActivity : AppCompatActivity() {

    override fun onStart() {
        super.onStart()
        MoEInAppHelper.getInstance().showInApp(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_middle_page)

        val book_appointment_button : Button = findViewById(R.id.button_book_appointment)
        val start_free_trial : Button = findViewById(R.id.button_start_free_trial)
        MoEInAppHelper.getInstance().showInApp(this)

        book_appointment_button.setOnClickListener{
            startActivity(Intent(this , SecondActivity :: class.java))

            val properties = Properties()
            MoEAnalyticsHelper.trackEvent(application, "Appointment_booking_initiated", properties)
        }
    }
}