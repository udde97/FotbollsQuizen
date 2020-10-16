package com.example.fotbollsquizen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val knapp = findViewById<Button>(R.id.knapp)
        lateinit var editText: EditText

        knapp.setOnClickListener {
            val intent = Intent(this,QuizQuestionsAktivity::class.java)
            startActivity(intent)
            finish()

            editText.findViewById<EditText>(R.id.editText)

        }
    }
}