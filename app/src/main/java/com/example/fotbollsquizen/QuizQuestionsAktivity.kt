package com.example.fotbollsquizen

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions_aktivity.*
import java.lang.NumberFormatException

class QuizQuestionsAktivity : AppCompatActivity(),View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Questions>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions_aktivity)

        mUserName = intent.getStringExtra(Information.USER_NAME)



        mQuestionsList = Information.getQuestions()

        setQuestion()

        tv_svar_ett.setOnClickListener(this)
        tv_svar_två.setOnClickListener(this)
        tv_svar_tre.setOnClickListener(this)
        tv_svar_fyra.setOnClickListener(this)
        btn_bekräfta.setOnClickListener(this)


    }
    private fun setQuestion(){

      
        val question = mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        if(mCurrentPosition == mQuestionsList!!.size){
            btn_bekräfta.text = "AVSLUTA"

        }else{
            btn_bekräfta.text = "BEKRÄFTA"
        }

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
            option.setTextColor(Color.parseColor("#bdbdbd"))
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
            R.id.btn_bekräfta -> {
                if(mSelectedOptionPosition==0){
                    mCurrentPosition ++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        } else ->{
                            val intent = Intent(this,Resultat_aktivitet::class.java)
                        intent.putExtra(Information.USER_NAME, mUserName)
                        intent.putExtra(Information.CORRECT_ANSWERS, mCorrectAnswers)
                        intent.putExtra(Information.TOTAL_QUESTIONS,mQuestionsList!!.size)
                        startActivity(intent)

                    }
                    }
                }else{
                    val question = mQuestionsList?.get (mCurrentPosition -1)
                    if(question!!.rättSvar != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.rättSvar, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        btn_bekräfta.text = "AVSLUTA"

                    }else{
                        btn_bekräfta.text = "GÅ TILL NÄSTA FRÅGA"
                    }
                    mSelectedOptionPosition = 0
                }

            }
        }

    }
    private fun answerView(answer: Int, drawableView: Int){
        when(answer) {
            1 -> {
                tv_svar_ett.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            2 -> {
                tv_svar_två.background = ContextCompat.getDrawable(
                    this,drawableView
                )

            }
            3 -> {
                tv_svar_tre.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            4 ->{
                tv_svar_fyra.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
        }
    }

             // vad som ska hända när man tryckt på något av svaren samt resetar om man byter
    private fun selectedOptionView(tv: TextView,
    selectedOptionNum: Int ) {
        defaultOptionsView()
        mSelectedOptionPosition= selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
}