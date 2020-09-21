package com.hardikmahant.jobschedulersample.work_manager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class CounterWorker(
    context: Context,
    workerParameters: WorkerParameters
) : Worker(context, workerParameters) {

    companion object {
        private const val TAG = "CounterWorker"
    }

    override fun doWork(): Result {
        return try {
            for (i in 1..1000) {
                Log.i(TAG, "doWork: $i")
            }
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}