package com.arunava.example.livedatatest.fragmentjourney

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arunava.example.livedatatest.R
import com.arunava.example.livedatatest.fragmentjourney.fragmenta.FragmentA

class FragJourneyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag_journey)

        val fragmentA = FragmentA()
        supportFragmentManager.beginTransaction()
            .add(R.id.contentFrame, fragmentA)
            .commit()
    }
}