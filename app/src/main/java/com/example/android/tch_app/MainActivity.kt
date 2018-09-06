package com.example.android.tch_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun openActiveLessons(view: View) {
        var openActivity = Intent(this, ActiveLessons::class.java)
        startActivity(openActivity)
    }


}
