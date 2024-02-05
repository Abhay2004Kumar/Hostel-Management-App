package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class complaint_report : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complaint_report)

        val btn: Button = findViewById(R.id.compelectrc)

        btn.setOnClickListener {
            val Intent = Intent(this, NewCompPage::class.java)
            startActivity(Intent)
        }


    }
}