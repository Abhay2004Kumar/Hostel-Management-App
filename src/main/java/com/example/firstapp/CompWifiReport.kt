package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CompWifiReport : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comp_wifi_report)

        val btn: Button = findViewById(R.id.new_complain_wifi)

        btn.setOnClickListener {
            val Intent = Intent(this, WifiComp::class.java)
            startActivity(Intent)
        }
    }
}