package com.example.testmarvel.ui.splash

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testmarvel.ui.comics.ui.ComicsActivity
import com.example.testmarvel.R

class SplashActivity : AppCompatActivity() {
    lateinit var task : TaskSplash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        task = TaskSplash()
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR)
    }
    inner class TaskSplash() : AsyncTask<Void, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg params: Void?): String? {
            Thread.sleep(2000)
            return ""
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            openActivity()
        }
    }

    private fun openActivity(){
        var intent = Intent(this, ComicsActivity::class.java)
        startActivity(intent)
        finish()
    }
}