package com.example.android.tch_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button

/**
 * Custom ArrayAdapter class to add text to the list of buttons.
 */

                            //Can look at this as a constructor in java
class LessonAdapter(context: Context, listOfActiveLessons: List<Active_Lesson_Object>) : ArrayAdapter<Active_Lesson_Object>(context, 0, listOfActiveLessons) {
                    /*    public LessonAdapter(Context context, List<Active_Lesson_Object> listOfActiveLessons) {
                                super(context, 0, listOfActiveLessons);
                          }
                    */

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //Check if there is an existing list item view (called convertView) that we can reuse, otherwise,
        //if convertView is null, then inflate a new list item layout.
        var listOfLessonView = convertView
        if (listOfLessonView == null) {
            listOfLessonView = LayoutInflater.from(context).inflate(R.layout.active_lessons_template, parent, false)
        }

        //Finds the respective lesson object in the list of lesson objects. It returns the "lesson" object
        //in its respective position makes a variable with a lesson object inside so we can use to return at the end.
        val currentActiveLesson = getItem(position)

        //Creates a button based off the ID that we have that's called Lesson_Button. This can be found in the active_lessons_template.
        val buttonForLesson = listOfLessonView!!.findViewById<View>(R.id.Lesson_Button) as Button

        //Takes the button we just created and sets the text based off the lesson object we created earlier.
        buttonForLesson.text = currentActiveLesson!!.lessonName

        return listOfLessonView

    }
}
