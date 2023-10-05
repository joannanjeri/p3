package com.example.p3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * The activity that displays the user's score after answering questions
 * and provides an option to restart the game
 */
class ResultActivity : AppCompatActivity() {
    /** TextView that displays the user's score */
    private lateinit var resultView: TextView

    /** Button that allows the user to restart the game */
    private lateinit var retryButton: Button


    /**
     * Initializes the activity and sets up the UI components and also displays the user's score
     *
     * @param savedInstanceState The saved state of the activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultView = findViewById(R.id.resultView)
        retryButton = findViewById(R.id.retryButton)

        val score = intent.getStringExtra("score")
        resultView.text = "Your score: $score"

        retryButton.setOnClickListener {
            restartGame()
        }
    }

    /**
     * Restarts the game by navigating back to the main activity
     */
    private fun restartGame() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}