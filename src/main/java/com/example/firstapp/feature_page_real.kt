package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth

class feature_page_real : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_page_real)

        val btn1:Button = findViewById(R.id.complain)

        btn1.setOnClickListener {
            val Intent=Intent(this,Page_2_new::class.java)
            startActivity(Intent)
            }

        val btn:Button = findViewById(R.id.leave)

        btn.setOnClickListener {
            val Intent=Intent(this,leav_apply::class.java)
            startActivity(Intent)
        }

        findViewById<Button>(R.id.logout_user).setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, Home::class.java))
            finish()
        }
        }
    }