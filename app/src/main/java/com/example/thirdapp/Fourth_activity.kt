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
import java.util.Date

class Fourth_activity : AppCompatActivity() {

    override fun onStart() {
        super.onStart()
        MoEInAppHelper.getInstance().showInApp(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        MoEInAppHelper.getInstance().showInApp(this)

        val pay_now : Button = findViewById(R.id.btn_pay_now)
        val pay_at_clinic : Button = findViewById(R.id.btn_pay_at_clinic)

        pay_now.setOnClickListener{

            val properties = Properties()
            properties
                .addAttribute("payment_done", true)
                .addAttribute("appointment_day", Date())
            MoEAnalyticsHelper.trackEvent(application, "appointment_paid", properties)

            startActivity(Intent(this , FifthActivity::class.java))
        }

        pay_at_clinic.setOnClickListener{

            val properties = Properties()
            properties
                .addAttribute("payment_done", false)
                .addAttribute("appointment_day", "Not Fixed")
            MoEAnalyticsHelper.trackEvent(application, "appointment_pay_at_clinic", properties)

            startActivity(Intent(this , FifthActivity::class.java))
        }

    }
}