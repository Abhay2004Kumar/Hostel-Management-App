package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Page_2_new : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2_new)

        val btn: Button = findViewById(R.id.electricity)

        btn.setOnClickListener {
            val Intent = Intent(this, complaint_report::class.java)
            startActivity(Intent)
        }


        val btnB: Button = findViewById(R.id.infrastructure)

        btnB.setOnClickListener {
            val IntentB = Intent(this, CompReportInfra::class.java)
            startActivity(IntentB)
        }

        val btnA: Button = findViewById(R.id.wifi)

        btnA.setOnClickListener {
            val IntentA = Intent(this, CompWifiReport::class.java)
            startActivity(IntentA)
        }

        val btnC: Button = findViewById(R.id.mess_food)

        btnC.setOnClickListener {
            val IntentC = Intent(this, CompMess::class.java)
            startActivity(IntentC)
        }

    }
}