package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CompMess : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comp_mess)



        val btn: Button = findViewById(R.id.new_complain_mess)

        btn.setOnClickListener {
            val Intent = Intent(this, MessComp::class.java)
            startActivity(Intent)
        }
    }
}