package com.example.lab3_smirnov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab3_smirnov.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {

    private lateinit var binding: ActivityMain5Binding

    var correct = 0;
    var incorrect = 0;
    var answerEntered = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        correct = intent.getIntExtra(Const.CORRECT, correct)
        incorrect = intent.getIntExtra(Const.INCORRECT,incorrect)

        binding.button!!.setOnClickListener {
            if (!answerEntered) {
                checkAnswer()
                answerEntered = true
            }
            val intent = Intent(this, MainActivity6::class.java)
            intent.putExtra(Const.CORRECT,correct)
            intent.putExtra(Const.INCORRECT,incorrect)
            startActivity(intent)
        }
    }

    private fun checkAnswer(){
        val correctAnswer:Boolean = binding.switch2.isChecked
        if (correctAnswer) correct++ else incorrect++
    }
}