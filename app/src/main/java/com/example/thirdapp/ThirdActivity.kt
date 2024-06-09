package com.example.thirdapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.moengage.core.MoECoreHelper
import com.moengage.inapp.MoEInAppHelper
import com.moengage.inbox.ui.view.InboxActivity

class ThirdActivity : AppCompatActivity() {

    override fun onStart() {
        super.onStart()
        MoEInAppHelper.getInstance().showInApp(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)

        val logout_button: Button = findViewById(R.id.logout_button)
        val inbox_cards : Button = findViewById(R.id.inbox_cards)
        MoEInAppHelper.getInstance().showInApp(this)

        logout_button.setOnClickListener{

            MoECoreHelper.logoutUser(this)

            startActivity(Intent(this , MainActivity::class.java))
        }

        inbox_cards.setOnClickListener{

            val intent = Intent(this, InboxActivity::class.java)
            startActivity(intent)
        }

        }
    }
