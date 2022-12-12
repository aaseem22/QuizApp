package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_start: Button = findViewById(R.id.btn_start)
        val editText : AppCompatEditText = findViewById(R.id.editText)
        btn_start.setOnClickListener{
            if(editText.text.toString().isEmpty()){
                Toast.makeText(this,"Please Enter your Name", Toast.LENGTH_SHORT).show()
            }else{
                //intent helps us to move to next page
                                                    // which page to move
                val intent = Intent(this,QuizQue::class.java)

                // here intent is used to make the input name available at the result page
                intent.putExtra(Constants.USER_NAME,editText.text.toString())
                       startActivity(intent)
            finish()
            }
}   }
}

