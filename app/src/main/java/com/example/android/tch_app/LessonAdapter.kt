package com.example.android.tch_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button

class LessonAdapter(context: Context, listOfActiveLessons: List<Active_Lesson_Object>) : ArrayAdapter<Active_Lesson_Object>(context, 0, listOfActiveLessons) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //Check if there is an existing list item view (called convertView) that we can reuse, otherwise,
        //if covnertView is null, then inflate a new list item layout.
        var listOfLessonView = convertView
        if (listOfLessonView == null) {
            listOfLessonView = LayoutInflater.from(context).inflate(R.layout.active_lessons_template, parent, false)
        }

        val currentActiveLesson = getItem(position)

        val buttonForLesson = listOfLessonView!!.findViewById<View>(R.id.Lesson_Button) as Button

        buttonForLesson.text = currentActiveLesson!!.lessonName

        return listOfLessonView

    }
}
