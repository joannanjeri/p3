package com.example.p3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    private lateinit var resultView: TextView
    private lateinit var retryButton: Button

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

    private fun restartGame() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}