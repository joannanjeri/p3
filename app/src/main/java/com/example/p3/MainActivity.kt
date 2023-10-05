package com.example.p3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

/**
 * The main activity class has everything that involves user input
 */
class MainActivity : AppCompatActivity() {

    /** This radio group selects the difficulty level */
    private lateinit var difficultyRadioGroup: RadioGroup

    /** This radio group selects the operation */
    private lateinit var operationRadioGroup: RadioGroup

    /** This is for the user to specify the number of questions */
    private lateinit var numQuestionsEditText: EditText

    /**
     * This is called when the activity is first created and it initializes the UI components
     *
     * @param savedInstanceState The saved state of the activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** Finds and assigns the RadioGroup responsible for choosing the difficulty */
        difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup)

        /** Finds and assigns the RadioGroup responsible for choosing the operation type */
        operationRadioGroup = findViewById(R.id.operationRadioGroup)

        /** Finds and assigns the EditText where users specify the number of questions */
        numQuestionsEditText = findViewById(R.id.numQuestionsEditText)

        /** Finds and assigns the start button */
        val startButton: Button = findViewById(R.id.startButton)

        /** Sets an onClickListener to the start button to process user selections and go to the next activity */
        startButton.setOnClickListener {

            /** Gets the selected difficulty from the difficulty radio group */
            val selectedDifficulty = getSelectedRadioButton(difficultyRadioGroup)

            /** Gets the selected operation from the operation radio group */
            val selectedOperation = getSelectedRadioButton(operationRadioGroup)

            /** Gets the text for the number of questions */
            val numQuestionsText = numQuestionsEditText.text.toString()

            /** Checks the number of questions from text or defaults to 0 if empty */
            val numQuestions = if (numQuestionsText.isNotEmpty()) {
                numQuestionsText.toInt()
            } else {
                0
            }

            /** Creates an intent to navigate to the NextActivity with the user's selections */
            val nextActivityIntent = Intent(this, NextActivity::class.java)
            nextActivityIntent.putExtra("difficulty", selectedDifficulty)
            nextActivityIntent.putExtra("operation", selectedOperation)
            nextActivityIntent.putExtra("numQuestions", numQuestions)
            startActivity(nextActivityIntent)

            /** Message for the user */
            val message = "Difficulty: $selectedDifficulty\nOperation: $selectedOperation\nNumber of Questions: $numQuestions"
            showToast(message)
        }
    }

    /**
     * Gets the text of the selected radio button within a radio group
     *
     * @param radioGroup The radio group that gets the selected radio button's text
     * @return The text of the selected radio button
     */
    private fun getSelectedRadioButton(radioGroup: RadioGroup): String {
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId
        val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
        return selectedRadioButton.text.toString()
    }

    /**
     * Displays a toast message on the screen
     *
     * @param message The message for the user
     */
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    /**
     * Increases the value in the number input field by 1 and it goes up to 10
     *
     * @param view Shows the button that triggered the method
     */
    fun incrementNumber(view: View) {
        val currentNumber = numQuestionsEditText.text.toString().toInt()
        if (currentNumber < 10) {
            numQuestionsEditText.setText((currentNumber + 1).toString())
        }
    }

    /**
     * Decreases the value in the number input field by 1 and sets that as the min
     *
     * @param view Shows the button that triggered the method
     */
    fun decrementNumber(view: View) {
        val currentNumber = numQuestionsEditText.text.toString().toInt()
        if (currentNumber > 1) {
            numQuestionsEditText.setText((currentNumber - 1).toString())
        }
    }
}