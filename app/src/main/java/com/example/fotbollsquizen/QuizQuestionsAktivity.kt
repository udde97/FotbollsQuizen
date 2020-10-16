package com.example.fotbollsquizen

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions_aktivity.*
import java.lang.NumberFormatException

class QuizQuestionsAktivity : AppCompatActivity(),View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Questions>? = null
    private var mSelectedOptionPosition : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions_aktivity)



        mQuestionsList = Information.getQuestions()

        setQuestion()

        tv_svar_ett.setOnClickListener(this)
        tv_svar_två.setOnClickListener(this)
        tv_svar_tre.setOnClickListener(this)
        tv_svar_fyra.setOnClickListener(this)


    }
    private fun setQuestion(){

        val mCurrentPosition = 1
        val question = mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        progressBar.progress = mCurrentPosition
        tv_progress.text= "$mCurrentPosition" + "/"+ progressBar.max

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_svar_ett.text = question.svarEtt
        tv_svar_två.text = question.svarTvå
        tv_svar_tre.text = question.svarTre
        tv_svar_fyra.text = question.svarFyra

    }
              // hur menyn ser ut i default
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,tv_svar_ett)
        options.add(1,tv_svar_två)
        options.add(2,tv_svar_tre)
        options.add(3,tv_svar_fyra)

        for (option in options) {
            option.setTextColor(Color.parseColor("0C7C11"))
            option.typeface = Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )

        }
    }
                 //kallar på selectedOptionView när man tryckt på en knapp
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_svar_ett ->{
                selectedOptionView(tv_svar_ett,1)
            }
            R.id.tv_svar_två ->{
                selectedOptionView(tv_svar_två,2)

            }
            R.id.tv_svar_tre ->{
                selectedOptionView(tv_svar_tre,3)
            }
            R.id.tv_svar_fyra ->{
                selectedOptionView(tv_svar_fyra,4)
            }
        }

    }

             // vad som ska hända när man tryckt på något av svaren samt resetar om man byter
    private fun selectedOptionView(tv: TextView,
    selectedOptionNum: Int ) {
        defaultOptionsView()
        mSelectedOptionPosition= selectedOptionNum

        tv.setTextColor(Color.parseColor("363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
}