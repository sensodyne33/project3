package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // set content of this activity from activity_main.xml layout
        setContentView(R.layout.activity_main)

        //click button --> do something
        //it is the done button which is the "view" passed as the argument
        //button is an extension of TextView
        findViewById<Button>(R.id.done_button).setOnClickListener {addNickename(it)
        }
    }

    private fun addNickename(view: View) {
        //view is our button
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        nicknameTextView.text = editText.text
        //hide edittext and button after input
        editText.visibility = View.GONE
        view.visibility = View.GONE
        //make typed nickname visible instead
        nicknameTextView.visibility = View.VISIBLE

        //hide keyboard after done typing
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}