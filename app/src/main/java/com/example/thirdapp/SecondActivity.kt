package com.example.thirdapp// remember to use your actual package name

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
//import android.widget.ImageView
import android.widget.Spinner
//import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.moengage.core.Properties
import com.moengage.core.analytics.MoEAnalyticsHelper
import com.moengage.inapp.MoEInAppHelper

class SecondActivity : AppCompatActivity() {



    private lateinit var bookAppointmentButton: Button

    override fun onStart() {
        super.onStart()
        MoEInAppHelper.getInstance().showInApp(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

         val viewProfileButton : Button = findViewById(R.id.profile_btn)
         val inappButton : Button = findViewById(R.id.inapp_btn)

        // Initialize views
//        val doctorImage = findViewById<ImageView>(R.id.doctor_image)
        val patientName = findViewById<EditText>(R.id.patient_name)
        val patientEmail = findViewById<EditText>(R.id.patient_email)
        val doctorSpinner = findViewById<Spinner>(R.id.doctor_spinner)
        val timeSpinner = findViewById<Spinner>(R.id.time_spinner)
        bookAppointmentButton = findViewById(R.id.book_appointment_btn)

        inappButton.setOnClickListener{

            MoEInAppHelper.getInstance().showInApp(this)
        }



        // Set button click listener
        bookAppointmentButton.setOnClickListener {
            // Implement booking logic, for now, we'll just display a Toast message
//            Toast.makeText(this, "Appointment booked with ${doctorSpinner.selectedItem} at ${timeSpinner.selectedItem}", Toast.LENGTH_SHORT).show()
            Log.i("Booking credentials" , "patient name ${patientName.text} and patient email ${patientEmail.text} and doctor name ${doctorSpinner.selectedItem} and ${timeSpinner.selectedItem}" )

            val properties = Properties()
            properties
                // tracking integer
                .addAttribute("doctor_name", doctorSpinner.selectedItem.toString())
                // tracking string
                .addAttribute("appointment_timing", timeSpinner.selectedItem.toString())
                // tracking date
                .addAttribute("patient_name", patientName.text.toString())
                // tracking double
                .addAttribute("patient_email_id", patientEmail.text.toString())

            MoEAnalyticsHelper.trackEvent(this, "appointment_booked", properties)

            startActivity(Intent(this , Fourth_activity :: class.java))
        }

        viewProfileButton.setOnClickListener {

            startActivity(Intent(this , ThirdActivity::class.java))
//            startActivity(intent)


        }
    }
}