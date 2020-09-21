package com.hardikmahant.jobschedulersample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hardikmahant.jobschedulersample.foreground_service.FSActivity
import com.hardikmahant.jobschedulersample.job_scheduler.JobSchedulerActivity
import com.hardikmahant.jobschedulersample.work_manager.WorkManagerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listItems = resources.getStringArray(R.array.app_modules).toList()
        val itemsAdapter = ItemsAdapter(listItems)
        items.apply {
            adapter = itemsAdapter
        }

        itemsAdapter.setOnItemClickListener { _, position ->
            when (position) {
                0 -> startActivity(Intent(this@MainActivity, JobSchedulerActivity::class.java))
                1 -> startActivity(Intent(this@MainActivity, FSActivity::class.java))
                2 -> startActivity(Intent(this@MainActivity, WorkManagerActivity::class.java))
            }
        }
    }
}