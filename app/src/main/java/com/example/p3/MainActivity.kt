package com.example.p3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var difficultyRadioGroup: RadioGroup
    private lateinit var operationRadioGroup: RadioGroup
    private lateinit var numQuestionsEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initializing views
        difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup)
        operationRadioGroup = findViewById(R.id.operationRadioGroup)
        numQuestionsEditText = findViewById(R.id.numQuestionsEditText)

        // setting the click listener for the start button
        val startButton: Button = findViewById(R.id.startButton)
        startButton.setOnClickListener {
            val selectedDifficulty = getSelectedRadioButton(difficultyRadioGroup)
            val selectedOperation = getSelectedRadioButton(operationRadioGroup)

            val numQuestionsText = numQuestionsEditText.text.toString()
            val numQuestions = if (numQuestionsText.isNotEmpty()) {
                numQuestionsText.toInt()
            } else {
                0 // default to 0 if there is not num
            }

//            val resultIntent = Intent(this, ResultActivity::class.java)
//            resultIntent.putExtra("difficulty", selectedDifficulty)
//            resultIntent.putExtra("operation", selectedOperation)
//            resultIntent.putExtra("numQuestions", numQuestions)
//            startActivity(resultIntent)

            val resultIntent = Intent(this, ResultActivity::class.java)
            resultIntent.putExtra("difficulty", selectedDifficulty)
            resultIntent.putExtra("operation", selectedOperation)
            resultIntent.putExtra("numQuestions", numQuestions)
            startActivity(resultIntent)

//            val message = "Difficulty: $selectedDifficulty\nOperation: $selectedOperation\nNumber of Questions: $numQuestions"
//            showToast(message)
        }
    }

    private fun getSelectedRadioButton(radioGroup: RadioGroup): String {
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId
        val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
        return selectedRadioButton.text.toString()
    }

    // showing the toast message
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // implementing the increment and decrement functions
    fun incrementNumber(view: View) {
        val currentNumber = numQuestionsEditText.text.toString().toInt()
        if (currentNumber < 10) {
            numQuestionsEditText.setText((currentNumber + 1).toString())
        }
    }

    fun decrementNumber(view: View) {
        val currentNumber = numQuestionsEditText.text.toString().toInt()
        if (currentNumber > 1) {
            numQuestionsEditText.setText((currentNumber - 1).toString())
        }
    }
}