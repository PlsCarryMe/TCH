package com.example.android.tch_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

/**
 * Active Lessons Activity that generates the list of lessons for spelling.
 */
class ActiveLessons : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_active_lessons)

        //Takes JSON string and parses to create a list of lessons.
        val listOfActiveLessons = JSONLessonParser.extractActiveLessons()

        //Finds a reference using the ID "lessons" to create a ListView. You can find this in the
        //"activity_active_lessons.xml file
        val activeLessonView = findViewById(R.id.lessons) as ListView

        //This is creating the LessonAdapter object based off the custom class that we created that takes
        //in a list of active_lesson_objects, and sets the text the way we want to. Uses active_lessons_template.xml for the buttons
        val adapter = LessonAdapter(this, listOfActiveLessons)

        //Sets the adapter with the ListView we created so the list can be populated in the user interface.
        activeLessonView.adapter = adapter

    }
}
