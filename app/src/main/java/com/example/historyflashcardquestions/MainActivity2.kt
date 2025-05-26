package com.example.historyflashcardquestions

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    //declarations of The array of questions/answers and index/score value
    private val questions = arrayOf(
        "The Battle of Blood River in 1838 was fought between the Zulu kingdom and the Voortrekkers",
        "Jan van Riebeeck landed at the Cape in 1652 to start a refreshment station for the Dutch East India Company (VOC)",
        "The Khoikhoi were the first people to farm in southern Africa.",
        "Diamonds were discovered in Kimberley in the 1820s.",
        " Johannesburg is called the City of Gold because of the large gold deposits discovered there in the 19th century."
    )
    private val answers = booleanArrayOf(
        true,
        true,
        false,
        false,
        true
    )
    private var questionIndex: Int = 0
    private var score: Int = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        //referencing the android id of Button/Text to each variable
        val displayView = findViewById<TextView>(R.id.displayText)
        val feedbackView = findViewById<TextView>(R.id.userFeedback)
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        // I used updateQuestions() to automatically update the code

        //Function of the array
        // calling question array to the display so a question can be displayed
        fun updateQuestion() {
            displayView.text = questions[questionIndex]
            feedbackView.text = ""
        }

        updateQuestion()

        //checking for answer and displaying feedback to user if correct or wrong
        fun checkAnswer(userFeedback: Boolean) {
            val correctFeedback = answers[questionIndex]
            if (userFeedback == correctFeedback) {
                feedbackView.text = "Correct!"
                score++
            } else {
                feedbackView.text = "Incorrect!"
            }
        }

        //true or false button setOnClickListener
        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }

        //next button function
        nextButton.setOnClickListener {
            questionIndex++
            if (questionIndex < questions.size) {
                updateQuestion()
            } else {
                //go to results screen and send score
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("Score", score)
                startActivity(intent)
                finish()
                // citation is below!!!
            }
        }
    }
}
//Kotlin Arrays-GeeksforGeeks (2019) Kotlin Array, GeeksforGeeks. Available at: https://www.geeksforgeeks.org/kotlin-array/ (Accessed: 16 May 2025).
//fun updateQuestion-ChatGPT (2025) Chatgpt.com. Available at: https://chatgpt.com/c/6834b417-5360-8002-8945-c9041f925e9d (Accessed: 16 May 2025).
//Intent-Chugh, A. (2022) Android Intent Handling Between Activities Using Kotlin, Digitalocean.com. DigitalOcean. Available at: https://www.digitalocean.com/community/tutorials/android-intent-handling-between-activities-using-kotlin.