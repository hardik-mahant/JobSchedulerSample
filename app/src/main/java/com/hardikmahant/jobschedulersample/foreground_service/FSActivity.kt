package com.hardikmahant.jobschedulersample.foreground_service

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hardikmahant.jobschedulersample.R
import kotlinx.android.synthetic.main.activity_fs.*

class FSActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fs)

        btnStartService.setOnClickListener {
            startService()
        }

        btnStopService.setOnClickListener {
            stopService()
        }
    }

    private fun startService() {
        val input = edtName.text.toString()
        val intent = Intent(this@FSActivity, SampleFService::class.java)
        intent.putExtra("input", input)

        startService(intent)
    }

    private fun stopService(){
        val intent = Intent(this@FSActivity, SampleFService::class.java)
        stopService(intent)
    }
}