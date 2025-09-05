package com.example.planetquiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class AnswersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_answers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the question_id from the navigation arguments
        val questionId = arguments?.getInt("question_id", -1)

        // Get references to the TextViews and Buttons
        val questionTextView: TextView = view.findViewById(R.id.textView_question)
        val resultTextView: TextView = view.findViewById(R.id.textView_result)
        val detailsTextView: TextView = view.findViewById(R.id.textView_details)
        val buttonA: Button = view.findViewById(R.id.button_option_a)
        val buttonB: Button = view.findViewById(R.id.button_option_b)
        val buttonC: Button = view.findViewById(R.id.button_option_c)
        val buttonD: Button = view.findViewById(R.id.button_option_d)

        // Hide the result and details initially
        resultTextView.visibility = View.INVISIBLE
        detailsTextView.visibility = View.INVISIBLE

        when (questionId) {
            1 -> {
                questionTextView.text = getString(R.string.question_1)
                buttonA.text = getString(R.string.earth)
                buttonB.text = getString(R.string.mars)
                buttonC.text = getString(R.string.jupiter)
                buttonD.text = getString(R.string.saturn)

                setButtonListeners(buttonA, buttonB, buttonC, buttonD, buttonC, resultTextView, detailsTextView, R.string.correct_answer_jupiter)
            }
            2 -> {
                questionTextView.text = getString(R.string.question_2)
                buttonA.text = getString(R.string.venus)
                buttonB.text = getString(R.string.saturn)
                buttonC.text = getString(R.string.mars)
                buttonD.text = getString(R.string.mercury)

                setButtonListeners(buttonA, buttonB, buttonC, buttonD, buttonB, resultTextView, detailsTextView, R.string.correct_answer_saturn)
            }
            3 -> {
                questionTextView.text = getString(R.string.question_3)
                buttonA.text = getString(R.string.neptune)
                buttonB.text = getString(R.string.uranus)
                buttonC.text = getString(R.string.earth)
                buttonD.text = getString(R.string.jupiter)

                setButtonListeners(buttonA, buttonB, buttonC, buttonD, buttonB, resultTextView, detailsTextView, R.string.correct_answer_uranus)
            }
        }
    }

    private fun setButtonListeners(
        buttonA: Button,
        buttonB: Button,
        buttonC: Button,
        buttonD: Button,
        correctButton: Button,
        resultTextView: TextView,
        detailsTextView: TextView,
        detailsStringResId: Int
    ) {
        val allButtons = listOf(buttonA, buttonB, buttonC, buttonD)

        for (button in allButtons) {
            button.setOnClickListener {
                if (button == correctButton) {
                    resultTextView.text = getString(R.string.correct)
                    detailsTextView.text = getString(detailsStringResId)
                } else {
                    resultTextView.text = getString(R.string.incorrect)
                    detailsTextView.text = getString(R.string.incorrect_answer)
                }
                resultTextView.visibility = View.VISIBLE
                detailsTextView.visibility = View.VISIBLE
            }
        }
    }
}