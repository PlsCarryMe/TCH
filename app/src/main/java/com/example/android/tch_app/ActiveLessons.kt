package com.example.android.tch_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ActiveLessons : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_active_lessons)

        //Takes JSON string and parses to create a list of lessons.
        //val listOfActiveLessons = JSONLessonParser.extractLessons()

        val listOfActiveLessons = JSONLessonParser.extractActiveLessons()

        val activeLessonView = findViewById(R.id.lessons) as ListView

        val adapter = LessonAdapter(this, listOfActiveLessons)

        activeLessonView.adapter = adapter

    }
}
