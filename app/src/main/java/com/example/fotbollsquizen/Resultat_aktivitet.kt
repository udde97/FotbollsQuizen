package com.example.fotbollsquizen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultat_aktivitet.*

class Resultat_aktivitet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultat_aktivitet)

        val username = intent.getStringExtra (Information.USER_NAME)
        tv_namn.text = username
        val totalQuestions = intent.getIntExtra(Information.TOTAL_QUESTIONS, 0)
        val correctAnswer = intent.getIntExtra(Information.CORRECT_ANSWERS, 0)

        tv_resultat.text = "Ditt resultat blev $correctAnswer av $totalQuestions"

        btn_avsluta.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }


    }
}