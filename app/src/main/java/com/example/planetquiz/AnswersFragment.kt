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

        // Get references to all eight Buttons and two TextViews
        val questionTextView: TextView = view.findViewById(R.id.textView_question)
        val resultTextView: TextView = view.findViewById(R.id.textView_result)
        val detailsTextView: TextView = view.findViewById(R.id.textView_details)
        val buttonA: Button = view.findViewById(R.id.button_option_a)
        val buttonB: Button = view.findViewById(R.id.button_option_b)
        val buttonC: Button = view.findViewById(R.id.button_option_c)
        val buttonD: Button = view.findViewById(R.id.button_option_d)
        val buttonE: Button = view.findViewById(R.id.button_option_e)
        val buttonF: Button = view.findViewById(R.id.button_option_f)
        val buttonG: Button = view.findViewById(R.id.button_option_g)
        val buttonH: Button = view.findViewById(R.id.button_option_h)

        // Hide the result and details initially
        resultTextView.visibility = View.INVISIBLE
        detailsTextView.visibility = View.INVISIBLE

        // This list will contain all eight buttons
        val allButtons = listOf(buttonA, buttonB, buttonC, buttonD, buttonE, buttonF, buttonG, buttonH)

        when (questionId) {
            1 -> {
                questionTextView.text = getString(R.string.question_1)
                buttonA.text = getString(R.string.mercury)
                buttonB.text = getString(R.string.venus)
                buttonC.text = getString(R.string.earth)
                buttonD.text = getString(R.string.mars)
                buttonE.text = getString(R.string.jupiter)
                buttonF.text = getString(R.string.saturn)
                buttonG.text = getString(R.string.uranus)
                buttonH.text = getString(R.string.neptune)

                // Show all eight buttons
                allButtons.forEach { it.visibility = View.VISIBLE }

                setButtonListeners(allButtons, buttonE, resultTextView, detailsTextView, R.string.correct_answer_jupiter)
            }
            2 -> {
                questionTextView.text = getString(R.string.question_2)
                buttonA.text = getString(R.string.mercury)
                buttonB.text = getString(R.string.venus)
                buttonC.text = getString(R.string.earth)
                buttonD.text = getString(R.string.mars)
                buttonE.text = getString(R.string.jupiter)
                buttonF.text = getString(R.string.saturn)
                buttonG.text = getString(R.string.uranus)
                buttonH.text = getString(R.string.neptune)

                // Show all eight buttons
                allButtons.forEach { it.visibility = View.VISIBLE }

                setButtonListeners(allButtons, buttonF, resultTextView, detailsTextView, R.string.correct_answer_saturn)
            }
            3 -> {
                questionTextView.text = getString(R.string.question_3)
                buttonA.text = getString(R.string.mercury)
                buttonB.text = getString(R.string.venus)
                buttonC.text = getString(R.string.earth)
                buttonD.text = getString(R.string.mars)
                buttonE.text = getString(R.string.jupiter)
                buttonF.text = getString(R.string.saturn)
                buttonG.text = getString(R.string.uranus)
                buttonH.text = getString(R.string.neptune)

                // Show all eight buttons
                allButtons.forEach { it.visibility = View.VISIBLE }

                setButtonListeners(allButtons, buttonG, resultTextView, detailsTextView, R.string.correct_answer_uranus)
            }
        }
    }

    private fun setButtonListeners(
        buttons: List<Button>,
        correctButton: Button,
        resultTextView: TextView,
        detailsTextView: TextView,
        detailsStringResId: Int
    ) {
        for (button in buttons) {
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