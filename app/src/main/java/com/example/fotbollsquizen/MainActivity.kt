package com.example.fotbollsquizen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.fotbollsquizen.data.name

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById<EditText>(R.id.editText)

        val knapp = findViewById<Button>(R.id.knapp)
        knapp.setOnClickListener {
            name =  editText.text.toString()

            val intent = Intent(this,QuizQuestionsAktivity::class.java)
            intent.putExtra(Information.USER_NAME,editText.text.toString())
            startActivity(intent)
            finish()



        }
    }
}