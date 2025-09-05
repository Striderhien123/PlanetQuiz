package com.example.planetquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class QuestionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_questions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonQuestion1: Button = view.findViewById(R.id.button_question1)
        val buttonQuestion2: Button = view.findViewById(R.id.button_question2)
        val buttonQuestion3: Button = view.findViewById(R.id.button_question3)

        buttonQuestion1.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("question_id", 1)
            findNavController().navigate(R.id.action_questionsFragment_to_answersFragment, bundle)
        }

        buttonQuestion2.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("question_id", 2)
            findNavController().navigate(R.id.action_questionsFragment_to_answersFragment, bundle)
        }

        buttonQuestion3.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("question_id", 3)
            findNavController().navigate(R.id.action_questionsFragment_to_answersFragment, bundle)
        }
    }
}