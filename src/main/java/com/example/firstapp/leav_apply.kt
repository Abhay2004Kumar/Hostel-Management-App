package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class leav_apply : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leav_apply)


        val btn: Button = findViewById(R.id.leave_apply)

        btn.setOnClickListener {
            val Intent = Intent(this, LeaveReport::class.java)
            startActivity(Intent)
        }
    }
}