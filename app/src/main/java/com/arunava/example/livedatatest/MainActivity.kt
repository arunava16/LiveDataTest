package com.arunava.example.livedatatest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.arunava.example.livedatatest.activityjourney.activitya.ActivityA
import com.arunava.example.livedatatest.fragmentjourney.FragJourneyActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.activity_btn).setOnClickListener {
            val intent = Intent(this, ActivityA::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.fragment_btn).setOnClickListener {
            val intent = Intent(this, FragJourneyActivity::class.java)
            startActivity(intent)
        }
    }
}