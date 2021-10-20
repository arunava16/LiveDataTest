package com.arunava.example.livedatatest.activityjourney.activitya

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.arunava.example.livedatatest.R
import com.arunava.example.livedatatest.activityjourney.activityb.ActivityB

class ActivityA : AppCompatActivity() {

    private lateinit var activityAViewModel: ActivityAViewModel

    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading...")
        progressDialog.setCancelable(false)

        findViewById<Button>(R.id.activity_a_btn).setOnClickListener {
            progressDialog.show()
            activityAViewModel.makeApiCall()
        }

        activityAViewModel = ViewModelProvider(this).get(ActivityAViewModel::class.java)

        activityAViewModel.getSuccessLiveData().observe(this) {
            progressDialog.dismiss()
            val intent = Intent(this, ActivityB::class.java)
            startActivity(intent)
        }
    }
}