package com.example.firstapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val videoView: VideoView = findViewById(R.id.videoView)

        // Set the path of the video file
        val videoPath = "android.resource://" + packageName + "/" + R.raw.splash_test
        val uri: Uri = Uri.parse(videoPath)

        videoView.setVideoURI(uri)

        // Start the video
        videoView.start()

        // Set a listener to navigate to the next screen when the video finishes
        videoView.setOnCompletionListener { mp ->
            val intent = Intent(this@SplashScreen, Home::class.java)
            startActivity(intent)
            finish()
        }
    }
}