package com.example.quizapp

data class Questions(
    //this data class is as parent class in constants object
    val id: Int,
    val question: String,
    val image: Int,
    val optionOne : String,
    val optionTwo : String,
    val optionThree : String,
    val optionFour : String,
    val correctAnswer: Int,


    )
