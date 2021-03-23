package com.example.guardianchangeapp.welcome

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.guardianchangeapp.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }
    fun startMainActivity( openActivity: Activity){
        val mainIntent = Intent(this,openActivity::class.java)
        startActivity(mainIntent)
        this.finish()
    }
}