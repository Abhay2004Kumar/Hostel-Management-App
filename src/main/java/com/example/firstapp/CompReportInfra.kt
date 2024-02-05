package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CompReportInfra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comp_report_infra)

        val btn: Button = findViewById(R.id.new_complain_infra)

        btn.setOnClickListener {
            val Intent = Intent(this, InfraComp::class.java)
            startActivity(Intent)
        }
    }
}