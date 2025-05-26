package com.example.historyflashcardquestions

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        //get score variable from from mainActivity2 and other var from front end of activity 3
        val score = intent.getIntExtra("Score",0)
        val displayResults = findViewById<TextView>(R.id.displayResults)
        val reviewButton = findViewById<Button>(R.id.reviewbutton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        //displaying the results using score and displayResults TextV
        if (score in 4..5){
            displayResults.text ="Your score is $score out of 5.You are going to ACE the test!!"
        }else if (score in 2..3){
            displayResults.text ="Your score is $score out of 5.GoodLuck you will need it!!"
        }else{
            displayResults.text ="Your score is $score out of 5.Don’t worry—Einstein also failed… but in subjects that were actually hard."
        }
        //review button on set click
        reviewButton.setOnClickListener{
            val answersRevealed ="""
                1. true
                2. true
                3. false
                4. false
                5. true
            """.trimIndent()
            displayResults.text = answersRevealed
        }
        //exit button functioning
        exitButton.setOnClickListener{
            finishAffinity()
        }
    }
}