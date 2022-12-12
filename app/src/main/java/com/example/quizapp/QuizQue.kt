package com.example.quizapp

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat


class QuizQue : AppCompatActivity() , View.OnClickListener{

    // declare variables globally
    private var mFirstPosition : Int = 1 // Default and the first question position
    private var mQueList : ArrayList<Questions>?=null
    private var mSelectedOptionPosition : Int = 0

    private  var mUserName : String? = null
    private var mCorrectAns : Int = 0




    private var progressBar: ProgressBar? = null
    private var progress: TextView? = null
    private var tvImage: ImageView? = null
    private var tvQuestion: TextView? = null

    private var optionOne: TextView? = null
    private var optionTwo: TextView? = null
    private var optionThree: TextView? = null
    private var optionFour: TextView? = null
    private var btnSubmit:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_que)

    // this intent is used to get username from the user to be displayed in the result page
        mUserName= intent.getStringExtra(Constants.USER_NAME)


        //find the var by their id which were given to them in the xml file
        progressBar = findViewById(R.id.progressBar)
        progress = findViewById(R.id.tv_progress)
        tvImage = findViewById(R.id.iv_img1)
        tvQuestion = findViewById(R.id.tv_ques)
        optionOne = findViewById(R.id.tv_option_One)
        optionTwo = findViewById(R.id.tv_option_Two)
        optionThree = findViewById(R.id.tv_option_Three)
        optionFour = findViewById(R.id.tv_option_Four)
        btnSubmit = findViewById(R.id.btn_submit)

        // get questions list from quelist created in the Constants
        mQueList=Constants.getQuestion()
        // 'this ' says that the main class should be onClickListner which it is
        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionView()

        // log is used for logcat , used to display the backend functionality of the app
//        Log.i("Questions Size is ", "${queList.size}")
//
//        for (i in queList) {
//            Log.e("questions", i.question)
//        }

        //"!!" is used because we know are absolutely sure that it is not NULLABLE
                      // we get ques from Questions Data class
        //Getting the question from the list with the help of current position.
        val questions: Questions = mQueList!![mFirstPosition - 1]
        progressBar?.progress = mFirstPosition
        progress?.text = "$mFirstPosition/${progressBar?.max}"
        tvQuestion?.text = questions.question
        tvImage?.setImageResource(questions.image)
        optionOne?.text = questions.optionOne
        optionTwo?.text = questions.optionTwo
        optionThree?.text = questions.optionThree
        optionFour?.text = questions.optionFour

        if(mFirstPosition== mQueList!!.size)
        {
            btnSubmit?.text="FINSIH"
        }else
        {
            btnSubmit?.text="SUBMIT"
        }

    }


    private fun defaultOptionView()
    {
        val options =ArrayList<TextView>()
// we use 'let' because of null type
        optionOne?.let{
            options.add(0,it)
        }
        optionTwo?.let{
            options.add(1,it)
        }
        optionThree?.let{
            options.add(2,it)
        }
        optionFour?.let{
            options.add(3,it)
        }
        for ( option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(
                this,
                    R.drawable.quiz_bg
            )
        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionView()
        mSelectedOptionPosition= selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(
            this, R.drawable.selected_option_bg
        )

    }
    override fun onClick(view: View?) {
       when (view?.id)
       {

           R.id.tv_option_One-> {
               optionOne?.let{
                   selectedOptionView(it,1)
               }
           }
           R.id.tv_option_Two-> {
               optionTwo?.let{
                   selectedOptionView(it,2)
               }
           }
           R.id.tv_option_Three-> {
               optionThree?.let{
                   selectedOptionView(it,3)
               }
           }
           R.id.tv_option_Four-> {
               optionFour?.let{
                   selectedOptionView(it,4)
               }
           }

           R.id.btn_submit ->{
                    if(mSelectedOptionPosition==0) {
                        //to increase the questions
                        mFirstPosition++

                        when {
                            mFirstPosition <= mQueList!!.size -> {
                                setQuestion()
                            }
                            else->{
                                Toast.makeText(this,"Congrats, you have completed the Quiz",Toast.LENGTH_SHORT).show()
                                //intent is used to move to result page
                                val intent = Intent(this, ResultActivity::class.java)
                                intent.putExtra(Constants.USER_NAME,mUserName)
                                intent.putExtra(Constants.CORRECT_ANS, mCorrectAns)
                                intent.putExtra(Constants.TOTAL_QUE, mQueList?.size)
                                startActivity(intent)
                                finish()
                            }
                        }
                    } else {
                                // -1 because of array as array starts from 0
                                val question = mQueList?.get(mFirstPosition - 1)
                                if (question!!.correctAnswer != mSelectedOptionPosition) {
                                    answerView(mSelectedOptionPosition, R.drawable.wrong_option)
                                }else{
                                    mCorrectAns++
                                }
                                answerView(question.correctAnswer, R.drawable.correct_option)

                        if(mFirstPosition==mQueList!!.size)
                        {
                            btnSubmit?.text= "FINISH"
                        }else {
                            btnSubmit?.text = "Go To Next Question"
                        }
                        mSelectedOptionPosition=0
                    }



           }
       }
    }


    private fun answerView( answer: Int, drawableView:Int){
        when(answer)
        {
            1->{
                optionOne?.background= ContextCompat.getDrawable(this,
                    drawableView)
            }
            2->{
                optionTwo?.background= ContextCompat.getDrawable(this,
                    drawableView)
            }
            3->{
                optionThree?.background= ContextCompat.getDrawable(this,
                    drawableView)
            }
            4->{
                optionFour?.background= ContextCompat.getDrawable(this,
                    drawableView)
            }
        }

    }

}