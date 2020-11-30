package com.example.fotbollsquizen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.fotbollsquizen.data.name
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(),CoroutineScope{

    private lateinit var job: Job
    override val coroutineContext : CoroutineContext
    get() = Dispatchers.Main + job
    private lateinit var user : User
    private lateinit var  db : AppDatabase
    var userList : UserList? = null

    var currentUser: User? = null

    private lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        job = Job()

        db= AppDatabase.getInstance(this)


        editText = findViewById<EditText>(R.id.editText)

       loadALlUsers()

        val knapp = findViewById<Button>(R.id.knapp)
        knapp.setOnClickListener {


            name =  editText.text.toString()

            val intent = Intent(this,QuizQuestionsAktivity::class.java)
            intent.putExtra(Information.USER_NAME,editText.text.toString())
            startActivity(intent)
            finish()



        }
    }
    fun loadALlUsers(){
        val words =async(Dispatchers.IO) {
            db.userDao().getAll()
        }
        launch {
            val list = words.await().toMutableList()
            userList = UserList(list)
              loadNewUser()
        }
    }

    fun addNewUser(user: User){
        userList?.addUser(user)

        launch(Dispatchers.IO){
            db.userDao().insert(user)
        }
    }
    fun loadNewUser(){
        currentUser = userList?.getNewUser()

        if(currentUser == null)
            return
    }
}