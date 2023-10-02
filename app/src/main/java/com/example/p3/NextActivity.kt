package com.example.p3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NextActivity : AppCompatActivity() {
    private lateinit var questionText: TextView
    private lateinit var answerText: TextView
    private lateinit var doneButton: Button
//    private lateinit var startButton: Button

    private val questions = mutableListOf(
        "What is 2 + 3",
        "What is 6 * 7",
        "What is 9 - 6",
        "What is 6 / 3",
    )

    private var currentQuestionList = 0
    private var correctAnswers = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        questionText = findViewById(R.id.questionText)
        answerText = findViewById(R.id.answerText)
        doneButton = findViewById(R.id.doneButton)
//        startButton = findViewById(R.id.startButton)

        showQuestion(0)

        doneButton.setOnClickListener {
            checkAnswer()
//            goToMain()
        }
    }

//    private fun goToMain() {
//        val mainIntent = Intent(this, MainActivity::class.java)
//        startActivity(mainIntent)
//        finish()
//    }


    private fun showQuestion(index: Int) {
        if (index < questions.size) {
            questionText.text = questions[index]
            answerText.text.clear()
            currentQuestionList = index
        } else {
            // all q's answered-- shows the results
            val score = "$correctAnswers out of ${questions.size}"
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
            finish()
        }
    }

    private fun checkAnswer() {
        val enteredAnswer = answerText.text.toString().trim()
        val correctAnswer = calculateCorrectAnswer(currentQuestionList)

        if (enteredAnswer == correctAnswer) {
            correctAnswers++
        }

        showQuestion(currentQuestionList + 1)
    }

    private fun calculateCorrectAnswer(questionIndex: Int): String {
        return when (questionIndex) {
            0 -> "5"
            1 -> "42"
            2 -> "3"
            3 -> "3"
            else -> ""
        }
    }

}

private fun CharSequence.clear() {
    TODO("Not yet implemented")
}
