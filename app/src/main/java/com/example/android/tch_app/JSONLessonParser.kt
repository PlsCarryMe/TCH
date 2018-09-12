package com.example.android.tch_app

import android.util.Log

import org.json.JSONArray
import org.json.JSONException

import java.util.ArrayList

object JSONLessonParser {

    private val PLACEHOLDER_JSON_REPONSE = "[{\"id\":\"24\",\"name\":\"Adjectives(3)\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"162\",\"name\":\"Alphabet (level 1-)\"," +
            "\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"97\",\"name\":\"American Money (1, 2)\"," +
            "\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"2\",\"name\":\"Banking\"," +
            "\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"55\",\"name\":\"Basic Numbers 1\"," +
            "\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"190\",\"name\":\"Basic Numbers 2\"," +
            "\"active\":\"1\",\"hideWord\":\"1\"},{\"id\":\"25\",\"name\":\"Body Parts (1)\"," +
            "\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"22\",\"name\":\"Clothes and Colors\"," +
            "\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"46\",\"name\":\"Clothes and Colors (1, 2)\"," +
            "\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"102\",\"name\":\"Complete the sentences with at, in, on, on top of\"," +
            "\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"29\",\"name\":\"Descriptions(3\\/4)\"," +
            "\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"30\",\"name\":\"Diane-Action Words 1\\/2\"," +
            "\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"26\",\"name\":\"Diane-Classroom Objects\"," +
            "\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"27\",\"name\":\"Diane-Clothing\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"28\",\"name\":\"Diane-Court, Law and Jobs\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"31\",\"name\":\"Diane-Directions 1\\/2\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"32\",\"name\":\"Diane-Emergencies\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"34\",\"name\":\"Diane-Health\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"37\",\"name\":\"Diane-Interview\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"39\",\"name\":\"Diane-Manners\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"40\",\"name\":\"Diane-Measure and Compare\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"117\",\"name\":\"Emergencies (1, 2)\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"44\",\"name\":\"Family\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"99\",\"name\":\"Family (1, 2)\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"33\",\"name\":\"Feelings (2)\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"98\",\"name\":\"Food Containers and Measurement\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"35\",\"name\":\"Hobbies (4)\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"51\",\"name\":\"Housing (1)\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"36\",\"name\":\"Housing Ad\\/Repairs (4)\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"149\",\"name\":\"Job Duties Present Tense Level 1 - 2\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"52\",\"name\":\"Jobs (1)\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"38\",\"name\":\"Jobs (4)\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"168\",\"name\":\"LEP Times and Days\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"146\",\"name\":\"LEP W1 Occupations\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"126\",\"name\":\"LEP W1 Verbs\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"147\",\"name\":\"LEP W2 Application Vocabulary\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"150\",\"name\":\"LEP W2 Basic Objects.\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"151\",\"name\":\"LEP W3 Application Vocabulary\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"157\",\"name\":\"LEP W4 Adjectives (people)\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"152\",\"name\":\"LEP W4 Job Preferences\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"193\",\"name\":\"Linda - Every day, every week Present\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"169\",\"name\":\"Linda - Food 1 level 1,2\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"194\",\"name\":\"Linda - Jobs 2\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"192\",\"name\":\"Linda Food 1 level 2\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"45\",\"name\":\"Linda-Banking\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"175\",\"name\":\"Linda-Descriptions 1\\/2\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"47\",\"name\":\"Linda-Medicine\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"48\",\"name\":\"Linda-Ordinals and Months 1\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"49\",\"name\":\"Linda-Ordinals and Months 2\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"177\",\"name\":\"Linda-Places in the Community\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"50\",\"name\":\"Linda-Weather\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"41\",\"name\":\"Numbers (1)\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"53\",\"name\":\"Personal Information (1)\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"167\",\"name\":\"Phonetics (Level 1-)\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"42\",\"name\":\"Seasons (3)\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"54\",\"name\":\"Sickness (1)\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"43\",\"name\":\"Signs (1)\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"100\",\"name\":\"Simple Prepositions\",\"active\":\"1\",\"hideWord\":\"0\"},{\"id\":\"186\",\"name\":\"test\",\"active\":\"1\",\"hideWord\":\"0\"}]"


    /**
     * Return a list of  objects that has been built up from
     * parsing a JSON response.
     */
    fun extractActiveLessons(): ArrayList<Active_Lesson_Object> {

        // Create an empty ArrayList that we can start adding lessons to
        val listOfActive_Lesson_Objects = ArrayList<Active_Lesson_Object>()

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            // TODO: Parse the response given by the SAMPLE_JSON_RESPONSE string and
            // build up a list of lesson objects with the corresponding data.

            val activeLessonArray = JSONArray(PLACEHOLDER_JSON_REPONSE)

            for (i in 0 until activeLessonArray.length()) {
                //So within the array, we have a bunch of JSON Objects, so what's happening here is we're grabbing each object
                //and going inside the object to specifically grab the properties.
                //The property itself is an object and holds all the data that we need
                val currentActiveLesson = activeLessonArray.getJSONObject(i)

                //Now we're at the level where we can just call the getter methods, with the respective key to pass through
                // BUT MAKE SURE TO HAVE THE RIGHT PRIMITIVE TYPE THAT MATCHES THE DATA/VALUE ATTACHED TO THE KEY
                val nameOfLesson = currentActiveLesson.getString("name")

                //Now we can create lesson object based off the data we collected from the request we made
                val lesson = Active_Lesson_Object(nameOfLesson)

                //And this is the list of lessons
                listOfActive_Lesson_Objects.add(lesson)

            }


        } catch (e: JSONException) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("Pleasehelp", "Problem parsing the Active Lesson JSON results", e)
        }

        // Return the list of lessons
        return listOfActive_Lesson_Objects
    }

}
