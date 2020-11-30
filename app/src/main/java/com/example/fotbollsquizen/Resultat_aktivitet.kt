package com.example.fotbollsquizen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultat_aktivitet.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class Resultat_aktivitet : AppCompatActivity(),CoroutineScope {

    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
    get()= Dispatchers.Main + job
    var userList : UserList? = null
    private lateinit var db : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultat_aktivitet)
        job = Job()

        db= AppDatabase.getInstance(this)

        val username = intent.getStringExtra (Information.USER_NAME)
        tv_namn.text = username
        val totalQuestions = intent.getIntExtra(Information.TOTAL_QUESTIONS, 0)
        val correctAnswer = intent.getIntExtra(Information.CORRECT_ANSWERS, 0)

        addNewUser(User(0,username))

        tv_resultat.text = "Ditt resultat blev $correctAnswer av $totalQuestions"

        btn_avsluta.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


    }
    fun addNewUser(user : User){
        userList?.addUser(user)
        launch (Dispatchers.IO){
            db.userDao().insert(user)
        }


        }
    }
