package com.example.thirdapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.moengage.core.Properties
import com.moengage.core.analytics.MoEAnalyticsHelper
import com.moengage.inapp.MoEInAppHelper

class MainActivity : AppCompatActivity() {

    lateinit var first_name : EditText
    lateinit var last_name : EditText
    lateinit var email: EditText
    lateinit var phone : EditText
    lateinit var language_pref: EditText
    lateinit var register_btn : Button
    lateinit var bypass_btn : Button

    override fun onStart() {
        super.onStart()
        MoEInAppHelper.getInstance().showInApp(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)






//        MoEPushHelper.getInstance().pushPermissionResponse(applicationContext, true)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


//        MoEAnalyticsHelper.setUniqueId(application, "abcdefghi")



        first_name = findViewById(R.id.first_name)
        last_name = findViewById(R.id.last_name)
        email = findViewById(R.id.email)
        phone = findViewById(R.id.phone)
//        language_pref = findViewById(R.id.language)
        register_btn = findViewById(R.id.signup_btn)
        bypass_btn = findViewById(R.id.bypass_btn)

        bypass_btn.setOnClickListener{

            val intent = Intent(this , MiddlePageActivity::class.java)
            startActivity(intent)
        }
//
        register_btn.setOnClickListener {
            val firstname = first_name.text.toString()
            val lastname = last_name.text.toString()
            val email = email.text.toString()
            val phone = phone.text.toString()


            Log.i("Test Credentials" , "Username: $firstname and password $lastname and $email and $phone")

            MoEAnalyticsHelper.setUniqueId(application, email)
            MoEAnalyticsHelper.setFirstName(application , firstname)
            MoEAnalyticsHelper.setLastName(application , lastname )
            MoEAnalyticsHelper.setUserName(application , "$firstname $lastname")
            MoEAnalyticsHelper.setMobileNumber(application , phone)
            MoEAnalyticsHelper.setEmailId(application , email)
//            MoEAnalyticsHelper.setUserAttribute(application,"language_preference", language)
            MoEAnalyticsHelper.trackDeviceLocale(application)

            val properties = Properties()
            properties
                .addAttribute("user_name", "$firstname $lastname")
            MoEAnalyticsHelper.trackEvent(application, "User Registered", properties)

            val intent = Intent(this , MiddlePageActivity::class.java)
            startActivity(intent)
        }
    }
}